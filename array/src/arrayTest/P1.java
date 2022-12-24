package arrayTest;

import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {
//		다이아
//		사용자가 입력할 정수의 개수만큼 배열을 만든 후 정수를 입력받고 평균 구하기
		int[] arData = null;
		Scanner sc = new Scanner(System.in);
		int index = sc.nextInt();
		arData = new int[index];
		int sum = 0;
		int avg = 0;
		for (int i = 0; i < arData.length; i++) {
			arData[i] = sc.nextInt();
		}
		for (int i = 0; i < arData.length; i++) {
			sum += arData[i];
		}
		avg = sum / arData.length;
		System.out.println(avg);
	}
}
