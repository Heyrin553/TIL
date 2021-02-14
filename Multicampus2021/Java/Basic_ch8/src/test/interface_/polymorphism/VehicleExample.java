package test.interface_.polymorphism;

public class VehicleExample {

	public static void main(String[] args) {
		Vehicle vehicle = new Bus();
		
		vehicle.run();
//		vehicle.checkFare(); // 호출 불가 
		
		Bus bus = (Bus)vehicle; // Bus타입으로 강제 타입 변환
		bus.checkFare();

	}

}
