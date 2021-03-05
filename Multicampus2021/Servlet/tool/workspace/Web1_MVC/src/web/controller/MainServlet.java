package web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.model.MemberDAO;
import web.util.Member;
import web.util.MyException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	MemberDAO mDao;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			mDao = new MemberDAO();
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			String key = request.getParameter("key");

			if (key == null) {
				throw new MyException("요청을 구별할 수 없습니다");
			} else if (key.equalsIgnoreCase("login")) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = mDao.login(id, pw);
				if (name != null) {
					// 쿠키 세팅
//					Cookie c = new Cookie("test_name", name);
////					Cookie c=new Cookie("login_name", name); // 쿠키 세팅
//					// c.setMaxAge(60*60);
//					response.addCookie(c); // 쿠키 설정

					// 세션 설정
					HttpSession session = request.getSession(true); //기존 세션 객체가 있으면 반환, 없으면 새로생성
					//if 해보기 
					session.setAttribute("login_name", name);

					RequestDispatcher disp = request.getRequestDispatcher("login_ok.jsp");
					request.setAttribute("name", name);
					disp.forward(request, response);
				} else {
					RequestDispatcher disp = request.getRequestDispatcher("login_fail.jsp");
					disp.forward(request, response);
				}

			} else if (key.equalsIgnoreCase("memberList")) {
				List<Member> list = mDao.memberList();
				RequestDispatcher disp = request.getRequestDispatcher("memberlist_ok.jsp");
				request.setAttribute("list", list);
				disp.forward(request, response);

			} else if (key.equalsIgnoreCase("memberInsert")) {
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = request.getParameter("name");
				Member m = new Member(id, pw, name);
				mDao.memberInsert(m);
				RequestDispatcher disp = request.getRequestDispatcher("memberInsert_ok.jsp");
				request.setAttribute("id", id);
				disp.forward(request, response);

			} else if (key.equalsIgnoreCase("memberDelete")) {
				String id = request.getParameter("id");
				mDao.memberDelete(id);
				RequestDispatcher disp = request.getRequestDispatcher("memberDelete_ok.jsp");
				request.setAttribute("id", id);
				disp.forward(request, response);

			} else if (key.equalsIgnoreCase("basketInsert")) { // 장바구니 처리
				HttpSession session = request.getSession(false); //기존 세션 객체가 존재하면 반환, 없으면 null반환
				if (session == null) { //세션이 없었을 때 
					RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
					disp.forward(request, response);
				} else {
					String name = (String) session.getAttribute("login_name");
					if (name == null) {
						RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
						disp.forward(request, response);
					} else {
						// 세션, name 있는 로그인 정상 상태
						String product = request.getParameter("product");
						ArrayList<String> list = (ArrayList<String>) session.getAttribute("basket");
						if (list == null) {
							list = new ArrayList<String>();
							session.setAttribute("basket", list); // 최초 장바구니 세팅
						}
						list.add(product);
						RequestDispatcher disp = request.getRequestDispatcher("basketInsert_ok.jsp");
						disp.forward(request, response);
					}
				}
			} 
		} catch (MyException e) {
			RequestDispatcher disp = request.getRequestDispatcher("error.jsp");
			disp.forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

}
