package web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.MemberService;

public class MemberControllerImpl extends MultiActionController implements MemberController{
	
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService=memberService;
		
	}
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List memberList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}

}
