package client;

import java.awt.*;

public class ClientUi {

	public static void main(String[] args) {
		Frame f = new Frame("나의 채팅");
		Panel p = new Panel();
		Button b1 = new Button("전송1");
		
		TextField tf = new TextField(20);
		TextArea ta = new TextArea();
		
		MyFrameHandler fHandler = new MyFrameHandler();
		f.addWindowListener(fHandler);
		
		MyButtonHandler b1Handler = new MyButtonHandler(); //ActionListener는 인터페이스라서 직접 객체화 할 수 없고, 하위 클래스를 만들어서 사용
		b1Handler.setTextArea(ta);
		b1Handler.setTextField(tf);
		b1.addActionListener(b1Handler);
		
		tf.addActionListener(b1Handler);
		
		
		f.add(ta, BorderLayout.CENTER);
		f.add(p, BorderLayout.SOUTH);
		p.add(tf);
		p.add(b1);

		
		p.setBackground(Color.DARK_GRAY);
		
		//Color bgColor = new Color(5, 24, 56); 
		f.setLocation(800, 200);
		f.setBackground(Color.LIGHT_GRAY);
		f.setSize(500, 600);
		f.setVisible(true);
		
		
		


	}

}
