package getter_setter;

public class Car {
	
	private int speed;
	private boolean stop;
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		if(speed < 0) {
			System.out.println("0보다 큰 값을 입력하세요");
		}else {
			this.speed = speed;
		}
		
		
	}
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	

}
