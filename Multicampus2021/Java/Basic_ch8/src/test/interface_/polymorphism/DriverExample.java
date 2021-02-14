package test.interface_.polymorphism;

public class DriverExample {

	public static void main(String[] args) {
		Driver driver = new Driver();
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.drive(taxi); // 자동 타입 변환 Vehicle vehicle = taxi;
		driver.drive(bus); // 자동 타입 변환  Vehicle vehicle = bus;
		
		

	}

}
