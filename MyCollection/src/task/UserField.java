package task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class UserField {
//	-회원 정보를 담을 DB를 ArrayList선언
//	-아이디 중복검사
//	-회원가입
//	-로그인
//	-암호화(비밀번호)
//	-비밀번호 변경(비밀번호 찾기 서비스)
//	-인증번호 전송

	public ArrayList<User> users = new ArrayList<User>();

//	id체크
	public User checkId(String id) {
		User user = null;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(id)) {
				user = users.get(i);
				break;
			}
		}
		return user;
	}

//	-회원가입
	public void join(User user) {
		user.setPw(encrypt(user.getPw()));
		users.add(user);
	}	
//	내방법
	public User signup(String name, String id, String pw, String phoneNumber) {
		User user = new User();
		user.setName(name);
		user.setId(id);
		user.setPw(encrypt(pw));
		user.setPhoneNumber(phoneNumber);
		users.add(user);
		return user;
	}

//	-로그인
	public User login(String id, String pw) {
		User user = checkId(id);
		if (user != null) {
			if (user.getPw().equals(encrypt(pw))) {
				return user;
			}
		}
		return null;
	}

//	-암호화
	public String encrypt(String password) {
		String encryptPw = "";
		for (int i = 0; i < password.length(); i++) {
			
			encryptPw += (char) (password.charAt(i) * 4 + 6);
		}
		return encryptPw;
	}

//	-비밀번호 변경(비밀번호 찾기 서비스)
	
	public void changePassword(User user) {//살짝 덜됨
		User userOriginal = checkId(user.getId());
		userOriginal.setPw(user.getPw());
	}
	public void changePassword(User user, String changePw) {
		user.setPw(encrypt(changePw));
	}

////	-인증번호 전송
////	인증번호 전송 시 전송된 인증번호가 화면에서 필요하다.
////	따라서 전송한 인증번호를 사용한 화면쪽으로 리턴해준다.

	public void sendSms(User user) {
		String api_key = "NCSK5MNEKZ4NURVH";
		String api_secret = "LPFUU0WDQ4Q70VQANDYCJHXYMBV1VJNK";
		Message coolsms = new Message(api_key, api_secret);

		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", user.getPhoneNumber());
		params.put("from", "01085319498");
		params.put("type", "SMS");
		params.put("text", creatCertificationNumber());
		params.put("app_version", "test app 1.2"); // application name and version

		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
	}

	static String tempNumber = "";

	public String creatCertificationNumber() {
		Random r = new Random();
		String certificationNumber = "";
		for (int i = 0; i < 6; i++) {
			certificationNumber += r.nextInt(10);
		}
		tempNumber = certificationNumber;
		return certificationNumber;
	}
	
}
