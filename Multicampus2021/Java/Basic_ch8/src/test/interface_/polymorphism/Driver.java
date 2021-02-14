package test.interface_.polymorphism;

public class Driver {
	public void drive(Vehicle vehicle) {
		if(vehicle instanceof Bus) { // Bus객체를 참조하고 있는지 확인
			Bus bus = (Bus) vehicle; // Bus객체를 참조하고 있으므로 안전하게 변환
			bus.checkFare(); // 강제타입변환을 하는 이유
		}
		vehicle.run();
	}

}
