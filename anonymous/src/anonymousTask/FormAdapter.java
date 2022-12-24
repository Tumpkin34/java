package anonymousTask;

// Form의 강제성 소멸
public class FormAdapter implements Form {//잠실점은 무료나눔 행사중이여서 sell을 구현할 필요가 없기에 구현되지 않은 sell의 강제성을 adapter를 통애 없앰

//	강제성 없애는 중(밑에 두개 메소드에서 구현을 했기 때문에 이 Adapter를 상속받은 클래스는 강제성이 없어진다.)
	@Override
	public String[] getMenu() {
		return null;
	}

	@Override
	public void sell(String order) {

	}

}
