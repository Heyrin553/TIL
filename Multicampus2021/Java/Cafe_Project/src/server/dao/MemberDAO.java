package server.dao;

import java.sql.*;
import java.util.ArrayList;

import common.entity.MemberDTO;
import common.util.CafeException;

public class MemberDAO { // JDBC 수행 
	
	public MemberDAO() throws CafeException{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new CafeException("오라클 드라이버 등록 실패했어요"); // 나의 exception사용 -임의로 메시지를 작성가능
		}
	}
			
	
	public void insertMember(MemberDTO m) throws CafeException {
		Connection con = null;
		PreparedStatement state = null;
		
		try {
			//연결 - 왜 연결을 매번 생성? 연결 하나만 만들면 하나 하는동안 다른사람은 기다려야됨. 
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cafe","1234");
			// 한 번밖에 안 쓸거면 변수따로지정하지말고 직접하기 
			state = con.prepareStatement("insert into member values(?,?,?,?,?)");
			state.setString(1, m.getMemId());
			state.setString(2, m.getName());
			state.setDate(3, new Date(m.getmDate().getTime()));
			state.setString(4, m.getPhone());
			state.setInt(5, m.getPoint()); 
			
			int i = state.executeUpdate();
			System.out.println(i+"행이 insert되었습니다");
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CafeException("회원 등록에 실패하였습니다.");
		}finally {
			try {
				if(state!=null)state.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				// 종료못한건 굳이 알려줄 필요없음 
			}
		}
		
	}
	
	public ArrayList<MemberDTO> selectMember() throws CafeException {
		Connection con = null;
		PreparedStatement state = null;
		ResultSet result = null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cafe","1234");
			state = con.prepareStatement("select * from member");
			result = state.executeQuery();
			
			/* DB에서 가져온 resultset을  service에 그냥 보내주는 게 아니라 가공하여 보내준다.
			 Why? 클래스 각각의 독립성을 위해서. DB에서 가져온 set을 그냥 넘겨주면 service클래스에서도 sql을 임포트해야한다. 
			 각각의 클래스는 자기 기능에 충실해야 하기 때문에, DB데이터를 처리하는 기능의 DAO클래스에서 결과를 가공하는 일까지 맡아서 
			 가공된 데이터를 보내주어야 한다.*/
			
			ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
			
			while(result.next()) {
				String id = result.getString(1);
				String name = result.getString(2);
				Date date = result.getDate(3);
				String phone = result.getString(4);
				int point = result.getInt(5);
				
				MemberDTO m = new MemberDTO(id, name, date, phone, point);
				list.add(m); // 첫번째열부터 돌면서 데이터를 꺼내고 그것을 멤버객체에 저장 후 리스트에 추가
			}
			return list; // 멤버만받는 리스트를 리턴하는 메소드로 변경 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CafeException("selectMember 실패");
		
		}finally {
			try {
				if(result != null) result.close();
				if(state!=null)state.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				// 종료못한건 굳이 알려줄 필요없음 
			}
		}	
	}

		
	public void updateMember() {
		
	}
	
	public void deleteMember() {
		
	}


	public String selectMember(String memId) throws CafeException {
		Connection con = null;
		PreparedStatement state = null;
		ResultSet result = null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cafe","1234");
			state = con.prepareStatement("select memName from member where memId = ?");
			state.setString(1, memId);
			result = state.executeQuery();
			
			/* DB에서 가져온 resultset을  service에 그냥 보내주는 게 아니라 가공하여 보내준다.
			 Why? 클래스 각각의 독립성을 위해서. DB에서 가져온 set을 그냥 넘겨주면 service클래스에서도 sql을 임포트해야한다. 
			 각각의 클래스는 자기 기능에 충실해야 하기 때문에, DB데이터를 처리하는 기능의 DAO클래스에서 결과를 가공하는 일까지 맡아서 
			 가공된 데이터를 보내주어야 한다.*/
			
			if(result.next()) {
				return result.getString(1);
			}else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CafeException("selectMember 실패");
		
		}finally {
			try {
				if(result != null) result.close();
				if(state!=null)state.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				// 종료못한건 굳이 알려줄 필요없음 
			}
		}
	}
}
