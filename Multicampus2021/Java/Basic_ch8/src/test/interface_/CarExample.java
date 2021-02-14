package test.interface_;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.run();
		
		myCar.FLTire = new KumhoTire(); // 앞왼쪽바퀴 교체
		myCar.FRTire = new KumhoTire(); // 앞오른쪽바퀴 교체
		
		myCar.run();

	}

}
