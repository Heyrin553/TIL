# 생성자&제한자



## 1. 생성자 (Constructor)

> 객체 생성에 관여하는 특별한 메소드 
>
> non-static멤버 초기화(메모리에 올리기) 역할
>
> 생성자는 new 연산자와 같이 사용되어 클래스로부터 객체를 생성할 때  호출되어 객체의 초기화를 담당한다. 
>
> 리턴 타입은 기술하지 않음  

```java
class A{
    (static) data
    (static) method
    public A() {//정의 ----모든 클래스에는 이런 생성자가 들어가 있음 
        super(); //기본생성자, argument받지 않음. 명시적 생성자는 만들어서 넣어야 함
        
    public A(int i){//내가 하나라도 생성자를 명시적으로 코딩하면 컴파일러가 디폴트 생성자를 만들지 않음. //argument가 정수이므로 정수값을 넣어야 생성자 호출할 수 있음 
        super(); //object 생성자 호출
    // 생성자 오버로딩이 가능 
    
    public A(int x){ //오버로딩의 규칙과 어긋나 불가능
        
    }
    public A(byte x){ //argument가 다르다면 가능 
        
    }
        
    }
    }
}
```

* 로컬변수와 멤버변수
  * 메서드 영역 안쪽: 로컬변수
  * 클래스 안쪽: 멤버변수 

- this와 super 
  - this: 자기 자신 객체를 가리키는 reference
  - this( ): 자신의 생성자를 가리키는 호출구문(**생성자 내에서만** 사용가능)
  - super: super객체를 가리키는 reference
  - super( ): super 생성자를 가리키는 호출구문(**생성자 내에서만** 사용가능)



## 2. 제한자, 지정자(Modifier)

1. 접근 지정자 
2. 사용 지정자 (Usage modifier) 
   1. Static: 객체 생성 없이 사용하라 
   2. Final: 변경 없이 사용하라, 변경하지 말라  
   3. Abstract: 객체 생성이 불가능하기 때문에 반드시 상속해서 사용하라 



### (1) Static

> 왜 써야 하는가? 꼭 공유해야만 하는 데이터를 위해
>
> 객체지향프로그램임을 염두에 두어야 함. **사용을 자제**, **new 사용을 지향!** 

```java
package test.static_;

public class Test {
	static int i=10;//객체 생성 없이도 사용가능한 i 

	public static void main(String[] args) {
		System.out.println(i);
	}
}
```

static은 class, data, method앞에 붙일 수 있음. 

1) class 앞: inner class 에서만! 

2) data 앞: 공유하는 data가 됨. 

3) method 앞: 별 이득이 없음

#### 사용예시 

```java
package test.static_;

public class Test {
    
	public static void main(String[] args) {
		
	A o1=new A("오미주");
	A.count++; //객체생성없이 사용가능 
	
	A o2=new A("기선겸");
	A.count++; //객체생성없이 사용가능 
	
	A.printCount(); //객체생성없이 사용가능 
	
    }
}

class A{
	String name;
	static int count=0;//방문자수 
	static public void printCount() {
		System.out.println(count);
	}
	A(String name){
		this.name=name;
		
	}	
}
// 객체 생성 없이 클래스 A로만 호출하여 사용할 수 있다. 
```

- 메인 메서드는 static. 객체 생성 없이 메인을 수행할 수 있어야 하기 때문. 
- System 클래스도 static한 필드와 메소드를 가짐. 매우 자주 쓰이기 때문에 객체 생성 없이 수행될 수 있도록 static으로 만들어 진 것. 

```java
package test.static_;

public class Test2 {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		System.out.println(time); //system 클래스의 모든 멤버는 static. 
		
		System s=new System(); //컴파일 에러-생성자가 private 하여 외부에서 객체 생성이 불가능. 외부에서 접근하지 못하도록 막아둠! 어차피  static에 올라와 있으니 객체생성 안해도 사용가능

	}
}
```

- System 클래스의 멤버
  - error
  - in
  - out



### (2) Final 

> class, data, method앞에 붙일 수 있음 

1. class앞: 상속 불가
2. data앞: 상수
3. method앞: 오버라이딩(재정의) 불가 

- class 앞에 쓰이는 경우 -> 상속 불가 

```java
package test.final_;

public class Test {
	
	public static void main(String[] args) {
		B b=new B();
		b.i++;
		b.printI();
	}
}

final class A {
	int i=10;
	public void printI() {
		System.out.println("A의 i는 "+i);
	}
	
}

class B extends A { //컴파일 에러-파이널 클래스 A를 상속받을 수 없다
	
}
```

- data 앞에 쓰이는 경우 -> 다른 값 할당 불가 

```java
package test.final_;

public class Test {
	
	public static void main(String[] args) {
		B b=new B();
		b.i++; //컴파일 에러-파이널 필드인 i는 고정. 다른 값으로 할당될 수 없다. 
		b.printI();
	}
}

class A {
	final int i=10;
	public void printI() {
		System.out.println("A의 i는 "+i);
	}
	
}

class B extends A {

}
```

- method  앞에 쓰이는 경우 -> 오버라이딩 불가 

```java
package test.final_;

public class Test {
	
	public static void main(String[] args) {
		B b=new B();
		b.i++; //컴파일 에러-파이널 필드인 i는 고정. 다른 값으로 할당될 수 없다. 
		b.printI();
	}
}

class A {
	int i=10;
	final public void printI() {
		System.out.println("A의 i는 "+i);
	}
	
}

class B extends A {
	public void printI() { //컴파일 에러-오버라이딩 불가, 내용 변경 불가라는 뜻. 
		System.out.println("A로부터 상속받은 i는 "+i);
	}

}
```

- 왜 상속을 못 하게 할까?

  > 상속은 변경의 의미도 포함함. 원래 클래스에서 정해놓은 배열 등을 마음대로 바꿔서 사용할 수 있음. 마음대로 변경하지 못하도록 제한하는 것. 

- String 은 final 

```java
package test.final_;

public class Test {
	
	public static void main(String[] args) {
	Object o1=new Object();
	System.out.println(o1.toString()); //주소값 출력 
	
	Object o2=new Object();
	System.out.println(o2.toString()); //주소값 출력 
	
	System.out.println(o1==o2); //주소값 비교
	System.out.println(o1.equals(o2)); 
	
	Test t1=new Test();
	System.out.println(t1.toString());
	Test t2=new Test();
	System.out.println(t2.toString());
	
	System.out.println(t1==t2);
	System.out.println(t1.equals(t2));
	
	String s1=new String("java");
	System.out.println(s1.toString()); //오버라이딩 결과 - 내용값 출력 
	String s2=new String("java");
	System.out.println(s2.toString()); //오버라이딩 결과 - 내용값 출력 
	
	System.out.println(s1==s2); //오버라이딩 결과 
	System.out.println(s1.equals(s2)); //오버라이딩 결과 - 내용값 비교 
	
	String s3="java";
	System.out.println(s3.toString()); //오버라이딩 결과 - 내용값 출력  
	String s4="java";
	System.out.println(s4.toString()); //오버라이딩 결과 - 내용값 출력 
	
	System.out.println(s3==s4); //오버라이딩 결과 - 내용값 비교  
	System.out.println(s3.equals(s4)); //오버라이딩 결과 - 내용값 비교   
	
	}
}
```

- String은 파이널이기 때문에 상속이 불가능. 따라서 String의 주소를 출력하도록 만들 수 없음. 







