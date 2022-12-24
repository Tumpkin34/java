package threadTest;

public class ThreadTest {
	public static void main(String[] args) {
//		Runnable 함수형 인터페이스 run이 구현안된 상태로 있다.
		Runnable runner = () -> {// 람다식으로 구현
			for (int i = 0; i < 5; i++) {
//				currentThread()접근한 객체의. name을 출력 
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					;
				}
			}
		};

		Runnable t1 = new Thread2();
		Thread2 t2 = new Thread2();

		// Runnable 객체를 사용할 떄에는 직접 스레드 객체를 만들어야 한다.

		//start를 쓰기 위해 Thread객체로 만들어줌
//		Thread thread1 = new Thread(t1, "!");
//		Thread thread2 = new Thread(t2, "?");
		
//		위에서 람다식으로 재정의한 Runnable객체 주소 전달
		Thread thread1 = new Thread(runner, "!");
//		물론 밑에처럼 람다로 구현도 가능(주소가 되니까)
		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					;
				}
			}
		}, "?");

		//멀티쓰레드 실행
		thread1.start();
		thread2.start();

//		join() : 사용한 객체의 쓰레드가 모두 종료되어야 다른 쓰레드가 실행된다.
//				 이미 start()된 쓰레드는 영향을 받지 않는다.
//				 만약 나중에 실행하고자 하는 쓰레드가 있다면, join() 다음에 start()를 실행해야 한다.
		try {
//			밑 두개의 쓰레드가 종료되야 다음 코드 실행
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			;
		}

//		main쓰레드의 우선순위가 높기 때문에 밑에 코드가 먼저 출력되지만 위의 join으로 해당 쓰레드가 종료된후 출력
		System.out.println("main 쓰레드 종료");

//		Thread1 t1 = new Thread1("★");//data에 문자열을 넘겨주고 Thread안에 data출력하는 메소드 있음
//		Thread1 t2 = new Thread1("♥");
//		
//		t1.start();//Thread를 상속받았기에 바로 사용 가능
//		t2.start();

//		t1.run();//운영체제가 멀티쓰레드라는걸 모르기때문에 단일로 실행
//		t2.run();
	}
}
