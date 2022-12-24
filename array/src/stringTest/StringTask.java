package stringTest;

import java.util.Scanner;

public class StringTask {

	public static void main(String[] args) {
//		사용자에게 입력받은 문자열 중 소문자는 모두 대문자로,
//		대문자는 모두 소문자로 변경한다.
		Scanner sc = new Scanner(System.in);
		String yourMessage = sc.nextLine(), newYourMsg = "";
		for (int i = 0; i < yourMessage.length(); i++) {
			if (yourMessage.charAt(i) >= 'A' && yourMessage.charAt(i) <= 'Z') {
				newYourMsg += (char) (yourMessage.charAt(i) + 32);
			} else if (yourMessage.charAt(i) >= 'a' && yourMessage.charAt(i) <= 'z') {
				newYourMsg += (char) (yourMessage.charAt(i) - 32);
			} else {
				newYourMsg += yourMessage.charAt(i);
			}
		}
		System.out.println(newYourMsg);

//		정수를 한글로 변경
//		예) 1024
//			->일공이사
		int num = 1024;
		String sNum = num + "", korean = "", kNum = "공일이삼사오육칠팔구";
		for (int i = 0; i < sNum.length(); i++) {
			korean += kNum.charAt((Integer.parseInt(sNum.charAt(i)+"")));// -48하면된다 아스키코드상으로 1은 49다
		}
		System.out.println(korean);
	}
}
