package lambdaTask;

//함수형 인터페이스
@FunctionalInterface
public interface Calc {
//	두 정수를 전달받은 후 더하거나, 빼서 리턴한다.
	public int calc(int number1, int number2);//두정수를 전달받는 후 int로 리턴하는 추상메소드 선언
}
