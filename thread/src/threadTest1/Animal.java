package threadTest1;

public class Animal implements Runnable{//함수형 인터페이스 상속
	@Override
	public void run() {//run재정의 
		for (int i = 0; i < 10; i++) {
//			접근한 객체의 Name출력
			System.out.println(Thread.currentThread().getName());
			try {Thread.sleep(300);} catch (InterruptedException e) {;}
		}
	}
}
