package test.static_;

public class Car {
	
	int speed;
	void run() {
		System.out.println(speed+"km/h으로 달립니다");
	}

	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.speed = 60;
		myCar.run();

	}

}
