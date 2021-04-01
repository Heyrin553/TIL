package my.jes.ai.test2.voice;

//Cafe2
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class NaverNewsAPITest {
	public static void main(String[] args) {
		String clientId = "27jh60JMSkzwYQdTFodR"; // 애플리케이션 클라이언트 아이디
		String clientSecret = "wMsOJLieLw"; // 애플리케이션 클라이언트 시크릿

		try {
            String text = URLEncoder.encode("벚꽃 개화", "UTF-8"); //검색어";
            String apiURL = "https://openapi.naver.com/v1/search/news.json?query="+ text + "&display=5&start=1&sort=date"; // 뉴스의 json 결과
       //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // 블로그의 xml 결과 
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
	}
}
