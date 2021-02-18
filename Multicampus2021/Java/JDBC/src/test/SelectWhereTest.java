package test;

import java.sql.*;


public class SelectWhereTest {

	public static void main(String[] args) {
		Connection con = null;
		Statement state = null;
		ResultSet result = null;
		
		try {
			// 1. Driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver ok");
			
			// 2. 연결
			con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
															"shop", 
															"1234");
			System.out.println("con ok");
			
			// 3. Statement 생성
			state = con.createStatement();
			System.out.println("state ok");
			
			// 4. SQL 전송
			result = state.executeQuery("select * from membertbl where memberaddress like '%"+args[1]+"%'");
//			System.out.println(result);
			
			// 5. 결과 얻기 
			while(result.next()) {
				String id = result.getString("MEMBERID");
				String name = result.getString(2);
				String addr = result.getString(3);
				System.out.println(id+"|"+name+"|"+addr);
			}
			
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
