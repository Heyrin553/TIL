package web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import web.service.MemberService;

@Controller("loginController")
public class LoginController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value={"/test/loginForm.do","/test/loginForm2.do"},
			method= {RequestMethod.GET})
	public ModelAndView loginForm(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		ModelAndView mav=new ModelAndView("login/loginForm");
		return mav;
	}
	
	@RequestMapping(value={"/test/login.do"},
			method= {RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		String name=memberService.login(id,pw);		
		
		ModelAndView mav=new ModelAndView("login/result");
		mav.addObject("name",name);
		return mav;
	}

}

