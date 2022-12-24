package bakery;

//	싱글톤 패턴
//	객체는 무조건 한 개만 만들고 돌려 쓴다.
public class BreadPlate {

	public static BreadPlate breadPlate;//밑에 getInstance메소드로 주소 넣어줌

	public int breadCount;
	public int eatCount;

	private BreadPlate() {//기본생성자를 private으로 생성
		;
	}

	public static BreadPlate getInstance() {//getInstance로 생성자에 접근함
		if (breadPlate == null) {//생성된 주소가 없을 경우
			breadPlate = new BreadPlate();//생성
		}
		return breadPlate;//정적변수 주소 리턴
	}

//	빵만들기
//	만든 빵이 9개가 넘어가면, 쓰레드를 멈춰준다
	public synchronized void makeBread() {// 동기화 목적 notify쓰려고
		if (breadCount > 9) {
			System.out.println("빵이 가득 찼습니다.");
			try {
				wait();//빵이 가득 찼을경우
			} catch (InterruptedException e) {//빵이 가득 찼을 때 나갈경우
				BreadMaker.check = true;//BreadMaker.check를 true로 바꿔 스레드를 종료 시킬 예정
			}
		} else {
			breadCount++;//빵을 만듬
			System.out.println("빵을 1개 만들었습니다. 현재 빵 개수 : " + breadCount + "개");
		}
	}

//	빵먹기
//	만든 빵이 0개면 못먹고, 먹은 빵이 20개면 못먹는다.
//	만약 빵을 먹게 되면, 멈춰있던 쓰레드를 깨워준다.
	public synchronized void eatBread() {//
		if (eatCount == 20) {//20개를 먹었을 경우
			System.out.println("빵이 다 떨어졌습니다!");
		} else if (breadCount < 1) {//먹으려 시도 했지만 먹을 빵이 없는 경우
			System.out.println("빵을 만들고 있어요!🥞🥞🥞🥞");
		} else {
//			먹은 경우 
			eatCount++;//먹은 빵 개수 업
			breadCount--;//남은 빵 개수 다운
			System.out.println("빵을 1개 먹었습니다. 현재 빵 개수 : " + breadCount + "개");
			notify();//스레드 재시작(스레드가 멈춰있을 경우에만 종료된다.)
		}
	}
}
