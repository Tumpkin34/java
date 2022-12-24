package interfaceTest;

// 인터페이스 : 클래스와 성격이 비슷하지만 상수와 추상클래스만 가지고있고 추상클래스를 고도화 시킨 문법
public interface Pet {//인터페이스의 첫번째 목적 강제성
//	모든 동물이 가지고있는것
	final static int eyes = 2;//
	int nose = 1;//

//	모든 동물이 할 수 있는 것
	public abstract void bang();
	public void giveYourHand();
	public void bite();
	public void sitDown();
	public void waitNow();// wait는 이미 사용중인 메소드이다(나중에 배운다.)
	public void getNose();
	
}
