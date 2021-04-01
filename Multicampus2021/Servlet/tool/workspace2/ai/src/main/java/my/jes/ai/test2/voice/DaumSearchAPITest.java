package my.jes.ai.test2.voice;

//Cafe2
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class DaumSearchAPITest {

	public static void main(String[] args) {
		try {
			String text = URLEncoder.encode("벚꽃", "UTF-8"); // 검색어";
			URL url = new URL("https://dapi.kakao.com/v2/search/web?query=" + text);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			String key = "KakaoAK ef9fe20ea03e07813d01e74cb870bb53";

			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", key);

			int responseCode = con.getResponseCode();

			BufferedReader br;

			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					response.append(inputLine);
				}
				br.close();
				System.out.println(response.toString());
			} else { // 에러 발생
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
