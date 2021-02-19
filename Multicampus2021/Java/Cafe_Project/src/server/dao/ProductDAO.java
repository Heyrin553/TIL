package server.dao;

import java.sql.*;
import java.util.ArrayList;

import common.entity.ProductDTO;
import common.util.CafeException;

public class ProductDAO {
	
	public ProductDAO() throws CafeException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new CafeException("드라이버 등록 실패");
		}
	}
	
	public void insertProduct(ProductDTO p) throws CafeException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cafe","1234");
			stmt = con.prepareStatement("insert into product(prodCode, prodName, price) values(?, ?, ?)");
			stmt.setString(1, p.getProdCode());
			stmt.setString(2, p.getProdName());
			stmt.setInt(3, p.getPrice());
			
			int i = stmt.executeUpdate();
			System.out.println(i + "행이 insert 되었습니다");
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CafeException("상품 등록에 실패하였습니다.");
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
			}catch(SQLException e) {
				
			}
		}
	}
	
	
	public ArrayList<ProductDTO> selectProduct() throws CafeException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cafe","1234");
			stmt = con.prepareStatement("select * from product");
			rs = stmt.executeQuery();
			
			/* DB에서 가져온 resultset을  service에 그냥 보내주는 게 아니라 가공하여 보내준다.
			 Why? 클래스 각각의 독립성을 위해서. DB에서 가져온 set을 그냥 넘겨주면 service클래스에서도 sql을 임포트해야한다. 
			 각각의 클래스는 자기 기능에 충실해야 하기 때문에, DB데이터를 처리하는 기능의 DAO클래스에서 결과를 가공하는 일까지 맡아서 
			 가공된 데이터를 보내주어야 한다.*/
			
			ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();
			// 가변적 배열 생성
			
			while(rs.next()) {
				String prodCode = rs.getString(1);
				String prodName = rs.getString(2);
				int price = rs.getInt(3);
				
				ProductDTO m = new ProductDTO(prodCode, prodName, price);
				list.add(m); // 첫번째열부터 돌면서 데이터를 꺼내고 그것을 멤버객체에 저장 후 리스트에 추가
			}
			return list; // 멤버만받는 리스트를 리턴하는 메소드로 변경 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CafeException("selectProduct 실패");
		
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				// 종료못한건 굳이 알려줄 필요없음 
			}
		}
	}
	

public void updateProduct() {
	
}

public void deleteProduct() {
	
}

public String selectProduct(String prodCode) throws CafeException {
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	try {
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cafe","1234");
		stmt = con.prepareStatement("select prodName from product where prodCode = ?");
		stmt.setString(1, prodCode);
		rs = stmt.executeQuery();
		
		/* DB에서 가져온 resultset을  service에 그냥 보내주는 게 아니라 가공하여 보내준다.
		 Why? 클래스 각각의 독립성을 위해서. DB에서 가져온 set을 그냥 넘겨주면 service클래스에서도 sql을 임포트해야한다. 
		 각각의 클래스는 자기 기능에 충실해야 하기 때문에, DB데이터를 처리하는 기능의 DAO클래스에서 결과를 가공하는 일까지 맡아서 
		 가공된 데이터를 보내주어야 한다.*/
		
		if(rs.next()) {
			return rs.getString(1);
		}else {
			return null;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		throw new CafeException("selectProduct 실패");
	
	}finally {
		try {
			if(rs != null) rs.close();
			if(stmt!=null)stmt.close();
			if(con!=null)con.close();
		} catch (SQLException e) {
			// 종료못한건 굳이 알려줄 필요없음 
		}
	}
}
}
