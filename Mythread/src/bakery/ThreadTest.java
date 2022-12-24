package bakery;

public class ThreadTest implements Runnable {
	@Override
	public void run() {
		while (true) {
			System.out.println("실행중...");
			if (Thread.interrupted()) {//메인에서 interrupted를 사용하면 true로 바뀌고 
				break;//해당 스레드 종료
			}
		}
	}
}
