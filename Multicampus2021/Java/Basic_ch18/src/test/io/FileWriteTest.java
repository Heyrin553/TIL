package test.io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("c:\\temp\\b.txt");
			fw.write("lalala\n");
			fw.write("hahaha");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(fw != null) fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
