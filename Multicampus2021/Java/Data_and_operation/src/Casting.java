
public class Casting {

	public static void main(String[] args) {
		double a = 1.1;
		double b = 1;
		System.out.println(b); // 1.0 -> 자동으로 double로 convert됨.잃어버리는 값 없음 (묵시적 형 변환)
		
//		int c = 1.1; //cannot convert from double to int
		double d = 1.1;
		int e = (int) 1.1;
		System.out.println(d); // 1.1
		System.out.println(e); // 1 -> 강제로 convert됨. 0.1만큼의 손실이 일어날 수 있기 때문에 자동 타입 변환 불가능. (명시적 형 변환)
		
		String f = Integer.toString(11); 
		System.out.println(f); // 정수 11을 문자열 11로 변환
		System.out.println(f.getClass()); //변수의 데이터 타입을 알아보는 메소드 - class java.lang.String

	}

}
