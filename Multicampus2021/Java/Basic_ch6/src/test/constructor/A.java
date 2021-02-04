package test.constructor;

public class A extends Object{ //자동으로
	private int i;
	private String s;
	
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public A() { //자동으로 
		super(); //자동으로 들어감  
		System.out.println("A() 생성자 호출");
	}
	
//	public A(int i) { 
//		super(); 
//		System.out.println("A(int i) 생성자 호출");
//	}
//	
	public A(int i, String s) { 
		super(); //무조건 첫줄, 안 쓰면 자동으로 컴파일러가 첫줄에 넣어줌 
		setI(i);
		setS(s);
		System.out.println("A(int i, String s) 생성자 호출");
	}

	public static void main(String[] args) {
		//A a1=new A();
		//A a2=new A(10);
		A a3=new A(20, "java");
		//A a4=new A();
	}
}
