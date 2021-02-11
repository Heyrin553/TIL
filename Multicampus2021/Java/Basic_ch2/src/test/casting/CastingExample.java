package test.casting;

public class CastingExample {

	public static void main(String[] args) {
		int intValue = 44032; //'가'의 유니코드 저장 
		char charValue = (char) intValue;
		System.out.println(charValue); // 가 
		
		long longValue = 500;
		intValue = (int) longValue;
		System.out.println(intValue); // 500 - int타입이 수용 가능한 범위 내의 값이므로 손실 안 일어남 
		
		long longValue2 = 5000000000000L;
		intValue = (int) longValue2;
		System.out.println(intValue); // 658067456 - int타입이 수용 가능한 범위를 초과하여 손실 일어남 
		
		double doubleValue = 3.14;
		intValue = (int) doubleValue;
		System.out.println(intValue); // 3
		

	}

}
