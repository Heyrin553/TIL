package test;

import java.sql.*;


public class DropTest {

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
			state = con.prepareStatement("drop table product");
			
			// 4. SQL 전송
			int i=state.executeUpdate();

			
			// 5. 결과 얻기 
			System.out.println(i+"테이블이 삭제되었습니다");
			
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
