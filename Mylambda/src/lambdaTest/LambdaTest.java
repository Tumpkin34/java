package lambdaTest;

public class LambdaTest {

	public static void main(String[] args) {
//		                           매개변수를 받고 받은 변수 %10 ==0 이라면 true를 리턴하겠다
		LambdaInter lambdaInter1 = (number) -> number % 10 == 0;// (number) -> number % 10 == 0;이거 자체가 주소값
//		(number) -> number % 10 == 0; 밑에 주석의 코드와 동일하다 
//		new LambdaInter() {
//
//			@Override
//			public boolean checkMultipleOf10(int number) {
//				// TODO Auto-generated method stub
//				return number % 10 == 0;
//			}
//		};

		boolean result = lambdaInter1.checkMultipleOf10(10);//위에서 익명클래스로 checkMultipleOf10을 구현하고 구현한 필드의 주소를 사용하고있다.
		System.out.println(result);

		LambdaInter lambdaInter3 = (n) -> {//이렇게 쓰는 경우는 잘 없다 람다식 2줄 이상 문법
			System.out.println("10의 배수 검사");
			return n % 10 == 0;// 리턴값
		};
		boolean result2 = lambdaInter3.checkMultipleOf10(20);//위에 두줄로 재정의한 메소드가 실행된다.
		System.out.println(result2);
	}

}
