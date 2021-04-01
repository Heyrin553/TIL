package my.jes.ai.test2.voice;

//Cafe2
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpConTest {
	public static void main(String[] args) {

		try {
			URL url = new URL("http://localhost:8090/login.jes");
			HttpURLConnection con = (HttpURLConnection) url.openConnection(); // con - 길 생성
			
			con.setRequestMethod("POST"); 
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes("id=a&pw=a"); // 전송
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode(); // 응답 코드부터 읽기
			BufferedReader br;
			if (responseCode == 200) { // 200-정상호출이면  
				// 텍스트를 받아오기 위해 con에 getInputStream으로 내장된 귀 객체와 BufferedReader귀객체를 InputStreamReader로 연결
				br = new BufferedReader(new InputStreamReader(con.getInputStream())); 
				String inputLine;
				StringBuffer response = new StringBuffer(); 
				// 넉넉한 사이즈를 잡는 것이 StringBuffer. 스트링에 변경이 일어날 때는 버퍼를 만들어 추가하는 것이 좋음 
				while ((inputLine = br.readLine()) != null) { 
					response.append(inputLine);
				}
				br.close();
				System.out.println(response.toString());

			} else { // 오류 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					response.append(inputLine);
				}
				br.close();
				System.out.println(response.toString());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
