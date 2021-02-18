package server.service;

import java.util.ArrayList;

import common.entity.Member;
import common.util.CafeException;
import server.dao.MemberDAO;

public class MemberService {
	// 왜 하는일도 없이 전달만?? 나중에 확장성을 위해 좋음. 
	// 다른 연산을 하거나 다른 서버와의 연동을 하는 역할. 
	
	MemberDAO mdao;
	
	public MemberService() throws CafeException { // 어떤 exception인지 ui쪽에서 알도록 하기 위해 try-catch하지 않음!
		mdao = new MemberDAO(); 
		/*MemberService가 생성될 때 MembeDAO도 함께 생성됨 
		 -> 수명이 같은 객체! (클래스 다이어그램에서 실선으로 표시)*/
	}

	public void insertMember(Member m) throws CafeException {
		mdao.insertMember(m);
		
	}

	public ArrayList<Member> selectMember() throws CafeException {
		return mdao.selectMember(); // 위임, delegate pattern 
		
	}
	

}
