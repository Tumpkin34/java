package interfaceTest;

public class Dog implements Pet{//인터페이스가 지정된 클래스는 무조건 재정의 해야한다.

	@Override
	public void bang() {
		System.out.println("드러눕는다.");
	}

	@Override
	public void giveYourHand() {
		System.out.println("손을 준다.");
	}

	@Override
	public void bite() {
		System.out.println("문다.");
	}

	@Override
	public void sitDown() {
		System.out.println("앉는다.");
	}

	@Override
	public void waitNow() {
		System.out.println("기다린다.");
	}

	@Override
	public void getNose() {
		System.out.println("코를 손가락에 쑤셔 넣는다.");
	}

}
