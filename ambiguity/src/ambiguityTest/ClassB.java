package ambiguityTest;

public class ClassB extends ClassA implements InterA{//부모클래스의 메소드가 더 우선순위를 가지고있다.
//	따라서 모호성이 발생하는 필드는 알아서 부모의 필드를 사용한다.
	
//	하지만 밑에 처럼 무슨 필드를 쓸지 지정해줄 수 있다.
	@Override
	public void printData() {
		// TODO Auto-generated method stub
		InterA.super.printData();// InterA.의 필드인 printData를 사용하겠다
	}

}
