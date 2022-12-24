package stringTest;

import java.util.Scanner;

public class StringTaskT {

	public static void main(String[] args) {
//		사용자에게 입력받은 문자열 중 소문자는 모두 대문자로,
//		대문자는 모두 소문자로 변경한다.
//		Scanner sc = new Scanner(System.in);
//		String str = null, result = "", msg = "문자열 : "; // null은 대입을, 빈문자열은 연결을 하기 위해 사용한다
//
//		System.out.println(msg);
//		str = sc.nextLine();
//
//		for (int i = 0; i < str.length(); i++) {
//			char c = str.charAt(i);
//
//			if (c >= 65 && c <= 90) {// 대문자
//				result += (char) (c + 32);
////				result = result + (char)(c + 32)
//			} else if (c >= 96 && c <= 122) {// 소문자
//				result += (char) (c - 32);
//			} else {
//				result += c;
//			}
//		}
//
//		System.out.println(result);

//		정수를 한글로 변경
//		예) 1024
//			->일공이사
		
//		int number = 0;
		Scanner sc = new Scanner(System.in);
		String msg = "정수 : ", hangle = "공일이삼사오육칠팔구", result = "", number = null;

		System.out.print(msg);
		number = sc.next();

		for (int i = 0; i < number.length(); i++) {
			result += hangle.charAt(number.charAt(i) - 48);
		}
		System.out.println(result);

//		while (number != 0) {
//			result = hangle.charAt(number % 10) + result;
//			number /= 10;
//		}
//		System.out.println(result);

	}

}
