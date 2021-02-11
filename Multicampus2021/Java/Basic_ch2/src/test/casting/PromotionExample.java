package test.casting;

public class PromotionExample {

	public static void main(String[] args) {
		byte byteValue = 10;
		int intValue = byteValue; //int <- byte
		System.out.println(intValue); // 10
		
		char charValue = '가';
		intValue = charValue; // int <- char
		System.out.println("가의 유니코드=" + intValue); // 44032
		
		intValue = 500;
		long longValue = intValue; // long <- int
		System.out.println(longValue); // 500
		
		intValue = 200;
		double doubleValue = intValue; // double <- int
		System.out.println(doubleValue); //200.0
		
		// 작은 크기 타입이 큰 크기 타입에 저장될 때는 자동 타입 변환 발생. 

	}

}
