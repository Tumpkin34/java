package exceptionTest;

import java.util.Scanner;

public class ExceptionTaskT {

	public static void main(String[] args) {
//		5개의 정수만 입력받기
//		- 무한 입력 상태로 구현
//		- q 입력 시 나가기
//		- 5개의 정수는 배열에 담기
//		- if문은 딱 한 번만 사용하기
		
		Scanner sc = new Scanner(System.in);
		int[] arData = new int[5];//입력 받은 5개의 정수 저장할 배열
		String msg = "번째 정수 : ", temp = null;//temp = 입력할 변수 초기화
		int i = 0;//인덱스번호로 사용될 변수

		while (true) {//무한 반복
			System.out.print(++i + msg);//사용자가는 1부터 숫자를 세니까 i++
			temp = sc.next();//정수던 q던 입력
			if (temp.equals("q")) {//q가 입력 됐다면 실행
				break;// 종료
			}

			try {//오류가 날 수 있는 문장 실행 예상오류 인덱스번호가 넘음, 정수로 형변환할 수 없는 문자가 들어옴
				arData[i - 1] = Integer.parseInt(temp);//arData[i -1]에 (-1은 위에 출력하려고 1을 증가 시켰기 때문에) 입력한 문자를 정수로 형변환해 저장 

			} catch (NumberFormatException e) {//정수도 q도아닌 문자를 입력했을 때 실행
				System.out.println("입력하기 전에 생각이란 걸 해봤나요? 제대로 입력하세요.");
				i--;//위에서 메세지로 출력할 때 i를 증가 시켰으니까 아무것도 못한 이 곳에 들어왔다면 다시 i감소
			} catch (ArrayIndexOutOfBoundsException e) {//숫자 5개를 이미 다입력하고 6번째 숫자를 입력했을때
				System.out.println("5개만 입력가능합니다. ");
				//배열에 저장된 요소를 출력하고 종료
				for (int j = 0; j < arData.length; j++) {//
					System.out.print(arData[j] + " ");
				}
				break;
			} catch (Exception e) {//위에서 예상 못한 모든 오류 잡는다.
				System.out.println("?");
				i--;
			}
		}
	}

}
