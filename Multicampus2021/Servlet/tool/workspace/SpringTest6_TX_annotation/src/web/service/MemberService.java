package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.MemberDAO;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberDAO;
	
	public String login(String id,String pw) {
		return memberDAO.login(id, pw);
	}
}
