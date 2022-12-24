package lambdaTask;

import java.util.Scanner;

public class MyMath {
	public static Calc calculator(String oper) {// -또는 +를 받음
		Calc c = null;//아직 어떤 클래스주소를 저장할지 모르기 때문에 null
		switch (oper) {
		case "+": //받아온 문자열이 +면 실행
			c = (n1, n2) -> n1 + n2;//Calc클래스에 calc메소드를 +로 재정의 한 주소값을 객체화
			break;
		case "-": //받아온 문자열이 -면 실행
			c = (n1, n2) -> n1 - n2;//Calc클래스에 calc메소드를 -로 재정의 한 주소값을 객체화
		}
		return c; // -,+냐에 따라 재정의한 필드의 주소를 리턴해줌
	}

	public static void main(String[] args) {
		OperCheck operCheck = (ex) -> {// 람다식(익명메소드로)재정의후 해당필드의 주소 operCheck에 저장
//			전체 수식에서 연산자만 골라서 문자열에 담고
			String opers = "";//연산자만 빼서 저장할 변수
			for (int j = 1; j < ex.length(); j++) {//받아온 문자열의 길이만큼 반복하며, 1부터 시작하기 때문에 계산식의 앞자리는 숫자아니면 첫정수의 부호 이기때문에 건너뛰어서 첫번쨰 정수가 음수일 경우 이렇게 해결함
				if (ex.charAt(j) == '-') {// - 연산자를 찾아냄
					opers += '-';//찾아낸 - 연산자를 연결하여 저장
				} else if (ex.charAt(j) == '+') {// + 연산자를 찾아냄
					opers += '+';//찾아낸 + 연산자를 연결하여 저장
				}
			}
//			문자열 배열로 리턴
			return opers.split("");// 빈문자열("")을 기준으로 나누면 연산자를 따로따로 나눌 수 있다.
		};

		Scanner sc = new Scanner(System.in);
		String math = ""; //계산식을 받을 변수
		int result = 0, version = 0;//처음부터 숫자를 하나씩 연산해 나갈거기 때문에 result 선언, 이따 이번메소드는 -버전인지 +버전인지 알려주기위해 version 선언
		math = sc.nextLine();//그 변수에 계산식 입력해 초기화

		String[] arOper = operCheck.checkOper(math);// operCheck안에 위에서 재정의된 메소드를 이용 계산식을 주고 계산식에 사용된 연산자를 뽑아온 후 배열에 저장 
		String[] arStringNumber = math.split(" \\+ | \\- ");// 이번엔 계산식에서 숫자만 뽑아온다 *이상하게 (" - ")는 작동을 하는데 (" + ")는 작동을 안한다.
		int[] arNumber = new int[arStringNumber.length];// 뽑아온 숫자를 정수형으로 바꿔 배열에 저장할 예정이다.
		
		for (int i = 0; i < arNumber.length; i++) {// 숫자 문자열이 저장된 문자열 배열 만큼 반복하며 
			arNumber[i] = Integer.parseInt(arStringNumber[i]);// 일일이 int배열에 담아준다.
		}
		Calc temp2 = calculator("+");//result에 하나하나 연산해 나갈거기 때문에 처음은 +메소드로 재정의된 주소부터 실행
		for (int i = 0; i < arNumber.length; i++) {//숫자가 담긴 배열의 길이 만큼 반복
			result = temp2.calc(result, arNumber[i]);// result에 하나씩 연산해 나간다.
			if (version >= arOper.length)//연산이 모두 끝나고 밑에 코드가 실행되면 오류가 나니까 막아줌
				break;
			temp2 = calculator(arOper[version]);//연산이 끝나고 다음 저장된 연산자를 통해 -,+메소드 재정의된 주소로 바꿈
			version++;//계산이 끝날때 마다 다음연산자의 배열에 다가가기 위해 version증가
		}
		System.out.println(result);//위에서 계산된 결과를 출력
	}
}
