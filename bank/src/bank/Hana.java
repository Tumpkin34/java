package bank;

public class Hana extends Bank{
	@Override
	public int showBalance() {//동석은행은 잔액조회시 잔고가 반을 줄으니까 잔액확인하는 메소드 오버라이딩
		setMoney(getMoney() / 2);//private은 메소드로 접근해서 잔고를 반으로 줄인후 저장
		return super.showBalance();//부모클래스의 잔액확인 메소드는 통장의 잔액을 리턴하기 때문에 오버라이딩된 메소드에서도 잔액을 돌려준다 부모클래스에서 만들어둔showBalance를 통해서
	}
}
