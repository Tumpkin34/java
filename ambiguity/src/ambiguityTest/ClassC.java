package ambiguityTest;

public class ClassC implements InterA, InterB {//InterA와 InterB를 동시에 상속받으면 부모필드의 동일한 필드가 있다면 모호성이 발생한다.
//	그 모호성 해결 방법 자식클래스에서 모호한 필드를 재정의한다.
	
	@Override
	public void printData() {
		InterA.super.printData();//InterA의 필드를 사용하겠다.
	}
}
