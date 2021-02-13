package test.method;

public class CarExample1 {

	public static void main(String[] args) {
		Car1 myCar = new Car1();
		myCar.keyTurnOn();
		myCar.run();
		int speed = myCar.getSpeed();
		System.out.println("현재 속도:" + speed + "km/h");
	}
}
