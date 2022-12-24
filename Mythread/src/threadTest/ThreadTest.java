package threadTest;

public class ThreadTest {

	public static void main(String[] args) {
		Runnable runner = () -> {//Runnable 함수형인터페이스에는 run추상메소드가 있는데 람다식으로 구현
			for (int i = 0; i < 5; i++) {
//				currentThread() : 현재 실행중인 스레드의 인스턴스를 리턴 
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Runnable t1 = new Thread2();//Runnable을 상속받은 Thread2를 업캐스팅하여 객체화
		Thread2 t2 = new Thread2();

		
		
//		Thread thread1 = new Thread(runner, "!");
		Thread thread1 = new Thread(t2, "!");//(재정의된 run이 있는 주소, name에 저장)
		Thread thread2 = new Thread(runner, "?");

		thread1.start();//쓰레드 실행
		thread2.start();//쓰레드 실행

//		쓰레드의 우선순위를 정해줄 수 있다.
//		join() : 사용한 객체의 쓰레드가 모두 종료되어야 다른 쓰레드가 실행된다.
//			이미 start()된 쓰레드는 영향을 받지 않는다.
//			만약 나중에 실행하고자 하는 쓰레드가 있다면, join() 다음에 start()를 실행해야 한다.
		try {
//			밑에 두 쓰레드가 끝나야 다음 코드 실행
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		main쓰레드의 우선순위가 높다
		System.out.println("main 쓰레드 종료");

//		Thread상속받은걸로 멀티쓰레드 구현
//		Thread1 t1 = new Thread1("★");//Thread1 클래스 객체화
//		Thread1 t2 = new Thread1("♥");
//
////		start메소드로 스케줄링 한다. 운영체제한테 멀티쓰레드라는걸 알려준다.
//		t1.start();//t1의 자원을 가지고 Thread1에서 재정의한 run을 사용한다.
////		밑에 쓰레드와 같이 실행된다.
//		t2.start();
//
////		t1.run();
////		t2.run();
	}

}
