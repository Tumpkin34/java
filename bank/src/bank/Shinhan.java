package bank;

public class Shinhan extends Bank{
	@Override
	public void deposit(int money) {// 신한은행은 입금시 입금액에 수수료가 50%를 때고 입금하기 때문에 오버라이딩
		money *= 0.5;// 외부에서 받아온 입금액에 50%를 감액후 money에 저장
		super.deposit(money);//저장된 money를 부모클래스의 메소드로 전역변수에 담아준다. 
	}
}
