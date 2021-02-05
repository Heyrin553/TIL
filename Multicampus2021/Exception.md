# Exception(예외 처리)

> 프로그래밍적 오류를 잡고 실행을 계속할 수 있는 기법 
>
> 코드 수준으로 처리할 수 있는 것. Error와는 다름! 

#### 예외 처리 방법 

1. try~catch 

2. throw 

   

## (1) try~catch 

> 발생한 에러를 잡는 것! 
>
> 단, 서버 입장에서는 어떤 Expection이 발생했는지 알 수 있지만, 클라이언트 입장에서는 알 수 없다.  

```java
package test.exception;

public class Test {

	public static void main(String[] args) {
		int x=100;
		int y=0; //여기로 인해 정작 중요한 일이 실행되지 않음! 
		System.out.println(x/y);
		System.out.println("아주 중요한 일이 여기부터");
	}
}
```

위 코드를 실행하면 int y=10;을 실행하는 과정에서 Exception 발생. 

**Exception in thread "main" java.lang.ArithmeticException: / by zero
	at test.exception.Test.main(Test.java:8)**



이를 방지하기 위해서 **예외 처리**를 하는 것! 

catch( ) 안에 해당하는 Exception을 넣어준다. 

```java
package test.exception;

public class Test {

	public static void main(String[] args) {
		try {
			int x=100;
			int y=0;
			System.out.println(x/y);
			}catch(ArithmeticException e) {
			// catch 블럭 안에 아무 것도 없어도 JVM이 다시 살아남! 	
			}
		System.out.println("아주 중요한 일이 여기부터");
	}
}
```

```java
package test.exception;

public class Test {

	public static void main(String[] args) {
		try {
			int x=100;
			int y=0;
			System.out.println(x/y);
			}catch(ArithmeticException e) {
				 System.out.println(e.getMessage()); /// by zero때문에 Exception 발생했다는 메시지 출력됨 
			}
		System.out.println("아주 중요한 일이 여기부터");
	}
}
```

> 내가 캐치하지 못한 시스템의 허약점을 캐치해 낼 수 있음. 

- ArithmeticException

  > 입력값을 가지고 계산할 수 없는 경우 ex) 10 / 0 

- NumberFormatException

  > 숫자로 변환될 수 없는 문자가 포함되어 있는 경우 

- ArrayIndexOutOfBoundsException

  > 배열에서 인덱스 범위를 초과하여 사용할 경우 

- Exception

  > 어떤 Exception이 발생하더라도 처리 가능 

  

```
package test.exception2;

public class Calculator {
	public int divide(int x, int y) {
		int z=0;
		try {
			z=x/y;
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다");
		}
		return z;
	}

}
```

```
package test.exception2;

public class Test {

	public static void main(String[] args) {
		
		Calculator c=new Calculator();
		int result=c.divide(100, 0);
		System.out.println(result);
		
		System.out.println("중요한 일 시작");

	}

}
```

> 클라이언트 입장에서는 어떤 오류가 발생했는지 알 수 없다. 



## (2) throw (예외 떠넘기기)

```java
package test.exception2;

public class Calculator {
	public int divide(int x, int y) throws Exception {
		int z=0;
		if(y==0) {
			throw new Exception(); //Exception을 발생시켜라 -사용자가 개발 시점에서 미리 Exception을 대비할 수 있음.
		}
		z=x/y;
		
		return z;
	}

}
// 서버 쪽에서는 throw로 exception을 main실행하는 쪽에 던져주도록 설계 
```

```java
package test.exception2;

public class Test {

	public static void main(String[] args) {
		
		Calculator c=new Calculator();
		int result=0;
		try {
			result = c.divide(100, 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(result);
		
		System.out.println("중요한 일 시작");

	}
}
// main실행하는 쪽에서 exception을 캐치해야 함. 
```

> null
> 0
> 중요한 일 시작 

하지만 여전히 null을 출력하고 있어서, 어떤 exception 이 발생했는지 알 수 없다. 



**가장 좋은 프로그램**

```java
package test.exception2;

public class MyException extends Exception {
	public MyException(String message) {
		super(message);
	}
}
```

> MyException 이라는 클래스를 만든다. 이 클래스는 Exception을 상속하고, 어떤 exception 이 발생했는지를 메시지로 출력하기 위해 만들었다. 

```java
package test.exception2;

public class Calculator {
	public int divide(int x, int y) throws MyException {
		int z=0;
		if(y==0) {
			throw new MyException("y를 0으로 입력하지 마세요"); 
		}
		z=x/y;
		
		return z;
	}
}
```

> Exception 이 아닌 MyException 이라는 클래스가 예외를 받아들이도록 한다. 

```java
package test.exception2;

public class Test {

	public static void main(String[] args) {
		
		Calculator c=new Calculator();
		int result=0;
		try {
			result = c.divide(100, 0);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(result);
		
		System.out.println("중요한 일 시작");

	}
}
```

> [Console]
>
> y를 0으로 입력하지 마세요
> 0
> 중요한 일 시작
>
> - 어떤 예외가 발생했는지 메시지로 출력할 수 있게 되었다. 
>
> `Unchecked Exception`(대비하지 못한 예외)인 `Runtime Exception`을 `Checked Exception`(미리 대비해 둔 예외)로 만들기 위해 `Exception`을 상속하는 `MyException` 을 만들어 주는 것. 
>
> 나누기를 하기 전에 예외를 일부러 발생시킴으로써 대비되지 않은 예외를 **대비할 수 있게** 만들어 주어서, 프로그램이 뻗지 않고 돌아갈 수 있게 해 줌.  



#### finally

> 예외 발생 여부와 상관없이 항상 실행할 내용이 있을 경우 사용 

```java
package test.exception2;

public class Test {

	public static void main(String[] args) {
		
		Calculator c=new Calculator();
		int result=0;
		try {
			result = c.divide(100, 2);
			c=null;
			c.divide(50, 2);
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}finally {
		System.out.println(result);
		
		System.out.println("중요한 일 시작");
		}
	}
}
```

> [Console]
>
> 50
> 중요한 일 시작
> Exception in thread "main" java.lang.NullPointerException
> 	at test.exception2.Test.main(Test.java:12)
>
> > 중간에 예외가 발생해도 일단 finally블록이 실행됨 

