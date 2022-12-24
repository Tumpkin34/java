package ambiguityTest;

public interface InterA {//인터페이스
	default void printData() {//생략된 abstract를 없애기 위해 default, default를 사용하면 인터페이스에서 일반메소드를 사용할 수 있다.
		System.out.println("InterA");
	}
}
