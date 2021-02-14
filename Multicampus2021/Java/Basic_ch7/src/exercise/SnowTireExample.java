package exercise;

public class SnowTireExample {

	public static void main(String[] args) {
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire;
		
		snowTire.run();
		tire.run(); // 부모타입으로 변환되어도 오버라이딩된 메소드가 호출됨

	}

}
