package jobTaskT;

import java.util.Random;

public class OakSeller {

	String[] table = { "사원", "팀장", "다이아" };
	int[] pay = { 0, 10_000, 100_000 };
	int[] incomes = { 1_000, 3_000, 9_000 };

//  게임에 필요한 변수들 선언
	String name;
	int positionNumber;
	int successRating;
	int income;
	int count;

	Random r = new Random();//랜덤 준비물

	public OakSeller() {//사용자가 입력을 안했을 때
		this("장판옥", 0);//this로 OakSeller클래스에 접근한다. 이값들로 초기화 해준다.
	}

	public OakSeller(String name, int positionNumber) {//이름과 직급에 해당하는 번호를 받는다.
		//받은 값으로 초기화 해준다. 
		this.name = name;
		this.positionNumber = positionNumber;
		this.successRating = 50;// 초기 성공확률은 50으로 정해준다. 
	}

	int sell() { // 성공 : 0, 대성공 : 1, 실패 : -1
		if (rate(successRating)) { // 성공 확률을 실행할 메소드 넘겨준 확률에 성공하면 true를 리턴 받는다.
			count = 0;// 판매에 성공했을 경우 count를 0으로 초기화해준다.
			if (rate(20)) { // 대성공 확률메소드 실행 20%확률에 성공하면 true를 받는다.
				income += incomes[positionNumber] * 3;//소지금에 각 직급에해당한는 인덱스번호에 있는 이익*3을 더한다.
				successRating += 5;//대성공시 판매할 확률을 5% 늘려준다.
				return 1;// 대성공을 했기 때문에 1리턴
			}
			income += incomes[positionNumber];//위에 if문에 들어가지 못했을 경우(20%확률에 실패했을 경우) 소지금에 각 직급에해당하는 인덱스번호에 있는 이익을 더한다. 
			successRating -= 2;//그냥 성공할 경우 확률이 2떨어진다.
			return 0;// 일반성공은 0을 리턴한다.
		}
		// 실패
		count++;//판매에 실해했을 경우 카운트한다.
		income -= 2_000;//소지금에 2_000을 빼준다.
		return -1;//실패는 -1을 리턴
	}

	void demote() {//강등 메소드
		positionNumber--;//현재직급번호에 -1을 한다.
	}

	boolean promote() {// 승진심사
		income -= pay[positionNumber + 1];// 각직급에 맞는 승진에 필요한 돈을 지불한다.
		if (positionNumber == 0 ? rate(30) : rate(10)) {//positionNumber가 0이라는 건 직급번호상 사원이라는 것이기 때문에 0일경우 팀장으로 승진을, 아니라는 거는 팀장이라는 거니까 다이아로 승진할 확률의 메소드를 호출하고 성공시 true를 리텀 받으면 실행
			positionNumber++;// 직급번호에 +1을 해줘 승진
			return true;// 승진해 성공할 경우 true를 리턴해준다 
		}
		return false;// 승진 실패
	}

	boolean rate(int rating) {// 확률을 실행하는 메소드
		int[] percent = new int[100];// 100칸 배열이니까 1% 단위로 할 예정이다
		for (int i = 0; i < rating; i++) {// 매개변수로 받아온 확률만큼 반복한다.
			percent[i] = 1;//매개변수로 받아온 확률만큼 배열에 1을 넣는다.
		}

		return percent[r.nextInt(percent.length)] == 1;//1이나왔다는 건 각확률에 성공했다는 것이고 성공했을 경우 true로 리턴해준다 애초에 percent를 boolean으로 해줬으면 비교할 필요는 없을거같다.
	}
}
