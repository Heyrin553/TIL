package test.inheritance;

public class Computer extends Calculator {
	
	@Override
	double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle실행-오버라이딩됨");
		return Math.PI * r * r;
	}

}
