package test.casting;

public class OperationPromotionExample {

	public static void main(String[] args) {
		byte byteValue1 = 10;
		byte byteValue2 = 20;
		//byte byteValue1 + byteValue2; // 정수연산은 int타입이 기본이므로 컴파일 에러 
		int intValue1 = byteValue1 + byteValue2;
		System.out.println(intValue1); // 30
		
		char charValue1 = 'A';
		char charValue2 = 1; // 유니코드로 저장
		int intValue2 = charValue1 + charValue2;
		System.out.println(charValue1); // A
		System.out.println((int)charValue1); //65
		System.out.println("유니코드 = " + intValue2); // 66
		System.out.println("출력문자 = " + (char)intValue2); // B
		
		int intValue3 = 10;
		int intValue4 = intValue3 / 4;
		System.out.println(intValue4); // 2
		
		int intValue5 = 10;
		//int intValue6 = 10 / 4.0; // 실수 연산 결과를 int에 저장할 수 없으므로 컴파일 에러 
		double doubleValue = intValue5 / 4.0;
		System.out.println(doubleValue); // 2.5
		
		char charValue = 'A';
		//short shortValue = charValue; // 컴파일 에러- char는 short로는 변환할 수 없고, int로는 가능하다 
		
		String strValue = "A";
		//char var = (char) strValue; // 컴파일 에러 - String타입을 char로 변환할 수는 없다. 
		
		
	}

}
