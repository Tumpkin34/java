package bakery;

public class BreadMaker implements Runnable {

	public static boolean check;

	@Override
	public void run() {
//	빵을 20개 만든다.		
		int i = 0;
		for (i = 0; i < 20; i++) {
			BreadPlate.getInstance().makeBread();//빵을 만듬
			if (check) {//강제로 오류를 발생시키고 catch로 check가 true가 되었을 때
				break;//빵그만 만듬
			}
			try {
				Thread.sleep(1000);//빵만드는데 걸리는 시간
			} catch (InterruptedException e) {
				break;
			}
		}
		if (i != 20) {//위의 for문이 끝났을때 빵을 다 만들지 않았는데 손님이 나간경우
			System.out.println("안녕히가세요");
			return;
		}
		System.out.println("재료 소진");//빵을 20개를 다 만들었을 경우
	}
}
