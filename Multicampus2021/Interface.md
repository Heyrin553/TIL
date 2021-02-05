# Interface (인터페이스)

> 다중 상속을 위한 프로그램 단위 
>
> 모든 메소드가 abstract이어야 함! (반드시 하위에서 구현해야만 하고, 규격을 맞춰야 함)
>
> 인터페이스는 다른 인터페이스를 상속할 수 있고, 다중 상속 가능 



- Java 의 프로그램 단위	
  - Class (기본, 단일상속)
  - Enum (상수)
  - **Interface (다중상속)**

```java
package my.fly;

public interface Flyer { //나는 기능을 표현하기 위함 

}
```

```java
package my.fly;

public class Bird extends Animal implements Flyer {
	
	@Override
	public void eat() {
		System.out.println("벌레를 먹는다");
	}

	public void fly() {
		System.out.println("날개");
	}
}
```

```java
package my.fly;

public class Superman extends Human implements Flyer {
	
	@Override
	public void eat() {
		super.eat();
		System.out.println("빵도 먹는다");
	}
	
	public void fly() {
		System.out.println("망토를 휘날리며 난다");
	}

}
```

```java
package my.fly;

public class Airplane extends Vehicle implements Flyer {
		
	public void fly() {
		int distance=transfer(10, 1000);
		System.out.println(distance+"거리만큼 엔진을 가동해서 난다");
		
	}
```

- 메소드 디자인 

```java
package my.fly;

public interface Flyer {
	public void fly(); //abstract을 명시 안 해도 에러 발생 안함. 기본값이기 때문. 

}
```

- 에어쇼

```java
package my.fly;

public class Show {
	
	public void airShow(Flyer f) {
		f.fly();
```

- 테스트 

```java
package my.fly;

public class Test {

	public static void main(String[] args) {
		Flyer b=new Bird();
		Flyer s=new Superman();
		Flyer a=new Airplane();
		
		Show show=new Show();
		show.airShow(b);
		show.airShow(s);
		show.airShow(a);
		show.airShow("java"); //규격에 맞지 않아 에러 발생! 
		
	}
}
```







