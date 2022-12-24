package collectionTask;

public class User {
	
//	변수 선언
	private String name;
	private String id;
	private String password;
	private String phoneNumber;
	
//	기본 생성자
	public User() {;}
	
//	private이기 때문에 getter,setter생성
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	//복호화이긴 한데 쓰인곳이 없다.
	private String decrypt(String password) {
		String decryptedPassword = "";
		for (int i = 0; i < password.length(); i++) {
			decryptedPassword += (char)(password.charAt(i) / 3);
		}
		return decryptedPassword;
	}
	
	//toString을 재정의
	@Override
	public String toString() {
		String str = name + "," + id + "," + phoneNumber + "," + decrypt(password);
		return str;
	}
}
