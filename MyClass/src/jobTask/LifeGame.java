package jobTask;

import java.util.Scanner;

public class LifeGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Job conArtist = new Job("황지수", "conArtist", 500_000, 5);
		int choice = 0;
		String actMsg = "할일을 선택하세요 \n1. 일하러 가기\n2. 잠자기\n3. 옥살이 하러가기\n4. 그만하기";
		while (true) {
			if (conArtist.life <= 0) {
				System.out.println("때로는 자기몸을 돌볼 필요가 있겠군요");
				break;
			}
			System.out.println("-------------------------------------");
			System.out.println(actMsg);
			choice = sc.nextInt();
			if (choice == 1) {
				switch (conArtist.work()) {// 대성공 : 0, 성공 : 1, 실패 : 2, 고소 : 3
				case 0:
					System.out.println("야호 오늘은 대어를 낚았다!!");
					System.out.println("+" + conArtist.income * 1000000 + "원");
					break;
				case 1:
					System.out.println("오늘도 내 말솜씨에 감탄했다.");
					System.out.println("+" + conArtist.income * 1000000 + "원");
					break;
				case 2:
					System.out.println("오늘은 안되는 날인가 보다");
					break;
				case 3:
					System.out.println("오늘은 고소를 당해서 합의를 봤다.\n재수가 없다.");
					System.out.println("-" + conArtist.income * 1000000 + "원");
					break;
				}
				System.out.println("현재 소지금 : " + conArtist.money);
				System.out.println("현재 사기에 성공할 확률 : " + conArtist.rating);
				if (conArtist.rate(10) == 1) {
					System.out.println("피해자가 찾아와 구타를 가했다.");
					System.out.println("체력 -2");
					conArtist.life -= 2;
					System.out.println("현재 체력 : " + conArtist.life);
				}

			} else if (choice == 2) {
				System.out.println("휴식중");
				for (int i = 0; i < 3; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.print("z");
				}
				System.out.println();
				conArtist.sleep();
				System.out.println("체력 +2");
				System.out.println("현재 체력 : " + conArtist.life);

			} else if (choice == 3) {
				System.out.println("옥살이 중");
				for (int i = 0; i < 3; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.print("영차");
				}
				conArtist.goToPrison();
				System.out.println();
				System.out.println("옥살이 동안 많은 사람들의 기억속에서 잊혀진거같다.");
				System.out.println("사기에 성공할 확률 +20(최대 성공률 90");
				System.out.println("현재 사기에 성공할 확률 : " + conArtist.rating);

			} else if (choice == 4) {
				System.out.println("오늘도 보람찬 하루였다.");
				break;
			} else {
				System.out.println("?");
			}
		}

	}

}
