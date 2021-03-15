package my.heyrin.cake;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import my.heyrin.cake.service.MemberService;
import my.heyrin.cake.util.MyException;
import my.heyrin.cake.vo.MemberVO;

@Controller
public class HomeController {

	@Autowired
	MemberService memberService;

	@RequestMapping(value = "login.heyrin", 
			method= {RequestMethod.POST},
			produces = "application/text; charset=utf8")			
	@ResponseBody
	public String login(HttpServletRequest request,
			HttpServletResponse response){
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");		
		
		try {
			MemberVO m=new MemberVO(id,pw); 
			String name=memberService.login(m);
			if(name!=null) {
				HttpSession session=request.getSession();
				session.setAttribute("member", m);
				return id+"님 환영합니다";
			}else {
				return "로그인 실패";
			}
		}catch(Exception e) {
			return e.getMessage();
		}		
	}
	

	@RequestMapping(value = "memberInsert.heyrin", method = {
			RequestMethod.POST }, produces = "application/text; charset=utf8") // 한글 처리
	@ResponseBody
	public String memberInsert(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		System.out.println("memberInsert:" + id + "\t" + pw + "\t" + name);

		try {
			MemberVO m = new MemberVO(id, pw, name);
			memberService.memberInsert(m);
			return name + "님 회원가입 되셨습니다";
		} catch (MyException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}

	}

//	@RequestMapping(value = "login.heyrin")
//	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
//
//		System.out.println(1);
//		ModelAndView mav = new ModelAndView("login_ok");
//		return mav;
//
//	}

}
