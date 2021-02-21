package db.test;

import java.sql.*;
import java.util.ArrayList;

import common.util.StudentException;

public class StudentDAO {
	

	
	public void insertStudent(StudentDTO studentDTO) throws StudentException {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Test","1234");
			stmt = con.prepareStatement("insert into student values(?,?,?,?,?)");
			stmt.setInt(1, studentDTO.getNo());
			stmt.setString(2, studentDTO.getName());
			stmt.setString(3, studentDTO.getDet());
			stmt.setString(4, studentDTO.getAddr());
			stmt.setString(5, studentDTO.getTel());
			
			int i = stmt.executeUpdate();
			System.out.println(i+"행이 insert되었습니다");
		

		} catch (SQLException e) {
			e.printStackTrace();
			throw new StudentException("학생 등록에 실패하였습니다");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		}finally {
				try {
					if(stmt != null)stmt.close();
					if(con != null)con.close();
				} catch (SQLException e) {
				}
		}
	}
	
	public void printAllStudents() throws StudentException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int no = 0;
		String name = null;
		String det = null;
		String addr = null;
		String tel = null;
		
		
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Test","1234");
			stmt = con.prepareStatement("select * from student");
			rs = stmt.executeQuery();
			
			ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
			
			while(rs.next()) {
				no = rs.getInt(1);
				name = rs.getString(2);
				det = rs.getString(3);
				addr = rs.getString(4);
				tel = rs.getString(5);
	
				StudentDTO studentDTO = new StudentDTO(no, name, det, addr, tel);
				list.add(studentDTO);
			}
			if(list.size() != 0) {
				for(StudentDTO ls : list) {
					System.out.println(ls.toString());
				}
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new StudentException("레코드 출력 실패");
		}finally {
			try {
				if(rs != null)rs.close();
				if(stmt != null)stmt.close();
				if(con != null)con.close();
			} catch (SQLException e) {
			}
		}
		
		
	}
}
