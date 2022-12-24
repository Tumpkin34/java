package apiTest;

import java.util.HashMap;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SmsTest {

	public static void main(String[] args) {//외부 api경험해보기(sms 문자기능)
		String api_key = "NCSK5MNEKZ4NURVH";
		String api_secret = "LPFUU0WDQ4Q70VQANDYCJHXYMBV1VJNK";
		Message coolsms = new Message(api_key, api_secret);

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", "01085319498");
		params.put("from", "01085319498");
		params.put("type", "SMS");
		params.put("text", "문 앞에 택배 놓고 갑니다.");
		params.put("app_version", "test app 1.2"); // application name and version

		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}

}
