# 변수



## 변수의 정의

변수란? 변할 수 있는 수 

Java에서 변수를 만드는 법: 변수 안에 어떤 데이터 타입이 들어갈 수 있는지 지정해 주어야 함. 

```java
public class Variable {

	public static void main(String[] args) {
		int a = 1; // integer ... -2, -1, 0, 1, 2 ...
		System.out.println(a); // 1
		
		double b = 1.1; // real number -> double 
		System.out.println(b); // 1.1 
		
		String c = "Hello World";
		System.out.println(c); // Hello World

	}
}
```

**왜 데이터 타입을 지정해 주어야 할까??** 

데이터 타입은 음료수용기와 같은 것. 이 변수에는 반드시 정수/문자열이 온다고 정의해두면 그것이 아닌 정보가 들어갔을 때 Java가 아예 컴파일이 안 됨. 일일이 확인하지 않아도 되는 편리함을 제공하는 것. 



## 변수의 효용

```java
public class Letter {

	public static void main(String[] args) {
		String name="HJ";
		System.out.println("Hello, "+name+" ... "+name+" ... HJ ... bye. "); // Hello, HJ ... HJ ... HJ ... bye. 이름이 들어가는 자리에 name이라는 변수를 도입
        
        double VAT = 10.0;
		System.out.println(VAT); 
	}
}
```

변수를 사용함으로써, 나 뿐만 아니라 내 코드를 보는 다른 사람도 코드의 의미, 의도를 파악할 수 있게 됨. ex) HJ는 이름이구나, 10.0은 VAT(부가가치세)구나!  



## Casting 

데이터 타입을 다른 타입으로 converting하는 방법

```java
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
```



