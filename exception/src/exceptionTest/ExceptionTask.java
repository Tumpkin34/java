package exceptionTest;

import java.util.Scanner;

public class ExceptionTask {

	public static void main(String[] args) {
//		5개의 정수만 입력받기
//		- 무한 입력 상태로 구현
//		- q 입력 시 나가기
//		- 5개의 정수는 배열에 담기
//		- if문은 딱 한 번만 사용하기
		Scanner sc = new Scanner(System.in);
		int[] arNumber = new int[5];//정수 5개 입력 받을 예정
		int number = 0, index = 0;//정수로 바꿔담을 변수, 배열의 인덱스로 사용할 변수
		String temp = "", msg = "정수 5개를 입력하세요";

		System.out.println(msg);
		while (true) {// 무한반복
			try {//시도한다. 밑에 코드를
				temp = sc.next();//문자열 입력 
				number = Integer.parseInt(temp);//문자열을 입력 했을때 정수로 바꿔주는 과정에서 숫자모양의 문자열이 아닌경우 오류 발생
				arNumber[index] = number;//정수 배열에 담는과정
				index++;//배열에 숫자를 담았다는 거니까 인덱스번호 증가
			} catch (ArrayIndexOutOfBoundsException a) {//인덱스 길이를 넘어 사용할 경우 발생하는 오류 잡아줌
				System.out.println("배열에는 5개의 정수만 담깁니다");
			} catch (Exception e) {//모든 오류 잡음 위에서 정수로 형변환 하는 과정중에 q면 종료 q제외 다른 문자열이면 무시
				if (temp.equals("q")) {//오류가 발생시킨 문자열이 q라면 무한반복 종료 
					System.out.println("종료합니다");
					break;// 종료
				}
			}
		}

		for (int i = 0; i < arNumber.length; i++) {//배열의 담긴 정수들 출력
			System.out.println(i + 1 + "번 " + arNumber[i]);
		}
	}

}
