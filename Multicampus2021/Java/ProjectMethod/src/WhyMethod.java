import java.io.FileWriter;
import java.io.IOException;

public class WhyMethod {

	public static void main(String[] args) throws IOException {
					 // 인자, argument
		printTwoTimes("a", "-");
		System.out.println(twoTimes("a", "-")); //위 코드와 아래 코드의 실행 결과는 같지만, twoTimes의 실행 결과는 화면 출력이 아니라 return값이기 때문에 더 다양한 임무를 수행 가능하다. 
		
		FileWriter fw = new FileWriter("out.txt");
		fw.write(twoTimes("a", "*"));
		fw.close();
		
//		Email.send("beforerin@gmail.com", "two times a", twoTimes("a", "&"));
		
	}
	

	public static String twoTimes(String text, String delimiter) {
		String out = ""; //지역변수 초기화
		out = out + delimiter + "\n";
		out = out + text + "\n";
		out = out + text + "\n";
		
		return out;
		
	}
									// 매개변수, parameter
	public static void printTwoTimes(String text, String delimiter) {
		System.out.println(delimiter);
		System.out.println(text);
		System.out.println(text);
	}
}
