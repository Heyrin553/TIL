package test;

import java.sql.*;


public class SelectTest2 {

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
															"cafe", 
															"1234");
			System.out.println("con ok");
			
			// 3. Statement 생성
			state = con.createStatement();
			System.out.println("state ok");
			
			// 4. SQL 전송
			result = state.executeQuery("select * from product");
//			System.out.println(result);
			
			// 5. 결과 얻기 
			while(result.next()) {
				int pno = result.getInt(1);
				String pname = result.getString(2);
				int price = result.getInt(3);
				System.out.println(pno+"|"+pname+"|"+price);
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
