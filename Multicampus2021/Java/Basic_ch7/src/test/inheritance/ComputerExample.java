package test.inheritance;

public class ComputerExample {

	public static void main(String[] args) {
		int r = 10;
		
		Calculator cal = new Calculator();
		System.out.println("원의 넓이: " + cal.areaCircle(r)); // 314.159
		
		
		Computer com = new Computer();
		System.out.println("원의 넓이: " + com.areaCircle(r)); // 314.1592653589793
	}

}
