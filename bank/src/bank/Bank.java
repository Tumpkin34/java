package bank;

public class Bank {
//	은행이 3개, 각 은행별 고객 100명씩 유지 가능
	public static Bank[][] arrBank = new Bank[3][100];// 모든은행이 계좌번호,핸드폰번호를 공유하기위해 static변수로 선언 3행은 은행걔수 100열은 은행당 100명의
		// 정보를 담겠다
//	은행별 가입 회원수
	public static int[] arCount = new int[3];//각 은행의 등록회원 수를 저장

	private String name;// 사용자의 이름
	private String account;// 사용자의 계좌번호
	private String phoneNumber;// 사용자의 핸드폰 번호
	private String password;// 사용자의 비밀번호
	private int money;// 사용자의 통장잔액

	public Bank() {
		;
	}// 기본생성자

	public Bank(String name, String account, String phoneNumber, String password, int money) {// 매개변수로 이름,계좌번호, 핸드폰번호,
																								// 비밀번호, 통장잔액을 받아온다.
		this.name = name;// 사용자가 입력한 이름
		this.account = account;// 사용자의 계좌번호
		this.phoneNumber = phoneNumber;// 사용자가 입력한 핸드폰 번호
		this.password = password;// 사용자가 입력한 비밀번호
		this.money = money;// 근데 아마 이 초기화생성자가 불러졌다는건 계좌개설이기 때문에 사용자에게 입력받는것 보단 0을 넣는게 더 맞는거같다.
	}

// 위의 전역변수들을 private으로 설정했기 때문에 getter,setter메소드로 접근 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

//	static을 붙여서 선언한 메소드
//	객체화 없이 사용해야 할 때가 있기 때문
//	객체화 없이 사용하면 편하기 때문
	
//   계좌번호 중복검사
//	외부에서 생선된 계좌번호를 전달받는다.
	public static Bank checkAccount(String account) {// 객체화 없이 사용하기위해 static, 리턴값이 Bank,중복된 계좌번호가 있는지 확인할 계좌번호 받아옴
		Bank bank = null;// 아직 어떤 주소값을 받아야하는지 모르기 때문에 null
		for (int i = 0; i < arrBank.length; i++) {// 은행 수의 길이만큼 반복(3)
			int j = 0;// 반복문이 끝나고 j의 값을 밑의 반복문 밖에서 사용하려고 만든 변수
			for (j = 0; j < arCount[i]; j++) {// 각 은행별 가입된 회원 수 만큼 반복
				if (arrBank[i][j].account.equals(account)) {// arrBank의 i번째 행의 j번째 열의 계좌번호가 받아온 주소와 같으면 실행
					bank = arrBank[i][j];// Bank타입의 bank객체명에 찾은 arrBank의 i번째 행의 j번째 열의 주소 넣음
					break;// 찾았으니 더찾을 필요없어서 반복문 종료
				}
			}
//			위에서 강제로 break 했다면 j가 arCount[i]까지 증가하지 못하기 때문에
//			위에서 break 후 밖에 있는 for문도 break해준다.
			if (j != arCount[i]) {
				break;
			}
		}
		return bank;// 해당정보가 담겨있는 주소값을 리턴해줌
	}
//   핸드폰 번호 검사
	public static Bank checkPhoneNumber(String phoneNumber) {// 객체화 없이 사용하기위해 static, 리턴값이 Bank,
		Bank bank = null;// 아직 어떤 주소값을 받아야하는지 모르기 때문에 null
		for (int i = 0; i < arrBank.length; i++) {// 은행개수의 길이만큼 반복(3)
			int j = 0;// 반복문이 끝나고 j의 값을 밑의 반복문 밖에서 사용하려고 만든 변수
			for (j = 0; j < arCount[i]; j++) {// 각 은행별 가입된 회원 수 만큼 반복
				if (arrBank[i][j].phoneNumber.equals(phoneNumber)) {// arrBank의 i번째 행의 j번째 열의 계좌번호가 받아온 주소와 같으면 실행
					bank = arrBank[i][j];// Bank타입의 bank객체명에 찾은 arrBank의 i번째 행의 j번째 열의 주소 넣음
					break;// 찾았으니 더찾을 필요없어서 반복문 종료
				}
			}
//			위에서 강제로 break 했다면 j가 arCount[i]까지 증가하지 못하기 때문에
//			위에서 break 후 밖에 있는 for문도 break해준다.
			if (j != arCount[i]) {
				break;
			}
		}
		return bank;// 해당정보가 담겨있는 주소값을 리턴해줌
	}

//   로그인
//	외부에서 입력받은 계좌번호와 비밀번호를 전달받는다.
	public static Bank login(String account, String password) {// 객체화 없이 사용하기위해 static, 리턴값이 Bank,사용자가 로그인시도한 계좌번호와 비밀번호 받음
//		계좌번호는 checkAccount에 전달한다.
//		1) 계좌가 있다면 해당 회원의 전체 정보를 가져온다.
//		2) 계좌가 없다면 null을 가져온다.
		Bank bank = checkAccount(account);// Bank타입에 객체명 bank에 checkAccount(계정중복검사하는 메소드)실행 null값이 아닌 주소값을 받아온다면 DB로 쓰고
											// 있는 arrBank에 등록되어있는 계좌번호이니 해당 계좌가 들어있는 주소값 리턴
		if (bank != null) {// null이 아니라면 등록된 계좌번호라는 거니까 실행
//			그 회원의 비밀번호와 입력받은 비밀번호를 비교한다.
			if (bank.password.equals(password)) {// 등록된 계좌번호의 주소에들어가 password에 접근하여 등록된 비밀번호에 접근후 로그인시도된 비밀번호와 비교후 맞다면
													// 실행
//				로그인 성공 시, 회원의 전체 정보를 리턴한다.
				return bank;// 계좌도 맞고 비밀번호도 맞는 거니까 해당정보의 주소를 리턴해줌
			}
		}
//		로그인 실패 시 null을 리턴한다.
		return null;// 계좌번호나 비밀번호가 일치하지 않다면 null리턴
	}

//   입금
	public void deposit(int money) {// 입금할 금액을 받고
		this.money += money;// 받은 금액을 통장잔액에 더해줌
	}

//   출금
	public void withdraw(int money) {// 출금할 금액을 받고
		this.money -= money;// 받은 금액을 통장잔액에 뺴줌
	}

//   잔액조회
//	이 메소드가 메인에서 객체화후 .money하면 되는데 왜 이렇게 하지라는 생각이 있었는데 money는 private이기 때문에 이렇게 접근해야 하는데 생각해보면 위해 게터세터 만들면서 getMoney가 잔액을 확인해주는 역할을 하고있어서 
//	따로 만들 필요가 있나 싶다
	public int showBalance() {// 통장잔액을 리턴해줄 거기 때문에 리턴타입은 int
		return money;// 통장잔액이 담긴 변수를 리턴
	}

}
