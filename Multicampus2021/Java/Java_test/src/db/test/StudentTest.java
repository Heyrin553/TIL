package db.test;

import common.util.StudentException;

public class StudentTest {
	
	public static void main(String[] args) throws StudentException {
		StudentDAO studentDAO = new StudentDAO();
//		StudentDTO studentDTO = new StudentDTO(3, "나길동", "영문학과", "제주", "010-3333-3333");
//		studentDAO.insertStudent(studentDTO);
		studentDAO.printAllStudents();
	}

}
