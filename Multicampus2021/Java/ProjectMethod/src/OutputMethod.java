
public class OutputMethod {
	
	public static String a() {
		// ... 
		return "a"; //메소드의 실행결과, output, 메소드를 종료시키는 역할
	}
	
	public static int one() {
		return 1; //메소드의 실행결과, output, 메소드를 종료시키는 역할
	}

	public static void main(String[] args) { //void -리턴값이 없음을 의미 
		System.out.println(a());
		System.out.println(one());
	}
}
