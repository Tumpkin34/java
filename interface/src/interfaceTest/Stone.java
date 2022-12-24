package interfaceTest;

public class Stone extends PetAdapter {//인터페이스의 메소드를 무조건 재정의 해야하는데 하다 보니 재정의 하고 싶지않는 메소드들이 생긴다 그래서 강제성을 없애주는 adapter를 사용한다.

//	재정의하고 싶은 것만 골라서 해도 강제성이 사라졌기 때문에 오류가 나지 않는다.
	@Override
	public void sitDown() {
		System.out.println("앉는다.");
	}

	@Override
	public void waitNow() {
		System.out.println("기다린다.");
	}

}
