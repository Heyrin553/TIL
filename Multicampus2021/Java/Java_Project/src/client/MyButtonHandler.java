package client;

import java.awt.*;
import java.awt.event.*;


public class MyButtonHandler implements ActionListener {

	TextArea ta;
	TextField tf;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 하고 싶은 일 
		String msg = tf.getText();
		ta.append(msg+"\n");
		tf.setText("");
		
	}
	public void setTextArea(TextArea ta) {
		this.ta = ta;
		
	}
	

	public void setTextField(TextField tf) {
		this.tf = tf;
	}
}
