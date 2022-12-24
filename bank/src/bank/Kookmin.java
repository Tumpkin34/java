package bank;

public class Kookmin extends Bank{
	@Override
	public void withdraw(int money) {//국민은행은 출금시 통장에서 출금액의 50% 수수료를 통장에서 빼가기 떄문에 오버라이딩 
		money *= 1.5;//출금시 통장에 출금금액에 수수료를 같이 빼기위해 50%를 더해준다. 
		super.withdraw(money);//부모클래스의 메소드를 통해 1.5배한 출금액을 통장에서 빼준다.
	}
}
