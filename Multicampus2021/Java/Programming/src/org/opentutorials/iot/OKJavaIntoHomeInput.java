package org.opentutorials.iot;

import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Security;
import org.opentutorials.iot.Lighting;

public class OKJavaIntoHomeInput {
	
	// args는 parameter, 프로그램을 사용하는 사람과 프로그램 사이의 매개가 되는 매개변수 
	// args에는 사용자가 입력한 값이 들어감(Java APT 507, 15.0 등...) 

	public static void main(String[] args) {
		
		String id = args[0];
		String bright =args[1];
		
//		String id = JOptionPane.showInputDialog("Enter a ID"); //ID 입력창 띄우기
//		String bright = JOptionPane.showInputDialog("Enter a bright"); //bright 입력창 띄우기
		
		// Elevator call 
		Elevator myElevator = new Elevator(id);
		myElevator.callForUp(1);
		
		// Security off
		Security mySecurity = new Security(id);
		mySecurity.off();
		
		// Light on
		Lighting hallLamp = new Lighting(id+" / hallLamp");
		hallLamp.on();
		
		Lighting floorLamp = new Lighting(id+" / floorLamp");
		floorLamp.on();
		
		DimmingLights moodLamp = new DimmingLights(id+" moodLamp");
		moodLamp.setBright(Double.parseDouble(bright));  //convert String to Double
		moodLamp.on();
		
	}

}