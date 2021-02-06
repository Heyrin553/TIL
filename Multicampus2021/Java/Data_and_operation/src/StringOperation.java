
public class StringOperation {

	public static void main(String[] args) {
		// 문자열이 일억글자라고 상상해 보자. 
		System.out.println("Hello world".length()); // 11
		System.out.println("안녕 세상".length()); //5
		System.out.println("Hello, HJ ... bye. ".replace("HJ", "JY")); //Hello, JY ... bye.
		System.out.println("Hello, [[[name]]] ... bye. ".replace("[[[name]]]", "HJ")); //Hello, HJ ... bye.
		
	}
}
