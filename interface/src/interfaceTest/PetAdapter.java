package interfaceTest;

public abstract class PetAdapter implements Pet {//인터페이스의 강제성을 없애기 위해 여기서 인터페이스를 지정받아 재정의 하여 강제성을 없애준다.

	@Override
	public void bang() {;}

	@Override
	public void giveYourHand() {;}

	@Override
	public void bite() {;}

	@Override
	public void sitDown() {;}

	@Override
	public void waitNow() {;}

	@Override
	public void getNose() {;}

}
