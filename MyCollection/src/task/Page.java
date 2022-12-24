package task;

import java.util.Scanner;

public class Page {
	public static void main(String[] args) {
		UserField uf = new UserField();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		String name = "", id = "", pw = "", phoneNumber = "";

		while (true) {
			System.out.println("1. 회원가입\n2. 로그인\n3. 비밀번호 찾기");
			choice = sc.nextInt();
			switch (choice) {
			case 1:// 회원가입
				while (true) {
					User user = null;
					System.out.print("아이디 : ");
					id = sc.next();
					if (uf.checkId(id) != null) {
						System.out.println("이미 사용중인 아이디입니다.");
						continue;
					}
					System.out.print("비밀번호 : ");
					pw = sc.next();
					System.out.print("이름 : ");
					name = sc.next();
					System.out.print("핸드폰 : ");
					phoneNumber = sc.next();
					user = uf.signup(name, id, pw, phoneNumber);
					System.out.println("회원가입을 축하드립니다.");
					System.out.println(user);
					break;
				}

				break;
			case 2:// 로그인
				while (true) {
					System.out.print("아이디 : ");
					id = sc.next();
					System.out.print("비밀번호 : ");
					pw = sc.next();
					User user = uf.login(id, pw);

					if (user == null) {
						System.out.println("아이디 또는 비밀번호를 다시 확인해주세요");
						continue;
					}
					System.out.println("로그인 성공!! " + user.getName() + "님 환영합니다");
					break;
				}
				break;
			case 3:// 비밀번호 찾기
				System.out.println(uf.users.size());
				System.out.print("아이디 : ");
				id = sc.next();
				User user = uf.checkId(id);
				if (user != null) {
					String certificationNumber = "";

					System.out.println("해당 아이디에 등록 되어있는 휴대폰 번호로 인증번호를 발송했습니다");
					uf.sendSms(user);
					System.out.println(UserField.tempNumber);
					while (true) {
						System.out.print("인증 번호 : ");
						certificationNumber = sc.next();
						if (UserField.tempNumber.equals(certificationNumber)) {
							System.out.print("새로운 비밀번호 : ");
							pw = sc.next();
							uf.changePassword(user, pw);
							System.out.println("비밀번호가 변경되었습니다.");
							System.out.println(user);
							break;
						}
						System.out.println("인증번호가 틀렸습니다");
						break;
					}
				} else {
					System.out.println("등록된 아이디가 아닙니다.");
					break;
				}
			}

		}

	}
}
