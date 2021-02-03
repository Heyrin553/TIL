package test.datatype;

public class StringTest {

	public static void main(String[] args) {
		String s1=new String("java");
		String s2=new String("java");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1==s2);
		
		String s3="java";
		String s4="java";
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s3==s4);
		// 오로지 스트링에서만! 상식을 벗어난 해결을 함. 메모리 비효율을 없애기 위해
		// 그래서 제시한 표현법: String s3="java" (new를 사용하지 않음!)

	}

}
