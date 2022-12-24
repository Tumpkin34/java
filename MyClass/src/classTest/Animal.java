package classTest;

import java.util.Random;

public class Animal {
//	게임에 사용할 정보들 전역변수로 선언
	String name;
	int age;
	String feed;
	int feedCount;
	int life;

//	기본생성자	
	public Animal() {
	}

//	초기화 생성자
	public Animal(String name, int age, String feed, int feedCount, int life) {//매개변수로 받은 값을 전역변수에 담는다.
		this.name = name;
		this.age = age;
		this.feed = feed;
		this.feedCount = feedCount;
		this.life = life;
	}

//	먹는 기능 구현
	void eat() {
		feedCount--;
		life++;
	}

//	자는 기능 구현
	void sleep() {
		life++;
	}

//	외부에서 모든 문제를 전달받는다.
//	전달받은 문제 중 랜덤한 한 개의 문제만 리턴한다.
	Quiz walk(Quiz[] quizes) {// 산책기능 구현 Quiz배열의 주소를 받는다. 주소는 퀴즈 문제와 답 보상 개수를 알고있는 생성자가 담겨있다.
		Random r = new Random();// 랜덤 준비물(랜덤클래스 생성자)
		Quiz quiz = null;// 아직 어떤 퀴즈를 넘겨줄지 모르기 때문에 null로 초기화해준다.

		life--;
		
//		잭팟 문제, 확률은 10%
//		확률이 10단위라면 10칸 배열을 , 1단위라면 100칸 배열을 선언한다.
//		int배열로 선언한 뒤 사용자가 원하는 확률 만큼 1로 값을 바꿔준다.

//		예)30% 확률이라면 10칸 배열에 3개의 값만 1로 바꿔준다.
//		따라사 원하는 확률/ 10을 하여 반복횟수를 결정해주고,
//		그 만큼 1이 들어가게 된다.

//		위의 배열이 완성되었으면 랜덤한 인덱스번호로 값에 접근하여
//		1이 나왔을 때에는 원하는 확률로 성공한 것이고,
//		0이 나왔을 때에는 실패한 것이다.
		
//		확률 알고리즘
//		10칸 짜리 배열에 1을 임의의 개수 만큼 넣어주고
//		배열의 인덱스번호를 랜덤으로 돌려줄때 1의 개수만큼 많을수록 1이 나올 확률이 커지고 반대로 1이 적을수록 0이 나올 확률이 커진다 
//		이걸 통해 확률을 구현할 수 있다.
		int[] percent = new int[10];// 10%단위로 할예정이 때문에 10칸 배열 생성
		int rating = 10;// 확률을 10%로 설정
		for (int i = 0; i < rating / 10; i++) {// 10칸 배열의 하나의 방이 1이라면 10의 10퍼센트이기 때문에 10으로 나눠준 후 나눠진 수 만큼 반복
			percent[i] = 1;// 0번째 방부터 1을 넣어줌
		}

		if (percent[r.nextInt(percent.length)] == 1) {// 구현한 확률 사용 persent의 인덱스번호를 persent의 길이범위의 랜덤만큼 돌리고 그 결과가 1이라면(10% 확률로 성공했을 때) 실행할 문장 
			for (int i = 0; i < quizes.length; i++) {// 문제중에 잭팟 문제를 찾는다.
				if (quizes[i].jackPot) {// 잭팟문제는 jackpot에 true값을 넣어놨기 때문에 잭팟을 찾으면 if문을 실행
					return quizes[i];// 찾은 잭팟문제의 주소를 리턴해준다. 
				}
			}
		}
		while (true) {// 일반문제를 찾는다. 잭팟일 경우 반복
			quiz = quizes[r.nextInt(quizes.length)];//랜덤한 문제를 객체화 하고
			if (!quiz.jackPot) {//객체화한 문제가 잭팟(true)이라면 !을 만나 if문이 실행 되지않고 일반문제(false)라면 !을 만나 if문을 실행한다.
				break;//들어 왔다는건 일반문제를 찾았다는 것이니까 반복문을 종료해준다.
			}
		}
		return quiz;// 위에 객체화한 일반문제의 주소를 넘겨준다.

	}

}
