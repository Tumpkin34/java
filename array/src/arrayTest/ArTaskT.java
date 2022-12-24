package arrayTest;

import java.util.Scanner;

public class ArTaskT {

	public static void main(String[] args) {

//		브론즈
//		1~10까지 배열에 담고 출력
//		int[] arData = new int[10];
//
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = i + 1;
//		}
//
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}

//		10~1까지 중 짝수만 배열에 담고 출력
//		int[] arData = new int[5];
//
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = (5 - i) * 2;
//		}
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}

//		1~100까지 배열에 담은 후 홀수만 출력		
//		int[] arData = new int[100];
//
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = i + 1;
//		}
//
//		for (int i = 0; i < arData.length; i++) {
//			if (arData[i] % 2 == 0) {
//				continue;
//			}
//			System.out.println(arData[i]);
//		}

//		실버
//		1~100까지 배열에 담은 후 짝수의 합 출력
//		int[] arData = new int[100];
//		int total = 0;
//		
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = i+1;
//		}
//		
//		for (int i = 0; i < arData.length; i++) {
//			if(arData[i]%2==0) {
//				total += arData[i];
//			}
//		}
//		System.out.println(total);

//		A~F까지 배열에 담고 출력
//		char[] arData = new char[6];
//		
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = (char)(65 +i);
//		}
//		
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}

//		A~F까지 중 C제외하고 배열에 담은 후 출력
//		char[] arData = new char[5];
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = (char) (i > 1 ? 66 + i : 65 + i);
//		}
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}

//		골드
//		5개의 정수를 입력받고 배열에 담은 후 최대값과 최소값 출력
//		int[] arData = new int[5];
//		Scanner sc = new Scanner(System.in);
//		String msg = "5개의 정수를 입력하세요.";
//		int max = 0, min = 0;
//
//		System.out.println(msg);
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = sc.nextInt();
//		}
//
//		for (int i = 0; i < arData.length; i++) {
//
//		}
//
//		max = arData[0];
//		min = arData[1];
//		
//		for (int i = 0; i < arData.length; i++) {
//			if(max < arData[i]) {
//				max = arData[i];
//			}
//			if(min > arData[i]) {
//				min = arData[i];
//			}
//		}
//		
//		System.out.println("최대값 : " + max);
//		System.out.println("최소값 : " + min);
//		
//		다이아
//		사용자가 입력할 정수의 개수만큼 배열을 만든 후 정수를 입력받고 평균 구하기
		int[] arData = null;
		Scanner sc = new Scanner(System.in);
		String countingMsg = "정수 개수 : ", msg = "번째 정수 : ";
		int total = 0;
		double avg = 0.0;

		System.out.print(countingMsg);
		arData = new int[sc.nextInt()];

		for (int i = 0; i < arData.length; i++) {
			System.out.print(i + 1 + msg);
			arData[i] = sc.nextInt();
		}

		for (int i = 0; i < arData.length; i++) {
			total += arData[i];
		}

		avg = (double) total / arData.length;
		avg = Double.parseDouble(String.format("%.2f", avg));
		System.out.println(avg);
	}

}
