package web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sign = request.getParameter("sign");
		if (sign == null) {
			return;
		} else if (sign.equals("login")) {
			String id = request.getParameter("id");
			// dao로 login 수행했다치고
			// login ok
			HttpSession session = request.getSession(); // 세션가져왔니? 없으면 생성 session에 할당
			System.out.println(id+"의 세션"+session.getId()); //세션 id 출력해보기
			session.setAttribute("login_id", id); //id(값)를 login_id(이름)로 설정
			
			RequestDispatcher disp=request.getRequestDispatcher("login_ok.jsp");
			disp.forward(request, response);

		} else if(sign.equals("logout")) { //로그아웃
			HttpSession session=request.getSession(false); //새로생성하지않음
			if(session!=null) {
				session.invalidate();  
				RequestDispatcher disp=request.getRequestDispatcher("index.html"); //로그아웃 후 첫 페이지로
				disp.forward(request, response);
			}
		}
	}

}
