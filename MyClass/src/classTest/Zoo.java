package classTest;

import java.util.Scanner;

public class Zoo {

	public static void main(String[] args) {
//		클래스 배열(동물이름, 나이, 먹이, 먹이개수, 생명을 담고있는 주소값을 모은 배열이다)
		Animal[] animals = { new Animal("코끼리", 120, "풀", 2, 8), new Animal("토끼", 3, "당근", 8, 2),
				new Animal("타조", 5, "지렁이", 5, 5) };

//		클래스 배열(문제, 정답, 보상, 잭팟여부를 담고있는 주소값을 모은 배열이다)
		Quiz[] quizes = {
				new Quiz("Q.바나나를 엄마가 사왔어요, 형이 3개 먹고 내가 5개를 먹었더니 한 개가 남았어요. 엄마가 사온 바나나는 총 몇 개였을까요?", "9", 10, false),
				new Quiz(
						"Q.다음 어린이 중 누가 착한 행동을 했을까요?\n1. 요구르트를 훔친 철수\n2. 친구를 바닥에 눕힌 영희\n3. 늦게 왔으면서 수업에 딴짓까지 해버리는 동석\n4. 엄마 어깨를 안마해주는 유리",
						"4", 2, false),
				new Quiz("Q.횡단보도를 건널 수 있는 방법을 고르세요. \n1. 빨간불일 때 건넌다. \n2. 뛰어간다\n3. 손을 들고 초록불에 건넌다.\n4. 핸드폰을 보면서 건넌다.",
						"3", 5, false),
				new Quiz("Q. 다음중 속성이 다른 것은?\n1. 초콜릿폰\n2. 캔디폰\n3. 대포폰\n4. 롤리팝", "3", 100, true),
//				new Quiz("Q. 다음 중 프로그래밍 언어가 아닌 것은?\n1.C언어\n2. JAVA\n3. 파이썬\n4. 망둥어", "4", 3000, true) 
		};

		Scanner sc = new Scanner(System.in);// 입력받을 준비 스캐너클래스 객체화

//		게임에 사용할 멘트들
		String title = "모여라 셀럽동물";
		String menuMessage = "안녕하세요 어린이 여러분! \n 동물 친구를 선택해보세요! \n1. 코끼리\n2. 토끼\n3. 타조\n4. 나가기";
		String actionMessage = "1.먹기\n2.잠자기\n3.산책하기\n4. 내 정보\n5. 작별인사하기";
		
		int characterNumber = 0, actionChoice = 0;// 각 선택지의 입력할 값을 받을 변수

		while (true) {//게임을 무한반복
			System.out.println(title);
			System.out.println(menuMessage);
			
			characterNumber = sc.nextInt();//캐릭터 선택을위해 정수입력
			if (characterNumber == 4) {//캐릭터를 선택하지 않고 4(나가기)를 눌렀을 때 실행
				break;//위에 반복문을 종료
			}

			while (true) {// 선택할 캐릭터가 할 행동 무한반복
				System.out.println(actionMessage);
				actionChoice = sc.nextInt();//행동번호 입력 
				if (actionChoice == 5) {//5(작별인사하기)를 눌렀을 경우
					break;// 가까운 반복문 종료
				}

				Animal animal = animals[characterNumber - 1];//위에서 선택한 동물 객체화 인덱스번호는 0부터 시작이기 때문에 입력받은 값에서 -1

				switch (actionChoice) {// 입력받은 행동번호로 케이스를 나누겠다
				case 1:// 먹기
					if (animal.feedCount > 0) {// 먹이 1개이상일 경우에 먹기를 실행할 수 있다
						animal.eat();// animal클래스에 있는 eat메소드 실행
//						eat메소드 실행후 출력할 멘트와 정보
						System.out.println("냠냠 맛있어!!");
						System.out.println(animal.name + "의 체력 :" + animal.life);
						System.out.println(animal.name + "의 먹이 개수 :" + animal.feedCount + "개");
						break;// switch문을 탈출
					}

					System.out.println(animal.feed + "이(가) 부족해요 ㅠㅠ \n퀴즈를 풀어서 먹이를 획득하세요!");//먹이가 0개일 경우 실행

					break;
				case 2:// 잠자기
					System.out.print(animal.name + "이(가) 자는 중");
					for (int i = 0; i < 3; i++) {//3번 반복을 하겠다
						try {
							Thread.sleep(1000);//1초 기다리는 것을
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.print(".");//1초마다 .을 쓰겠다.
					}
					animal.sleep();//sleep메소드 실행
					System.out.println();// 위의 .출력할때 줄바꿈을 안해줬으니까 여기서 해준다.

					break;
				case 3:// 산책하기
					if (animal.life > 1) {//산책을 하면 샘명이 1깍이기 때문에 2이상부터 실행
						Quiz quiz = animal.walk(quizes);//walk메소드를 실행시켜 문제의 주소를 받고 그 주소를 객체화 한다. 
						if(quiz.jackPot) {// 객체화한 퀴즈가 잭팟(true)라면 실행
							System.out.println("!!!!!!떳다!!!!!!!!!!!!!");
						}
						System.out.println(quiz.question);//퀴즈 주소안에 question(전역변수)에 저장해놓은 문제 출력 
						if (quiz.answer.equals(sc.next())) {// 퀴즈안에 저장된 정답이 입력한 정잡이랑 같을 경우 실행
							System.out.println("정답!!");
							animal.feedCount += quiz.feedCount;// 동물안에 저장된 먹이개수에 퀴즈안에 저장된 보상의 개수만큼 더하기
//							먹이 획득개수, 현재 먹이개수 출력
							System.out.println(animal.feed + " " + quiz.feedCount + "개 회득!");
							System.out.println(animal.feed + " 개수 : " + animal.feedCount + "개");
							break;
						}
						System.out.println("오답이에요 ㅠㅠ");//입력한 답이 틀렸을 경우
						animal.life--;//오답일 경우 생명 -1

						if (animal.life == 0) {//퀴즈에 틀려 오답일 경우 생명이 -1 되기때문에 생명이 0이 되는 경우가 생기는데 그때 실행
							System.out.print(animal.name + "이(가) 자는 중");
							for (int i = 0; i < 3; i++) {// 3번 반복 밑에 까지 해석하면 1000밀리초니까 3초를 소요한다.
								try {
									Thread.sleep(1000);//1000밀리초 = 1초 동안 멈추기
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								System.out.print(".");// .출력
							}
							animal.sleep();//생명 회복을 위해 sleep메소드를 통해 생명 회복
							System.out.println();// .을 가로로 출력하기위해 println대신 print를 썻기 때문에 줄바꿈 해주기 위해
						}
						break;
					}

					System.out.println("체력이 부족해요 ㅠㅠ 잠을 자고 오세요!");//생명이 1일 경우 if문을 실행 시키자마자 생명 -1 하기 때문에 생명이 1일 경우 실행

					break;
				case 4:
//					animal클래스의 각 변수를 호출
					System.out.println("이름 : " + animal.name);
					System.out.println("나이 : " + animal.age + "살");
					System.out.println("먹이 : " + animal.feed);
					System.out.println("먹이 개수 : " + animal.feedCount);
					System.out.println("체력 : " + animal.life);
					break;
				default:// 1~5숫자가 아닌 다른 것을 입력할 경우
					System.out.println("다시 입력해주세요!");
					break;
				}
			}
		}
	}
}
