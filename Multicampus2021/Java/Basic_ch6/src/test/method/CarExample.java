package test.method;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.setGas(5); //Car의 setGas()메소드 호출
		
		boolean gasState = myCar.isLeftGas();
		if(gasState) {
			System.out.println("출발합니다");
			myCar.run();
		}
		
		if(myCar.isLeftGas()) { 
			// 달리는 중에 상태 체크해야 하기 때문. 
			// gasState로 해버리면 초기값이 1이상일 때 else문이 수행안됨.  
			System.out.println("No need to fuel");
		}else {
			System.out.println("Fuel the car");
		}
	}
}
