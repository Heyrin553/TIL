package web.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import web.util.Member;
import web.util.MyException;

public class MemberDAO {

	public MemberDAO() throws MyException {
		// 1. 드라이버 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new MyException("드라이버 등록 오류");
		}
	}

	public void memberInsert(Member m) throws MyException {

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			// 2. Connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "cafe", "1234");
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
					con.close();
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
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "cafe", "1234");
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
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "cafe", "1234");
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
}