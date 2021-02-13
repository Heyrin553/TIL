package test.inheritance;

public class People {
	private String name, ssn;
	
	public People() {
		super();
	}

	public People(String name, String ssn) {
		super();
		this.name = name;
		this.ssn = ssn;
	}
	

}

class Student extends People{
	//자동으로 디폴트 생성자를 넣어주는데, People 에는 argument를 안 받는 생성자가 없기 때문에 컴파일 에러 발생 
	
}
