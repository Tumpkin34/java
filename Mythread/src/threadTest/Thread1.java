package threadTest;

public class Thread1 extends Thread {//멀티 쓰레드를 구현하기위해 Thread상속

	public String data;//★이던 ♥던 받아올 변수
	
	public Thread1() {;}//기본생성자
	
	public Thread1(String data) {//초기화 생성자 data에 넣어줄 값 가져올 예정
		super();
		this.data = data;
	}

	@Override
	public void run() {//run재정의
//		반복을 돌겠다 1초 간격으로
		for (int i = 0; i < 10; i++) {
			System.out.println(data);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
