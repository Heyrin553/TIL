package temp;

public class Test {

	public static void main(String[] args) {
		int i = 10;
		Member m = new Member();
		m.setAge(i); // 값을 m에 패스(전달)! 
		System.out.println(m.getAge()); //10
	
	}
//	set/get메서드는 내가 가진 데이터를 전달하기 위한 측면에서도 볼 수 있다 

}

class Member{
	private int age;

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		if(age>0);
		this.age = age;
	}
}





package client;

import java.awt.*;
import java.awt.event.*;


public class MyButtonHandler implements ActionListener {

	TextArea ta;
	TextField tf;

//	private static MyButtonHandler me = new MyButtonHandler(); // me라는 객체를 static으로 만들기 -singletone 기법
//	
//	//객체가 전 어플리케이션 영역에서 단 하나만 생기게 하는 클래스 작성 기법: 싱글톤 

//	//방법: 
//	//     자기가 자기 객체를 생성(private static)
//	//     자기가 생성한 자기 객체를 리턴 (public static)

//	// 생성자를 private하게 막아둠

//	static public  MyButtonHandler getInstance() { // 객체 생성 없이도 사용할 수 있도록 static으로 설계 
//		return me; // 메소드를 통해 객체를 얻어가도록 설계 
//		
//	}
//	private MyButtonHandler() {
//		super();
//	}
	

	public MyButtonHandler(TextArea ta, TextField tf) {
		this.ta = ta;
		this.tf = tf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 하고 싶은 일 
		String msg = tf.getText();
		ta.append(msg+"\n");
		tf.setText("");
		
	}


​	

}



package client;

import java.awt.event.*;
import java.awt.event.WindowListener;

public class MyFrameHandler extends WindowAdapter{


	@Override
	public void windowClosing(WindowEvent e) { //window 클로징 시점
		System.out.println("windowClosing");
		System.exit(0); //정상종료 
		
	}

}



package client;

import java.awt.*;

public class ClientUi {

	public static void main(String[] args) {
		Frame f = new Frame("나의 채팅");
		Panel psouth = new Panel();
		Panel peast = new Panel();
		Button b1 = new Button("전송");
		Button btn = new Button("버튼"); 
		Label lbl = new Label("라벨");
		Checkbox chkbox = new Checkbox("체크박스");
		CheckboxGroup chkGroup = new CheckboxGroup(); // 라디오
		Checkbox chk1 = new Checkbox("A", chkGroup, false); // 라디오 A값 추가
		Checkbox chk2 = new Checkbox("B", chkGroup, false); // 라디오 B값 추가
		Checkbox chk3 = new Checkbox("C", chkGroup, true); // 라디오 C값 추가, true는 최초 선택값
		Choice cho = new Choice(); // 콤보박스
		cho.addItem("1번 선택지"); // 콤보박스 추가
		cho.addItem("2번 선택지"); // 콤보박스 추가
		cho.addItem("3번 선택지"); // 콤보박스 추가


​		
		TextField tf = new TextField(20);
		TextArea ta = new TextArea();
		
		MyFrameHandler fHandler = new MyFrameHandler();
		f.addWindowListener(fHandler);
		
		MyButtonHandler b1Handler = new MyButtonHandler(ta, tf); //ActionListener는 인터페이스라서 직접 객체화 할 수 없고, 하위 클래스를 만들어서 사용
		b1.addActionListener(b1Handler); //버튼 누르는 행위 감지 
		
		tf.addActionListener(b1Handler); //엔터 누르는 행위 감지 


​		
		f.add(ta, BorderLayout.CENTER);
		f.add(psouth, BorderLayout.SOUTH);
		psouth.add(tf);
		psouth.add(b1);


​		
​		
​		
		psouth.setBackground(Color.DARK_GRAY);
		
		f.add(peast, BorderLayout.EAST);
		
		peast.setBackground(Color.GRAY);
		peast.setBounds(0, 0, 150, 250);
		peast.setLayout(null);
		
		btn.setBounds(50, 50, 50, 50);
		lbl.setBounds(50, 100, 50, 50);
		chkbox.setBounds(50, 150, 100, 50);
		chk1.setBounds(50, 200, 25, 50);
		chk2.setBounds(100, 200, 25, 50);
//		chk3.setBounds(150, 200, 25, 50);
		cho.setBounds(50, 250, 70, 50);
		
		peast.add(btn);
		peast.add(lbl);
		peast.add(chkbox);
		peast.add(chk1); // 라디오의 경우에는 만들어준 체크박스 1,2,3을 모두 붙여야 함
		peast.add(chk2);
//		peast.add(chk3);
		peast.add(cho);
		
		
	
		
		//Color bgColor = new Color(5, 24, 56); 
		f.setLocation(800, 200);
		f.setBackground(Color.LIGHT_GRAY);
		f.setSize(500, 600);
		f.setVisible(true);


​		
​		


	}

}





```java
f.addWindowListener(new WindowAdapter(){
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("창 종료");
			System.exit(0);
		}
		
	});
```
> 클래스가 메서드 안쪽으로 들어감 -> 로컬 클래스 
>
> 이너 클래스의 내용을 한 메소드에서만 사용할 때, 가독성을 더 높이기 위해 로컬 클래스로 만듦 





	ta.addMouseListener(new MouseAdapter() { // 익명의 로컬 클래스 
			@Override
			public void mouseEntered(MouseEvent e) {
				ta.append("마우스 진입\n");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ta.append("마우스 클릭\n");
			}
		});
	
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				}
			});


​		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chatMsg();
			}
		}); //버튼 누르는 행위 감지 
		
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chatMsg();	
			}
		}); //자기 이름을 버리고 슈퍼의 이름을 가져와야 함. 
람다식

```java
b1.addActionListener((ActionEvent e) ->  { 
			chatMsg();
		}
	);
```
딱 하나의 메소드만 가진 인터페이스(functional 인터페이스-@FunctionalInterface)는 람다식으로 만들 수 있다.  

```
b1.addActionListener((ActionEvent e) -> chatMsg()); 
```

```
b1.addActionListener((e) -> chatMsg());
```

```
b1.addActionListener(e -> chatMsg());
```

사실은 객체를 만드는 것이지만 표현만 함수인것처럼 속이는 것! 



IOStream

package test.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileReadTest {

```java
public static void main(String[] args) { // checked 예외 처리
	try {
		FileInputStream in = new FileInputStream("c:\\temp\\a.txt");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace(); //개발시점에서는 테스트에 도움이 됨. 실행시에는 보안에 나빠 지워야 함! 
	}	
}
```
}