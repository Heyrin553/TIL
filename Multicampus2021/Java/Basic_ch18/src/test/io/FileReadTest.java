package test.io;

import java.io.*;

public class FileReadTest {

	public static void main(String[] args) { // checked 예외 처리
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("c:\\temp\\a.txt");
			br = new BufferedReader(fr);
			String oneLine = "";
			while((oneLine = br.readLine()) != null) {
				System.out.println(oneLine);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace(); //개발시점에서는 테스트에 도움이 됨. 실행시에는 보안에 나빠 지워야 함! 
		} catch (IOException e) { // 중첩 캐치! 좋은 방법. 
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(fr != null) fr.close();
			} catch (IOException e) {
				
			}
		}
	}
}
