package my.jes.ai.test3.chatbot.coffee;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import android.util.Base64;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONArray;
import org.json.JSONObject;

public class ChatbotProc {
	// public static String main(String voiceMessage, String apiURL, String
	// secretKey) {
	public static void main(String[] args) {

		String chatbotMessage = "";

		try {
			String apiURL = "https://78a371dfea604f0e99a62f4eea263825.apigw.ntruss.com/custom/v1/4309/778d336344b9ce76ddc49ebfd4b5f38110a0111eb3ddf737ba3eb244ac084ab3";

			URL url = new URL(apiURL);

			String voiceMessage = "커피 주문요"; // 나중에는 voiceMessage 가 스트링으로 바뀌어 넘어감. 지금은 스트링
			String message = getReqMessage(voiceMessage);
			System.out.println("##" + message);

			String secretKey = "QUZkb1Z1bW1LSUNMbnNEbXBKVkNHZnNEc1dPdnlraEM=";
			String encodeBase64String = makeSignature(message, secretKey);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			// 헤더 설정 (헤더 이름, 헤더 값)
			con.setRequestProperty("Content-Type", "application/json;UTF-8");
			con.setRequestProperty("X-NCP-CHATBOT_SIGNATURE", encodeBase64String); // 인코딩된 시크릿키와 (보이스)메시지

			// post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.write(message.getBytes("UTF-8"));
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode(); //코드부터 응답받기 

			BufferedReader br;

			if (responseCode == 200) { // Normal call
				System.out.println(con.getResponseMessage());

				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String decodedString;
				while ((decodedString = in.readLine()) != null) { //  널이 아닐때까지 한 라인씩 읽어서 
					chatbotMessage = decodedString; //'챗봇 메시지' 변수에 할당
				}
				// chatbotMessage = decodedString;
				in.close();

			} else { // Error occurred
				chatbotMessage = con.getResponseMessage();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(chatbotMessage);
		// return chatbotMessage;
	}

	//인코딩하는 메소드 
	public static String makeSignature(String message, String secretKey) {

		String encodeBase64String = "";

		try {
			byte[] secrete_key_bytes = secretKey.getBytes("UTF-8");

			SecretKeySpec signingKey = new SecretKeySpec(secrete_key_bytes, "HmacSHA256"); // 암호화
			Mac mac = Mac.getInstance("HmacSHA256"); // 암코화
			mac.init(signingKey);

			byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
			encodeBase64String = Base64.encodeToString(rawHmac, Base64.NO_WRAP);

			return encodeBase64String;

		} catch (Exception e) {
			System.out.println(e);
		}

		return encodeBase64String;

	}

	public static String getReqMessage(String voiceMessage) {

		String requestBody = "";

		try {

			JSONObject obj = new JSONObject();

			long timestamp = new Date().getTime();

			System.out.println("##" + timestamp);

			obj.put("version", "v2");
			obj.put("userId", "U47b00b58c90f8e47428af8b7bddc1231heo2"); //같은 도메인에 같은 유저아이디가 들어가면 어디에 응답해야할 지 구분을 못하므로, 유니크하게 정해야 함 
//=> userId is a unique code for each chat user, not a fixed value, recommend use UUID. use different id for each user could help you to split chat history for users.

			obj.put("timestamp", timestamp);

			JSONObject bubbles_obj = new JSONObject();

			bubbles_obj.put("type", "text");

			JSONObject data_obj = new JSONObject();
			data_obj.put("description", voiceMessage);

			bubbles_obj.put("type", "text");
			bubbles_obj.put("data", data_obj);

			JSONArray bubbles_array = new JSONArray();
			bubbles_array.put(bubbles_obj);

			obj.put("bubbles", bubbles_array);
			obj.put("event", "send");

			requestBody = obj.toString();

		} catch (Exception e) {
			System.out.println("## Exception : " + e);
		}

		return requestBody;

	}

}
