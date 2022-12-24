package abstractTest;

//추상 클래스
public abstract class Electronics {//모든 전자제품에 있는 on,off기능 하지만 제품에 따라 무조건 재정의 해줘야한다.추상클래스이기 떄문에 abstract붙여줌
	abstract public void on();//바디({})가 없기 때문에 추상메소드, 추상 메소드 자식에서 재정의할 예정
	abstract public void off();
}
