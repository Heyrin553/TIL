package test.this_;

public class CarExample {

	public static void main(String[] args) {
		Car car1 = new Car();
		System.out.println("car1.company: " + car1.company);
		System.out.println();
		
		Car car2 = new Car("자가용");
		System.out.println("car2.company: " + car2.company);
		System.out.println("car2.model: " + car2.model);
		System.out.println();
		
		Car car3 = new Car("자가용", "빨강");
		System.out.println("car3.company: " + car3.company);
		System.out.println("car3.model: " + car3.model);
		System.out.println("car3.color: " + car3.color);
		System.out.println();
		
		Car car4 = new Car("택시"); // 1번 생성자에서 지정한 값이 출력됨 
		System.out.println("car4.company: " + car4.company); // 현대자동차
		System.out.println("car4.model: " + car4.model); // 택시
		System.out.println("car4.color: " + car4.color); // 은색
		System.out.println("car4.maxSpeed: " + car4.maxSpeed); // 250
		System.out.println();
		
		Car car5 = new Car("택시", "빨강", 300);
		System.out.println("car5.company: " + car5.company);
		System.out.println("car5.model: " + car5.model);
		System.out.println("car5.color: " + car5.color);
		System.out.println("car5.maxSpeed: " + car5.maxSpeed);
		System.out.println();

	}

}
