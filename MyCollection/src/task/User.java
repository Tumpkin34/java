package task;

public class User {
//	-이름, 아이디, 비밀번호, 휴대폰번호
//	-private으로 선언
//	-기본 생성자만 선언
//	-toString()재정의

	private String name;
	private String id;
	private String pw;
	private String phoneNumber;

	public User() {
		;
	}

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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		String str = name + "," + id + "," + pw + "," + phoneNumber;
		return str;
	}
}
