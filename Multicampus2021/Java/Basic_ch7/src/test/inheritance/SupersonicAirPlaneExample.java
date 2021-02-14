package test.inheritance;

public class SupersonicAirPlaneExample {

	public static void main(String[] args) {
		SupersonicAirPlane sa = new SupersonicAirPlane();
		sa.takeOff(); // 이륙합니다
		sa.fly(); // 비행합니다
		sa.flyMode = SupersonicAirPlane.SUPERSONIC;
		sa.fly(); // 초음속비행합니다
		sa.flyMode = SupersonicAirPlane.NORMAL;
		sa.fly(); // 비행합니다 
		sa.land(); // 착륙합니다 

	}

}
