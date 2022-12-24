package lambdaTest;

//함수형 인터페이스
@FunctionalInterface // 1개의 추상메소드만 가질수 있다.
public interface LambdaInter {
	boolean checkMultipleOf10(int number);//정수를 받아 10의 배수인지 검사해서 10의 배수라면 true를 리턴할 예정인가보다 기능은 아직 구현x
}
