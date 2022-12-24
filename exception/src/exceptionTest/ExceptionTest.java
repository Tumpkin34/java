package exceptionTest;

public class ExceptionTest {
	public static void main(String[] args) {
		try {
			System.out.println(10/0);//수학적으로 0으로는 나눌 수 없기에 오류나 발생한다.
		}
//		catch(ArithmeticException e) {//0으로 나눌 수 없을 때 나오는 오류가 나면 실행한다.
//			System.out.println("0으로는 나눌 수 없습니다");
//		} 
		catch(Exception e) {//위에서 오류를 일일이 잡아준게 아니어서 혹시 못잡은 오류가 있을 수도 있어서 모든 오류의 부모클래스를 잡아준다.
			System.out.println("알 수 없는 오류");
			System.out.println(e);//오류 메세지 출력
			e.getMessage();// 오류메세지 출력
			e.printStackTrace();//오류 경로 출력
		}
		System.out.println("반드시 실행되어야 하는 문장");
	}
}
