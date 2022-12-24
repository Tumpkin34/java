package classTest;

import java.util.Scanner;

class SuperCar {
	// 브랜드, 색상, 가격
	// 밑에 전역변수들은 선언과 동시에 자동으로 초기화가 되어있다
	String brand; // brand선언, null로 자동으로 초기화 됨
	String color; // color선언, null로 자동 초기화됨
	int price; // price선언, 0으로 자동초기화
	boolean engine;// 초기값은 false로 자동초기화(false = 시동꺼짐, true = 시동켜짐)
	String password;// 초기값은 null로 자동초기화(여기서 String password = "0000"으로 초기화 해줄 수 있지만 생성자를 사용해 초기화해 줄
					// 예정

	public SuperCar(String brand, String color, int price) {// 초기화 생성자 브랜드, 색, 가격을 초기화 해줬다.
//		객체화 할 때 브랜드, 색, 가격을 사용자에게 객체화할 때 입력받을 예정
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.password = "0000";// password를 "0000"으로 초기화, 물론 매개변수로 사용자가 비밀번호를 설정하게 할 수 있음
//		public SuperCar(String password) {
//		      this.password = password;
//		} // 이런식으로 매개변수로 사용자가 비밀번호를 설정하게 할 수 있음
	}

	// 시동 켜기
	// 시동의 상태를 확인하고
	// 이미 시동이 켜져있다면, "시동이 이미 켜져있습니다" 출력
	// 시동이 꺼져있다면, "시동 켜기" 출력
	boolean engineStart() {// 시동켜는 메서드 선언
		if (!engine) {// 엔진의 초기값은 false(꺼짐)엔진이 꺼져있다면 !를 만나 if문 안으로 들옴(엔진을 켜줘야 하기 때문에)
			engine = true;// 엔진 true로 켜줌
			return true;// 시동켜기는 true로 할 예정
		}
		return false;// 이미 켜진 상황은 false로 할 예정
	}

	// 시동 끄기
	// 시동의 상태를 확인하고
	// 이미 시동이 꺼져있다면, "시동이 이미 꺼져있습니다" 출력
	// 시동이 켜져있다면, "시동 끄기" 출력
	boolean engineStop() {// 시동끄는 메서드 선언
		if (engine) {// 엔진true로 켜져있다면 엔진을 꺼주는 if문을 실행
			engine = false;// 엔진을 꺼줌
			return true;// 엔진 끄기를 true로 할 예정
		}
		return false;// 엔진이 이미 꺼져있다면 false로 할 예정
	}

	// [심화]
	// 시동을 켜기 위해서는 비밀번호 4자리를 입력해야 한다.
	// 입력한 비밀번호가 3회 연속 실패하면 "경찰 출동" 메세지를 출력한다.
	boolean checkPassword(String password) {// 사용자가 입력한 비밀번호가 설정된 비밀번호와 맞는지 확인하는 메서드
		return this.password.equals(password);// 파란 password = 초기비밀번호 , 갈색password = 사용자가 입력한 비밀번호,.equals()메서드 =
												// String끼리 비교하는 메서드, 비밀번호가 서로 일치한다면 true를 돌려준다
	}
}

public class Shop {// 주석 막달아서 더럽게 쓸 예정인 연습용 클래스

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);// 입력받을 준비
		SuperCar myCar = new SuperCar("Kia", "Red", 5_000);// 추상적인 SuperCar라는 클래스를 객체화, 객체화 하면서 (브랜드, 색, 가격)을 넣어 초기화 해줌
		String choiceMsg = "1. 시동켜기\n2. 시동끄기", passwordMsg = "비밀번호 4자리를 입력해주세요";// 사용자에게 보여줄 글
		int count = 0;// 비밀번호가 몇번 틀리는지 체크해줄 변수 선언
		boolean stopedEngine = false;// 엔진이 켜져있다가 꺼지면 true로 바꿔, 후에 나올 while을 끝내줄 예정
//		do{...}while(!stopedEngine && count != 3);//이부분이 잘 이해가 되지않는다 do~while을 쓰지않아도 엔진은 false,count는 0이 들어가있기 때문에 어차피 한번은 실행되는거 아닌가?
		while (!stopedEngine && count != 3) {// 엔진이 켜져있다가 꺼지거나, 비밀번호를 3회 틀리면 종료된다
			System.out.println(choiceMsg);// 시동켤지 끌지 물어보는 문구
			int choice = sc.nextInt();// 켤지 끌지 입력
			switch (choice) {// 위의 choice의 숫자로 어떤케이스를 실행시킬지
			case 1:// 1을 입력했을 때
				if (!myCar.engine) {// 엔진이 꺼져 있을때 실행할 if문(꺼져있다는건 false이기 때문에 if문을 실행시킬수 없으므로 !(not)을 붙혀 if문이 실행 될 수
									// 있게 만든다
					System.out.println(passwordMsg);// 비밀번호 입력해 달라는 문구
					String password = sc.next();// 사용자가 비밀번호를 입력
					if (myCar.checkPassword(password)) {// 비밀번호 확인하는 메소드로 이동해 비밀번호가 일치하면 true를 리턴 받아 if문을 실행시킨다
						count = 0;// 비밀번호 틀린 횟수를 초기화해서 연속해서 3회 틀리는 경우가 아닌 경우를 막는다.
						if (myCar.engineStart()) {// if문 안에있는 시동켜짐을 출력하기 위해 engineStrat라는 메소드를 실행 시켜 true값을 리턴 받는다
							System.out.println("시동켜짐");// 꺼져 있던 시동이 켜졌을 때 출력할 문구
						}
					} else {// 비밀번호가 틀렸을 때
						count++;// 비밀번호가 틀렸을 때를 세어준다.
						System.out.println("비밀번호를 " + count + "회 잘못 입력하셨습니다");// 비밀번호가 몇번 틀렸는지 확인 시켜주는 출력 메소드
						if (count == 3) {// 비밀번호가 3번 틀렸을 때 들어오게된다
							System.out.println("경찰 출동"); // 비밀번호를 3번틀렸을 때 나오는 문구
						}
					}
				} else {// 엔진을 켜려할 때 이미 엔진이 켜져 있는 경우
					System.out.println("시동이 이미 켜져있습니다");// 엔진을 켜려할떄 이미 켜져 있는 엔진을 또 켤 필요는 없어서 출력하는 문구
				}
				break;// case 1이 실행되고 2가 실행 되지 않게 막음
			case 2:// choice에서 2를 입력 했을 때
				if (myCar.engine) {// 엔진이 켜져있을 때 실행할 if문
					myCar.engineStop();// 엔진을 끄는 메소드
					System.out.println("시동꺼짐");// 엔진을 켰다고 알려주는 출력 메소드
//					if(stopedEngine = ferrari.engineStop()) { // 강사님께서 쓰신 방법 ferrari.engineStop()메소드는 켜져있는 엔진을 끄면 true를 리턴받는다. stopedEngine에 엔진을 끄고 받은 true로 초기화 시켜준다
					stopedEngine = true;// 이 코드가 실행 됐다는 뜻은 켜져있는 엔진을 껐다는 의미 반복문을 끝낼 때 사용
				} else {// 엔진이 이미 꺼져 있는 경우
					System.out.println("시동이 이미 꺼져있습니다");// 엔진이 이미 꺼져있다고 알려주는 출력 메소드
				}
				break;// 사실 밑에 더 내용이 없어서 쓰지 않아도 상관없지만 형식에 맞춰 쓴 키워드
			}
		}
	}
}
