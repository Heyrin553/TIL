# Input과 Output 

```java
package org.opentutorials.iot;

import javax.swing.JOptionPane;

import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Security;
import org.opentutorials.iot.Lighting;

public class OKJavaIntoHomeInput {

	public static void main(String[] args) {
		
		String id = JOptionPane.showInputDialog("Enter a ID"); //ID 입력창 띄우기
		String bright = JOptionPane.showInputDialog("Enter a bright"); //bright 입력창 띄우기
		
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
```

![image-20210207005445410](C:\Users\혜린\AppData\Roaming\Typora\typora-user-images\image-20210207005445410.png)

![image-20210207005511605](C:\Users\혜린\AppData\Roaming\Typora\typora-user-images\image-20210207005511605.png)

입력값을 줄 수 있는 창이 뜬다! 

[console]

1004호 -> Elevator callForUp stopFloor : 1
1004호 -> Security off
1004호 / hallLamp -> Lighting on
1004호 / floorLamp -> Lighting on
1004호 moodLamp -> DimmingLights bright : 10.0
1004호 moodLamp -> Lighting on



- 입력값을 사용했을 때 장점은 무엇일까? 다른 입력값으로는 어떤 것이 가능할까? 
  - 입력값을 사용한다면 사용자 입장에서 더욱 직관적이고 편리해진다. 
  - 값을 직접 입력하지 않고 다이얼을 돌려서 선택할 수 있게 만드는 것도 가능할까? 



## arguments & parameter 

위에서처럼 javax.swing.JOptionPane을 통해서 입력값을 받을 수도 있지만, 가장 표준적인 방법은 arguments를 통해서 받는 것이다. 



1. 입력값을 받는 가장 표준적인 방법은 args라는 parameter를 통해서 받는 것. 
2. parameter에 여러 값이 들어올 때는 args[0], args[1] ... 로 입력값을 받아올 수 있음. 
3. 입력값을 줄 때는 Run configuration -> Arguments -> "Hello" "My name is" "HJ" 이런 식으로 가능  

```java
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
```

args에 어떤 값을 주었느냐에 따라서 결과가 다르게 출력된다. 

- args ["Java APT 507", "15.0"]

Java APT 507 -> Elevator callForUp stopFloor : 1
Java APT 507 -> Security off
Java APT 507 / hallLamp -> Lighting on
Java APT 507 / floorLamp -> Lighting on
Java APT 507 moodLamp -> DimmingLights bright : 15.0
Java APT 507 moodLamp -> Lighting on

- args ["Sujain APT 507", "45.0"]

Sujain APT 507 -> Elevator callForUp stopFloor : 1
Sujain APT 507 -> Security off
Sujain APT 507 / hallLamp -> Lighting on
Sujain APT 507 / floorLamp -> Lighting on
Sujain APT 507 moodLamp -> DimmingLights bright : 45.0
Sujain APT 507 moodLamp -> Lighting on



###### 팁) 실행 버튼 옆 화살표를 누르면 나오는 Organize Favorites를 사용해서 자주 쓰는 입력값을 즐겨찾기 할 수 있다. 