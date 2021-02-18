package test;

import java.sql.*;


public class InsertTest {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement state = null;
		ResultSet result = null;
		
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver ok");
			
			// 2. 연결
			con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
															"cafe", 
															"1234");
			System.out.println("con ok");
			
			// 3. Statement 생성
			state = con.prepareStatement("insert into member(memid, memname, memdate, phone, point) values(?, ?, ?, ?, ?)");
			state.setString(1, args[0]); // id-첫번째 열에 args[0] 대입
			state.setString(2, args[1]); // name-두번째 열에 args[1] 대입
			java.util.Date today = new java.util.Date(); // 시스템 날짜 정보 
			Date now = new Date(today.getTime());
			state.setDate(3, now); // name-두번째 열에 args[1] 대입
			state.setString(4, args[2]); // 
			state.setInt(5, 0); // 
			
			
		
			// 4. SQL 전송
			 int i=state.executeUpdate();

			
			// 5. 결과 얻기 
			System.out.println(i + "행이 insert되었습니다");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 6. 자원 종료 - 반드시  수행되어야 하므로 finally에서! 
			try {
				if(result != null) result.close();
				if(state != null) state.close();
				if(con != null) con.close(); 
				} catch(SQLException e){
					
				}
			
		}
		
		

	}

}
