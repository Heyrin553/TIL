# 데이터와 연산

각 데이터마다 그 데이터에 맞는 처리 방식이 존재함. 

자바에서는 데이터를 어떻게 정리정돈 하고 있으며, 각 데이터마다 어떤 연산이 존재하는가? 



## 데이터 타입

```java
public class Datatype{
	public static void main(String[] args) {
		System.out.println(6); //Number
		System.out.println("six"); //String 
		System.out.println("6"); //String 6 
		
		System.out.println(6+6); //12
		System.out.println("6"+"6"); //String 66, 문자열을 위한 결합 연산이 사용됨 
		System.out.println(6*6); //36
//		System.out.println("6"*"6"); //Unresolved compilation problem
		
		System.out.println("1111".length()); //4
//		System.out.println(1111.length()); //Unresolved compilation problems
	}
}
```

데이터 타입을 구분하는 이유는 각 데이터 타입마다 그에 맞는 처리 방식이 있기 때문. 

Java 에는 여러 데이터 타입이 존재. 문자와 숫자는 가장 핵심적인 데이터 타입. 



## 숫자와 연산

```java
public class Number {

	public static void main(String[] args) {
		//Operator
		System.out.println(6 + 2); //8
		System.out.println(6 - 2); //4
		System.out.println(6 * 2); //12
		System.out.println(6 / 2); // 3
		
		System.out.println(Math.PI); //3.141592653589793 
		System.out.println(Math.floor(Math.PI)); //3.0 (내림) 
		System.out.println(Math.ceil(Math.PI)); //4.0 (올림)

	}
}
```

Math클래스를 불러와서 숫자와 관련된 다양한 연산을 수행할 수 있다. 



## 문자열의 표현

```java
public class StringApp {

	public static void main(String[] args) {
		// Char VS String
		System.out.println("Hello World"); // String
		System.out.println('H'); // Char
		System.out.println("H"); // String 
		
		System.out.println("Hello "
				+ "World"); // 줄바꿈을 해도 그대로 Hello World 출력 
		
		// new line
		System.out.println("Hello \nWorld"); // 줄바꿈
		
		// escape 
		System.out.println("Hello \"World\""); // Hello "World"

	}

}
```



## 문자열 다루기 

```java
public class StringOperation {

	public static void main(String[] args) {
		// 문자열이 일억글자라고 상상해 보자. 
		System.out.println("Hello world".length()); // 11
		System.out.println("안녕 세상".length()); //5
		System.out.println("Hello, HJ ... bye. ".replace("HJ", "JY")); //Hello, JY ... bye.
		System.out.println("Hello, [[[name]]] ... bye. ".replace("[[[name]]]", "HJ")); //Hello, HJ ... bye.
		
	}
}
```

문자열 중 일부를 치환해주는 replace( )를 활용해 수천 통의 메시지에 이름을 기입하는 수고로움을 덜 수 있을 것이다. (SM entertainment에 엄청난 흑자를 안겨주었던 Lysn이 떠오른다.) 프로모션용 단체 문자 전송에 매우 효과적일 것 같다. 

lenght( )는 가장 단순하게는 자소서 글자 수 체크에 사용될 수 있을 것이다. 그 외에도 다양한 활용 방법을 고민해보면 좋을 것 같다!  

이 밖에도 String 클래스의 유용한 메소드들을 탐구해 보자. 