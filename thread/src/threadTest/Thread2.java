package threadTest;

public class Thread2 implements Runnable{
	
	@Override
	public void run() {
		//자원
		for (int i = 0; i < 10; i++) {
//			currentThread()접근한 객체의. name을 출력 
			System.out.println(Thread.currentThread().getName());
			try {Thread.sleep(500);} catch (InterruptedException e) {;}
		}
	}
}
