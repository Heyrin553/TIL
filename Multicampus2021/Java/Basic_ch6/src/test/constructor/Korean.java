package test.constructor;

public class Korean {
	String nation="대한민국";
	String name;
	String ssn;
	
	public Korean(String n, String s) {
		name=n;
		ssn=s;
//		this.name;(가능)
//		this.nation
//		this.ssn
//		this.s (불가능)
//		this.n (불가능)
	}
	
	public Korean() {
		this("홍길동", "000000-0000000");//자기 자신의 생성자 호출
		//Korean("홍길동", "000000-0000000"); //안됨 
		//this/super는 생성자의 첫 줄에서만 쓰임. 그래서 둘 중에 하나만 와야 함. 아무것도 안 쓰면 자동으로 super가 들어감. 
		
	}
	
	

}
