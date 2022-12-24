package jobTaskT;

import java.util.Scanner;

public class Street {
	public static void main(String[] args) {
		OakSeller seller = new OakSeller();// OakSeller객체화 값을 안넘겨줬기 때문에 OakSeller에서 자동으로 "장판옥", 0을 넣어줄 예정이다.
		Scanner sc = new Scanner(System.in);

		String msg = "1. 판매하기\n2. 승진하기\n3. 내 정보\n4. 나가기";
		int choice = 0, resultSold = 0;//입력한 값을 받을 변수, seller메소드 실행하고 받을 변수

		while (true) {// 게임 무한반복
			System.out.println(msg);
			choice = sc.nextInt();// 선택한 번호입력
			if (choice == 4) {
				break;
			} // 4일 경우 while문 종료(게임종료)

			switch (choice) {// choice를 기준으로 case를 실행
			case 1: // 판매하기
				resultSold = seller.sell();//판매 메소드 실행후 각 결과에 맞는 숫자를 돌려받고 변수에 저장/ 성공 : 0, 대성공 : 1, 실패 : -1

				switch (resultSold) {//결과가 담김 변수를 기준으로 case를 실행
				case 0: // 성공
					System.out.println("휴~ 옥장판 판매 성공!");
					break;
				case 1: // 대성공
					System.out.println("아자뵤~! 옥장판 판매 대성공!");
					break;
				case -1:// 실패
					System.out.println("앗");
					if (seller.count == 3 && seller.positionNumber != 0) {//연속으로 3번 판매에 실패하고 사원이 아닐경우 실행
						seller.demote();//강등 메소드 실행
						System.out.println(seller.table[seller.positionNumber] + "으로 좌천되었습니다...");//강등 메소드를 갔다왔으면 positionNumber는 -1 되었기 때문에 해당 직급번호를 찾아 알려준다.
					}
					break;
				}
				System.out.println("내 통장 잔고 : " + seller.income + "만원");//성공,실패 어떤 경우던 자신이 소지금을 출력한다.

				break;
			case 2: // 승진하기
				if (seller.positionNumber == 2) {//이미 다이아일 경우 더이상 승진할 직급이 없기 때문에 그경우를 막아준다.
					System.out.println("승진하실 수 없습니다.");
					break;
				}
				if (seller.promote()) {//승진 메소드 실행 각확률로 승진에 성공할 경우 true를 리턴 받는다.
					seller.count = 0;//승진에 성공할 경우 판매 실패 횟수 초기화
					System.out.println(seller.table[seller.positionNumber] + "(으)로 승진하셨습니다!!!!");
					System.out.println("내 통장 잔고 : " + seller.income + "만원");
					break;
				}
				System.out.println("승진 실패....");
				System.out.println("내 통장 잔고 : " + seller.income + "만원");
				break;
			case 3: // 내 정보.
//				각 전역변수를 호출해 정보를 알려준다.
				System.out.println("이름 : " + seller.name);
				System.out.println("직급 : " + seller.table[seller.positionNumber]);
				System.out.println("내 통장 잔고 : " + seller.income);
				System.out.println("판매 성공률 : " + seller.successRating + "%");
				break;
			}
		}
	}
}
