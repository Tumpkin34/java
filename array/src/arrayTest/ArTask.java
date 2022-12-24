package arrayTest;

import java.util.Scanner;

public class ArTask {

	public static void main(String[] args) {

//		int[] arData = null;
//
////		브론즈
////		1~10까지 배열에 담고 출력
//		arData = new int[10];
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = i + 1;
//		}
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}
//
////		10~1까지 중 짝수만 배열에 담고 출력
//		int cnt = 0;
//		for (int i = 0; i < 10; i++) {
//			if ((i + 1) % 2 == 0) {
//				cnt++;
//			}
//		}
//		arData = new int[cnt];
//		for (int i = 0; i < 10; i++) {
//			if ((10 - i) % 2 == 0) {
//				arData[i / 2] = 10 - i;
//			}
//		}
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}
//
////		1~100까지 배열에 담은 후 홀수만 출력
//		arData = new int[100];
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = i + 1;
//		}
//
//		for (int i = 0; i < arData.length; i++) {
//			if(arData[i]%2!=0) {
//				System.out.println(arData[i]);
//			}
//		}

//		실버
//		1~100까지 배열에 담은 후 짝수의 합 출력
//		int[] arData = null;
//		arData = new int[100];
//		int sum = 0;
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = i + 1;
//		}
//		for (int i = 0; i < arData.length; i++) {
//			if (arData[i] % 2 == 0) {
//				sum += arData[i];
//			}
//		}
//		System.out.println(sum);
//
////		A~F까지 배열에 담고 출력
//		char[] arAlpa = new char[6];
//		for (int i = 0; i < arAlpa.length; i++) {
//			arAlpa[i] = (char) ('A' + i);
//		}
//		for (int i = 0; i < arAlpa.length; i++) {
//			System.out.println(arAlpa[i]);
//		}
//
////		A~F까지 중 C제외하고 배열에 담은 후 출력
//		char[] arcData = new char[5];
//		for (int i = 0; i < arcData.length; i++) {
//			if ('A' + i >= 'C') {
//				arcData[i] = (char) ('A' + i + 1);
//			} else {
//				arcData[i] = (char) ('A' + i);
//			}
//		}
//		for (int i = 0; i < arcData.length; i++) {
//			System.out.println(arcData[i]);
//		}

//		골드
//		5개의 정수를 입력받고 배열에 담은 후 최대값과 최소값 출력
//		Scanner sc = new Scanner(System.in);
//		int[] arData = new int[5];
//		String msg = "번째 정수";
//		int max = 0, min = 0;
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(i + 1 + msg);
//			arData[i] = sc.nextInt();
//		}
//		max = arData[0];
//		min = arData[0];
//		for (int i = 0; i < arData.length; i++) {
//			if(max<arData[i]) {max = arData[i];}
//			if(min>arData[i]) {min = arData[i];}
//		}
//		System.out.println("최소"+min);
//		System.out.println("최대"+max);

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
			sum +=arData[i]; 
		}
		avg = sum/arData.length;
		System.out.println(avg);
	}

}
