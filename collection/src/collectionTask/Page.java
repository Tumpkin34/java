package collectionTask;

import java.util.Scanner;

public class Page {
	public static void main(String[] args) {
		User user = new User();
		UserField userField = new UserField();
		Scanner sc = new Scanner(System.in);
		String number = null;
		
//		입력받은 정보
		user.setId("hjs1234");
		user.setName("황지수");
		user.setPassword("1234");
		user.setPhoneNumber("01012341234");
		
//		아이디 중복검사 테스트		
		if(userField.checkId(user.getId()) == null) {
//		회원가입 테스트
			userField.join(user);
//			userField.users.forEach(System.out::println);
			
//			향상된 for문, 빠른 for문, forEach문
			for (User member : UserField.users) {
				System.out.println(member);
			}
//			for (int i = 0; i < UserField.users.size(); i++) {
//				System.out.println(userField.users.get(i));
//			}
			
		}
	
//		로그인 테스트
//		user = userField.login("hjs1234", "1234");//로그인 메소드 실행(성공하면 해당 주소 리턴받음)
//		if(user != null) {//null이 아니라는 것은 로그인 성공
//			System.out.println(user);//user에 재정의된 toString 실행
//		}else {
//			System.out.println("로그인 실패");
//		}
		
//		비밀번호 변경 테스트
		user = userField.checkId("hds1234");//입력한 아이디가 있는지 검사후 있다면 해당 주소 받음
		if(user != null) {//입력한 아이디가 있다면
			number = userField.sendSms(user.getPhoneNumber());//회원가입때 입력한 핸드폰 번호로 인증번호 발송
			System.out.println(number);//이거는 편의상 console에 인증번호 띄움
			
			System.out.print("인증번호 : ");
			if(number.equals(sc.next())) {//인증번호가 일치 했을 때
				System.out.print("비밀번호 : ");
				//비밀번호 변경
				user.setPassword(sc.next());
				userField.changePassword(user);
//				비밀번호 바뀌었는지 확인
				System.out.println(UserField.users.get(0));
			}
		}
		
	}
}
