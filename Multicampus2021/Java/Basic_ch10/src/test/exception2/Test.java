package test.exception2;

public class Test {

	public static void main(String[] args) {
		
		Calculator c=new Calculator();
		int result=0;
		try {
			result = c.divide(100, 2);
			c=null;
			c.divide(50, 2);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}finally { 
		System.out.println(result);
		
		System.out.println("중요한 일 시작");
		}
	}
}
