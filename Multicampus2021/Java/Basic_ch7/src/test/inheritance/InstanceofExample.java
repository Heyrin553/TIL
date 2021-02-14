package test.inheritance;

public class InstanceofExample {
	
	public static void method1(Parent parent) {
		if(parent instanceof Child) {
			Child child = (Child) parent;
			System.out.println("method1 - Child로 변환 성공");
		}else {
			System.out.println("method1 - Child로 변환되지 않음");
		}
	}
	
	public static void method2(Parent parent) { // 타입체킹을 하지 않아 에러발생할가능성있음
		Child child = (Child) parent;
		System.out.println("method2 - Child 변환 성공"); 
	}

	public static void main(String[] args) {
		Parent parentA = new Child();
		method1(parentA);
		method2(parentA);
		
		Parent parentB = new Parent();
		method1(parentB); // method1 - Child로 변환되지 않음
		method2(parentB); // Child타입이 아니었던 객체를 변환하려고 했기 때문에 에러 발생. 

	}

}
