package lambdaTest;

public class PrintNameTest {
//	외부에서 람다식으로 구현한 값을 name으로 전달받기
	public static void printFullName(PrintName name) {
		System.out.println(name.chain("황", "지수"));
		
//		String fullName = name.chain("황", "지수");
//		System.out.println(fullName);
	}

	public static void main(String[] args) {
//		매개변수 2개를 설정하고, 두 문자열을 연결하도록 구현한다.
		printFullName((fl,ml) -> fl + ml);//람다식(익명메소드)으로 재정의 fl,ml을 매개변수로 두개 연결한 값을 리턴, 필드를 가지는 주소 
		
//		내가한 방식
//		PrintName pn = (familyName, midleName) -> familyName + midleName;
//		printFullName(pn);
	}
}
