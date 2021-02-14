package test.interface_;

public class RemoteControlExample {
	public static void main(String[] args) {
		RemoteControl rc = null; //인터페이스 변수 선언
		
		rc = new Television(); // 객체를 인터페이스에 대입
		rc.turnOn();
		rc.setVolume(9);;
		rc.turnOff();
		
		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		
		RemoteControl.changeBattery(); // 정적 메소드는 인터페이스 이름만으로 호출 가능 
	
	}
}