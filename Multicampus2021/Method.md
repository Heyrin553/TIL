# Method

메소드란? 

복잡한 것을 단순하게 만드는 정리정돈의 도구.  

인류는 비슷한 것들끼리 모아 그것에 이름을 붙이는 과정을 반복하면서 무한한 복잡성을 다룰 수 있게 되었다. 

서로 연관된 코드를 모아서 그룹핑하고 이름을 붙이면 그것이 함수. 자바에서는 이를 Method 라고 한다. 

이미 만들어놓은 Method를 사용함으로써 같은 코드를 다시 작성하지 않고도 재사용할 수 있게 된다. 



## 이미 익숙한 메소드

main이라는 이름의 메소드를 정의해 놓으면 Java는 FirstMethod 를 실행하라는 명령이 내려졌을 때 main이라는 메소드를 실행하도록 약속되어있다. 

그렇기 때문에 우리는 실행하고자 하는 명령어들을 main이라는 메소드의 본문 안에 위치시켰던 것. 

```java
public class FirstMethod {
	
	public static void main(String[] args) {
		System.out.println("Hello Method");
		System.out.println(Math.floor(1.1));
		
	}
}
```



## 메소드의 기본 형식 

```java
public class WhyMethod {
	
	public static void printTwoTimesA() {
		System.out.println("-");
		System.out.println("A");
		System.out.println("A");
	}

	public static void main(String[] args) {
		
		// System.out.println("A"); 1억줄
		printTwoTimesA();
		// System.out.println("A"); 1억줄
		printTwoTimesA();
		// System.out.println("A"); 1억줄
		printTwoTimesA(); 
		// 메소드를 사용함으로써 코드의 의미를 파악하기에 용이해짐. 
		
	}
}
```

###### Tip) refactor-Extract Method(메소드 추출 기능)을 사용하면 코드가 자동으로 메소드화됨. 



## 메소드의 입력

```java
public class WhyMethod {

	public static void main(String[] args) {
					 // 인자, argument
		printTwoTimes("a", "-");
		printTwoTimes("a", "*");
		printTwoTimes("a", "&");
		printTwoTimes("b", "!");	
	}
									// 매개변수, parameter
	public static void printTwoTimes(String text, String delimiter) {
		System.out.println(delimiter);
		System.out.println(text);
		System.out.println(text);
	}
}
```



## 메소드의 출력

```java
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
```

> return은 메소드의 실행결과(output)이자 메소드를 종료시키는 역할을 한다. return은 반드시 반환할 데이터의  타입과 함께 쓰여야 한다. 
>
> void는 리턴값이 없음을 의미한다. 

```java
import java.io.FileWriter;
import java.io.IOException;

public class WhyMethod {

	public static void main(String[] args) throws IOException {
					 // 인자, argument
		printTwoTimes("a", "-");
		System.out.println(twoTimes("a", "-")); 
		
		FileWriter fw = new FileWriter("out.txt");
		fw.write(twoTimes("a", "*"));
		fw.close();
		
//		Email.send("beforerin@gmail.com", "two times a", twoTimes("a", "&"));
		
	}
	

	public static String twoTimes(String text, String delimiter) {
		String out = ""; //지역변수 초기화
		out = out + delimiter + "\n";
		out = out + text + "\n";
		out = out + text + "\n";
		
		return out;
		
	}
									// 매개변수, parameter
	public static void printTwoTimes(String text, String delimiter) {
		System.out.println(delimiter);
		System.out.println(text);
		System.out.println(text);
	}
}
```

> printTwoTimes("a", "-");
> System.out.println(twoTimes("a", "-")); 

위 코드와 아래 코드의 실행 결과는 같지만, twoTimes의 실행 결과는 화면 출력이 아니라 return값이기 때문에 더 다양한 임무를 수행 가능하다. 



## 접근 제한자 

메소드가 많아지면 서로 연관되는 메소드를 구별하기 위해 클래스를 만든다. 

소프트웨어가 복잡해지면 이를 정교하게 관리하기 위해 외부에서 접근 가능한 수준을 지정해야 할 필요가 생긴다. 

**public, protected, default, private**

private: 같은 클래스 내에서만 사용할 수 있는 것. 

public: 클래스 밖에서도 사용할 수 있는 것. 

protected: 다른 패키지이더라도 상속 관계에 있다면 사용할 수 있는 것. 

default: 같은 패키지 내에서만 사용할 수 있는 것. 



## Static

static - class method

non static - instance method



static 메소드(클래스 메소드)는 객체생성 없이 `클래스명.메소드명()` 으로 호출 가능

non static 메소드(인스턴스 메소드)는 객체를 생성함으로써(new) `인스턴스.메소드명()`으로 호출 가능 



* Static으로 만들어야 하는 데이터/메소드? 

  > 객체마다 가지고 있어야 할 필요가 없는 공용 데이터/메소드라면 static으로 만든다. 
  >
  > 객체마다 가지고 있어야 하는 데이터/메소드라면 non static으로 만든다. 