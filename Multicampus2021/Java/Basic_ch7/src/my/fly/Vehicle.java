package my.fly;

abstract public class Vehicle {
	
	public int transfer(int start, int end) { //콘크리트 메소드(구현된 메소드)
		int distance=end-start; 
		return distance;
	}
	
	abstract public void drive(); //추상 메소드
		
}

