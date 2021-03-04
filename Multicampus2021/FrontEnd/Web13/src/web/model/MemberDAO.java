package web.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.util.Member;
import web.util.MyException;

public class MemberDAO {
	DataSource dbcp;

	public MemberDAO() throws MyException {
		try {
			Context ctx=new InitialContext();
			Context envContext=(Context)ctx.lookup("java:/comp/env");
			dbcp=(DataSource)envContext.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new MyException("자원 찾기 오류");
		}
		
		
	}

	public void memberInsert(Member m) throws MyException {

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			// 2. Connection -커넥션 대여 
			con = dbcp.getConnection();
			// 3. stmt 생성
			stmt = con.prepareStatement("insert into member(memid, memname, subject, pw) values(?, ?, ?, ?)");
			// 4. SQL전송
			stmt.setString(1, m.getId());
			stmt.setString(2, m.getName());
			String subject = " "; // 아무것도 선택 안하면 공백으로 들어감
			for (String s : m.all_subject) {
				subject += s + ", ";
			}
			stmt.setString(3, subject); // java, c, python
			stmt.setString(4, m.getPw());

			int i = stmt.executeUpdate();
			// 5. 결과확인
			System.out.println(i + "행이 insert 되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyException("회원 가입 오류");
		} finally {
			// 6. 종료
			try {
				if (con != null)
					con.close(); // 자동 반납 
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public List<Member> listMembers() throws MyException {
		List<Member> list = new ArrayList<Member>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 2. Connection
			con = dbcp.getConnection();
			// 3. stmt 생성
			stmt = con.prepareStatement("select * from member");
			rs = stmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("memid");
				String pw = rs.getString("pw");
				String name = rs.getString("memname");
				Member m = new Member(id, pw, name);
				list.add(m);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyException("모든 고객 조회 실패");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String login(String id, String pw) throws MyException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 2. Connection
			con = dbcp.getConnection();
			// 3. stmt 생성
			stmt = con.prepareStatement("select * from member where memid=? and pw=?");
			stmt.setString(1, id);
			stmt.setString(2, pw);
			
			rs = stmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("memname");
				return name;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyException("로그인 실패");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void deleteMember(String id) throws MyException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			// 2. Connection -커넥션 대여 
			con = dbcp.getConnection();
			// 3. stmt 생성
			stmt = con.prepareStatement("delete from member where memid=?");
			// 4. SQL전송
			stmt.setString(1, id);

			int i = stmt.executeUpdate();
			// 5. 결과확인
			System.out.println(i + "행이 delete 되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyException("회원 삭제 오류");
		} finally {
			// 6. 종료
			try {
				if (con != null)
					con.close(); // 자동 반납 
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}