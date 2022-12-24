package synchronizedTest;

public class ATM implements Runnable{
	
	public int money;
	
	public ATM() {
		this(10000);
	}
	
	public ATM(int money) {
		super();
		this.money = money;
	}

	@Override
	public void run() {//run으로 매개변수를 받을 수 없으니까 밑에 withdraw를 통해 돈을 뽑아준다.
		for (int i = 0; i < 5; i++) {
			withdraw(1000);//1000원씩
			try {Thread.sleep(1000);} catch (InterruptedException e) {;}
		}
	}
	
	public synchronized void withdraw(int money) {//이메소드는 한번에 하나의 스레드만 접근가능
//		mutex : 동기화를 걸어줄 자원 객체
//		synchronized (this) {//이 안의 코드는 한번에 하나의 스레드만 접근가능
			this.money -= money;
//		}
//		위의 run을 통해 접근했기에 접근한 주소의 name
		System.out.println(Thread.currentThread().getName() + "이(가) " + money + "원 출금");
		System.out.println("현재 잔액 : " + this.money + "원");
	}
}








