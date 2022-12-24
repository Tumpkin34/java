package anonymousTask;

public interface Form {// 인터페이스(틀) 양식 틀

	// 추상메소드 지정받은 클래스는 반드시 재정의 해야한다.
	public String[] getMenu();

	public void sell(String order);
}