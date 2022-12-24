package bank;

import java.util.Random;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {

		/*
		 * 1. 계좌개설 - 13자리 랜덤 계좌번호 - 기존 고객의 계좌번호와 중복이 없는 번호로 개설해야 한다. - 핸드폰 번호는 숫자만 입력하도록
		 * 하고, 문자가 포함되면 안되고 0~9사이의 정수여야 한다. - 비밀번호 4자리로만 입력하도록 한다.
		 * 
		 * 2. 입금하기 - 계좌를 개설한 은행에서만 입금 가능
		 * 
		 * 3. 출금하기 4. 잔액조회 5. 계좌번호 찾기 6. 나가기
		 */

//		은행 선택
		String msg = "1. 신한은행\n2. 국민은행\n3. 동석은행\n4. 나가기";
		String menu = "1. 계좌개설\n2. 입금하기\n3. 출금하기\n4. 잔액조회\n5. 계좌번호 찾기\n6. 은행선택메뉴로 이동";
		String name = null, account = "", phoneNumber = null, password = "";// 이따 생성자를 통해 초기화할 값들을 메인에서 변수로 만들어둔다.
		int money = 0, bankNumber = 0, choice = 0;
		String[] bankName = { "신한은행", "국민은행", "동석은행" };// 각 은행명을 일일히 출력해 주기엔 번거로워 규칙성을 부여

		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		Bank bank = null;// 계좌,비밀번호,핸드폰번호등이 담겨있는 주소를 가져와야할 일이 있어 null로 초기화

		while (true) {// ATM시작
			System.out.println(msg);// 은행 선택메세지
			bankNumber = sc.nextInt();// 원하는 은행의 번호 입력
			if (bankNumber == 4) {
				break;
			} // 4를 입력했을 경우 ATM종료

			while (true) {// 은행을 선택했다면 해당은행의 기능을 무한반복(모든은행 같은기능이다)
				System.out.println(menu);// 은행의 기능 출력
				choice = sc.nextInt();// 기능 선택
				if (choice == 6) {
					break;
				} // 6입력시 다시 가까운 반복문을 종료후 은행선택 창으로 돌아감

				switch (choice) {// 위에서 입력한 choice의 값을 이용해 case에 접근
				case 1: // 계좌개설
					Bank[] arBank = { new Shinhan(), new Kookmin(), new Hana() };// 각클래스의 주소값을 클래스배열에 저장

					while (true) {// 랜덤으로 계좌를 만들었을 때 그 계좌가 중복된 계좌이면 반복
						account = "";// 랜덤으로 생성된 계좌번호를 받을 변수
						for (int i = 0; i < 12; i++) {// 은행번호로 쓰일 앞자리를 제외한 12자리의 랜덤한 숫자를 받기위해 반복
							account += r.nextInt(10);// 각 자리수의 숫자를 랜덤으로 받아 account에 연결
						}
						// 쓸데없이 객체화를 해야 할 때에는 빨리 static으로 전환한다!
						// Bank bank = new Bank();
						// bank.checkAccount()
						if (Bank.checkAccount(account) == null) {
							break;
						} // 중복된 계좌가 없으니까 while문 종료
					}
					// 은행 번호를 맨 앞에 추가해준다.
					account = bankNumber - 1 + account;// 위에서 생성된 랜덤한 account앞에 은행번호를 붙여줌

					arBank[bankNumber - 1].setAccount(account);// 선택한 은행클래스의 주소값에 setter로 주소값에 접근해 저장

					System.out.print("예금주 : ");
					name = sc.next();

					arBank[bankNumber - 1].setName(name);// 위에 입력한 이름을 바로 선택한 은행클래스의 name에 저장

					while (true) {// 반복문
						System.out.print("핸드폰 번호['-' 제외] : ");
						phoneNumber = sc.next();

						// 숫자만 있는 지
						int i = 0;
						for (i = 0; i < phoneNumber.length(); i++) {// 입력한 phoneNumber의 길이만큼 반복
							char c = phoneNumber.charAt(i);// c변수에 phoneNumber에 i번째 문자를 받아옴
							if (c < 48 || c > 57) {// 아스키코드상 48 = 0, 57 = 9 이범위를 벗어낫다는것은 숫자가 아니라는 뜻
								break;// 숫자가 아니라면 실행됨
							}
						}

						if (i != phoneNumber.length()) {// i가 11아니라는건 입력한 핸드폰번호에 숫자가아닌 문자가 입력되어 break를 만나 반복문을 다 돌지 못했다는
														// 뜻
							System.out.println("숫자만 입력해주세요.");
							continue;// 핸드폰을 입력하는 반복문 처음으로 돌아간다.
						}

						// 입력한 문자열 값이 11자리인지
						if (phoneNumber.length() != 11) {// 2022년 기준 핸드폰번호는 11자리이기 때문에 11자리가 아닌경우 실행
							System.out.println("핸드폰 번호를 입력해주세요.");
							continue;// 핸드폰을 입력하는 반복문 처음으로 돌아간다.
						}
						// 핸드폰 번호가 중복되었는 지
						if (Bank.checkPhoneNumber(phoneNumber) != null) {// 중복된 핸드폰 번호가 있는지 찾아주는 메소드에 접근해 중복된 번호가 있는 경우
																			// 주소값을 없을 경우 null을 받아오기에 null이 아닌 경우 실행
							System.out.println("중복된 핸드폰 번호입니다.");
							continue;// null이 아니라는건 중복된 번호가 있는 거니까 핸드폰을 입력하는 반복문 처음으로 돌아감.
						}
						// 010으로 시작하는 지
						if (!phoneNumber.startsWith("010")) {// 새로운 메소드 : startWith 문자열의 처음부터 전달한 값과 비교해 전달한값이 처음부터 있으면
																// true아니면, false
							System.out.println("핸드폰 번호를 입력해주세요.");
							continue;// 요즘은 대부분 010으로 시작하기에 아니라면 핸드폰을 입력하는 반복문 처음으로 돌아간다.
						}
						break;
					}

					arBank[bankNumber - 1].setPhoneNumber(phoneNumber);// 위에 입력한 핸드폰번호를 선택한 은행의 phoneNumber에 저장

					password = "";// 이미 입력된 값이 있을 수 있는 비밀번호 변수 초기화
					while (password.length() != 4) {// 위에서 ""로 초기화 했기 때문에 실행, 또는 밑에서 4자리 비밀번호가 아닐경우 반복
						System.out.print("비밀번호(네자리) : ");
						password = sc.next();
					}

					arBank[bankNumber - 1].setPassword(password);// 입력한 비밀번호 4자리를 선택한 은행의 password에 저장

//					do {
//						System.out.print("비밀번호 : ");
//						password = sc.next();
//					} while (password.length() != 4);

					Bank.arrBank[bankNumber - 1][Bank.arCount[bankNumber - 1]] = arBank[bankNumber - 1];// [선택한 은행번호의
																										// 행안에] [선택한 은행의
																										// 등록회원수에 접근해
																										// 등록된 회원수의
																										// 열에]=위에 각클래스의
																										// 주소를 담은
																										// arBank배열의
																										// [은행번호]안에 있는
																										// 주소 값을 저장
					Bank.arCount[bankNumber - 1]++;// 해당은행번호 행에 등록회원수 1증가

					System.out.println("🎉🎉🎊🎊🎉🎉🎊🎊🎉🎉🎊🎊🎉🎉🎊🎊🎉🎉🎊🎊🎉🎉🎊🎊");
					System.out.println("축하합니다. 감사합니다. 사랑합니다.");
					System.out.println("더 노력하는 " + bankName[bankNumber - 1] + "이 되겠습니다!");
					System.out.println("고객님의 계좌번호는 " + account + "입니다.");
					System.out.println("분실 시 계좌번호 찾기 서비스를 이용해주세요~!");
					System.out.println("🎉🎉🎊🎊🎉🎉🎊🎊🎉🎉🎊🎊🎉🎉🎊🎊🎉🎉🎊🎊🎉🎉🎊🎊");
					break;
				case 2: // 입금하기
					System.out.print("계좌번호 : ");
					account = sc.next();

					if (account.charAt(0) - 48 != bankNumber - 1) {// 만약(입력한 계좌의 0번째 인덱스(은행번호)가 (char타입이기 때문에 - 48) 너가
																	// 선택한 은행번호와 같지않으면 true)
						System.out.println("계좌를 개설한 은행에서만 입금 서비스를 이용하실 수 있습니다.");
						break;// 다시 은행의 기능 선택창으로 이동
					}

					System.out.print("비밀번호 : ");
					password = sc.next();

					bank = Bank.login(account, password);// bank에 = Bank클래스안의 login메소드를 사용해 입력한 계좌와 비밀번호를 넘겨주고 해당 계좌와
															// 비밀번호가 담긴 주소를 넘겨받고 저장
					if (bank != null) {// 만약(bank가 null이 아니라면 해당 계좌정보가 담긴 주소를 찾은 거니까 true)
						System.out.print("입금액 : ");
						money = sc.nextInt();
						if (money < 0) {
							System.out.println("금액이 잘못 입력되었습니다^^");
							break;
						} // 입금액이 -가 되지않게 막음
						bank.deposit(money);// 업캐스팅된 각은행클래스의 기능인 입금을 사용, 은행에 따라 입금메소드가 오버라이딩되어있는경우가 있음 입력한 입금액을 넘겨줌
						break;// 입금했으니 은행기능 창으로 이동
					}
					System.out.println("계좌번호나 비밀번호를 다시 확인해주세요.");
					break;// 계좌나 비밀번호를 틀렸을 경우에도 은행기능 창으로 이동
				case 3: // 출금하기
					System.out.print("계좌번호 : ");
					account = sc.next();
					System.out.print("비밀번호 : ");
					password = sc.next();

					bank = Bank.login(account, password);// bank에 = Bank클래스안의 login메소드를 사용해 입력한 계좌와 비밀번호를 넘겨주고 해당 계좌와
															// 비밀번호가 담긴 주소를 넘겨받고 저장
					if (bank != null) {// 만약(bank가 null이 아니라면 해당 계좌정보가 담긴 주소를 찾은 거니까 true)
						System.out.print("출금액 : ");
						money = sc.nextInt();
						if (money < 0) {
							System.out.println("금액이 잘못 입력되었습니다^^");
							break;
						} // 출금액이 -가 되지않게 막음
						if (bank.showBalance() - (bank instanceof Kookmin ? money * 1.5 : money) < 0) {// 만약(통장잔고를 가져오고
																										// 은행에 따른
																										// 출금액(가져온 주소가
																										// 국민타입이면 수수료 포함
																										// 아닌경우 수수료없는
																										// 금액)을 뺏을 때
																										// 잔고보다 크면 마이너스
																										// 통장이 되니까
																										// 잔고-출금액(with수수료)가
																										// 0보다 작다면 실행)
							System.out.println("잔액이 부족합니다");
							break;// 은행기능 창으로 이동
						}
						bank.withdraw(money);// 위 조건이 아니라면 실행 출금 메소드 실행 위에서 받아온 주소값의 타입에 따라 오버라이딩된 메소드 실행
						break;// 은행기능 창으로 이동
					}
					System.out.println("계좌번호나 비밀번호를 다시 확인해주세요.");
					break;// 은행기능 창으로 이동
				case 4: // 잔액조회
					System.out.print("계좌번호 : ");
					account = sc.next();
					System.out.print("비밀번호 : ");
					password = sc.next();

					bank = Bank.login(account, password);// bank에 = Bank클래스안의 login메소드를 사용해 입력한 계좌와 비밀번호를 넘겨주고 해당 계좌와
															// 비밀번호가 담긴 주소를 넘겨받고 저장
					if (bank != null) {// 만약(bank가 null이 아니라면 해당 계좌정보가 담긴 주소를 찾은 거니까 true)
						System.out.println("현재 잔액 : " + bank.showBalance() + "원");// 해당 주소에 저장된 잔고 확인
					}
					break;// 은행기능 창으로 이동
				case 5: // 계좌번호 찾기
					System.out.print("핸드폰 번호 : ");
					phoneNumber = sc.next();

					bank = Bank.checkPhoneNumber(phoneNumber);// 등록된 핸드폰 번호중 입력한 핸드폰 번호가 있는지 확인후 있다면 해당 핸드폰정보를 담고있는 주소
																// 저장

					if (bank != null) {// 만약(bank가 null이 아니라면 해당 핸드폰번호가 담긴 주소를 찾은 거니까 true)
						System.out.print("비밀번호 : ");
						password = sc.next();
						if (bank.getPassword().equals(password)) {// 가져온 주소에 저장된 비밀번호와 입력한 비밀번호가 일치하면 실행
							while (true) {// 랜덤으로 계좌를 만들었을 때 그 계좌가 중복된 계좌이면 반복
								account = "";// 랜덤으로 생성된 계좌번호를 받을 변수
								for (int i = 0; i < 12; i++) {// 은행번호로 쓰일 앞자리를 제외한 12자리의 랜덤한 숫자를 받기위해 반복
									account += r.nextInt(10);// 각 자리수의 숫자를 랜덤으로 받아 account에 연결
								}
								if (Bank.checkAccount(account) == null) {
									break;
								} // 중복된 계좌가 없으니까 while문 종료
							}
							// 은행 번호를 맨 앞에 추가해준다.
							account = bankNumber - 1 + account;// 위에서 생성된 랜덤한 account앞에 은행번호를 붙여줌

							bank.setAccount(account);// 가져온 주소값에 setter로 주소값에 접근해 저장(덮어쓰기)
						}
					}
					break;
				}

			}

		}

	}
}
