package test.string;

public class Test {

	public static void main(String[] args) {
		String s1 = new String("java");
		String s2 = new String("java");
		String s3 = "java";
		String s4 = "java"; 
		System.out.println(s3 == s4); 
		
		/* 배열은 한 번 길이가 정해지면 바꿀 수 없음. 
		concat등 메소드를 호출해 문자열을 추가하는 경우 원래 객체가 변경되는 것이 아니라 변경 내용이 반영된 새 객체가 생성되어 문자열이 추가됨. 
		따라서 새 객체를 새 변수에 초기화시켜야 그 값을 활용 가능. 
		단, String Literal Pool 에 생성된 문자열의 경우 +연산자를 이용해 문자열을 추가하면 인스턴스 영역이 아닌 SPL영역에 생성됨. 
		*/
		s1 = s1.concat("1");
//		String s5 = s1.concat("1");
//		String s6 = s2.concat("1");
		
//		String s7 = s3.concat("1");
//		String s8 = s4.concat("1");
//		System.out.println(s7);
//		System.out.println(s8);
//		System.out.println(s7 == s8); // s7과 s8은 concat 메소드를 사용하면서 각각 인스턴스 영역에 생성되므로 false 
		
		String s9 = s3 + "1"; //변수에 "1"을 더하면 인스턴스 영역에 생성됨 
		
		String s10 = s4 + "1";
		System.out.println(s9 == s10); // ?? 
		
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
//		System.out.println(s4);
//		System.out.println(s5);
//		System.out.println(s6);
//		System.out.println(s7);
//		System.out.println(s8);
		
		// StringBuffer - 변경이 많고 다중 스레드 상황에서 사용 
		StringBuffer sb1 = new StringBuffer("java");
		StringBuffer sb2 = sb1.append("12");
		StringBuffer sb3 = sb1.append("1234567890123456"); 
		// 배열의 길이가 16이내에서는 뒷부분에 추가되다가 16을 넘어가면 새로운 객체로 생성되고 원래 객체와의 연결은 끊어짐. 
		
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println(sb3);
		System.out.println(sb1 == sb2);
		
		
		
		StringBuilder sbd1 = new StringBuilder("java");
		StringBuilder sbd2 = sbd1.append("1234567890123456");
		
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println(sb1 == sb2);
		
	}

}
