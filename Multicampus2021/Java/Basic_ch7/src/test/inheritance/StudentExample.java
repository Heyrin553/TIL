package test.inheritance;

public class StudentExample {

	public static void main(String[] args) {
		Student student = new Student("길동", "123-456", 10);
		System.out.println("name: "+student.name);
		System.out.println("ssn: "+student.ssn);
		System.out.println(("studentNo: "+student.studentNo));

	}

}
