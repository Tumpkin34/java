package methodTest;

import java.util.Scanner;

public class P1 {
//	5개의 정수를 입력받은 후 원하는 번째 값을 구해주는 메소드
	int getValue(int[] nums, int wantedNumber) {
		return nums[wantedNumber - 1];
	}

//	한글을 정수로 바꿔주는 메소드 (indexof 사용)
//	예) 일공이사 = 1024
	int changeToInteger(String hangle) {
		String hangleOriginal = "공일이삼사오육칠팔구", result = "";
		for (int i = 0; i < hangle.length(); i++) {
			result += hangleOriginal.indexOf(hangle.charAt(i));
		}
		return Integer.parseInt(result);
	}

//	5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드
	int[] getMaxAndMin(int[] nums) {
		int[] results = new int[2];
		results[0] = nums[0];// 최대값
		results[1] = nums[0];// 최소값

		for (int i = 1; i < nums.length; i++) {
			if (results[0] < nums[i]) {
				results[0] = nums[i];
			}
			if (results[1] > nums[i]) {
				results[1] = nums[i];
			}
		}

		return results;
	}

//	5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드(void로 하되, 출력 없이 사용하는 부분에 결과를 전달한다)전역변수 안됨
//	매개변수는 2개 전달해야 한다.
//	예) getMaxAndMin();
//		여기서부터 최대값, 최소값 사용 가능
	void getMaxAndMin(int[] nums, int[] results) {
		results[0] = nums[0];// 최대값
		results[1] = nums[0];// 최소값

		for (int i = 1; i < nums.length; i++) {
			if (results[0] < nums[i]) {
				results[0] = nums[i];
			}
			if (results[1] > nums[i]) {
				results[1] = nums[i];
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		P1 p = new P1();

//		한글을 정수로 바꿔주는 메소드 (indexof 사용)
//		예) 일공이사 = 1024
		System.out.println(p.changeToInteger("이공이이"));

//		5개의 정수를 입력받은 후 원하는 번째 값을 구해주는 메소드
		int[] arNum = new int[5];
		String msg = "번 째 정수 : ", searchMsg = "몇번째 정수를 찾을까요?";
		for (int i = 0; i < arNum.length; i++) {
			System.out.print(i + 1 + msg);
			arNum[i] = sc.nextInt();
		}
		System.out.println(searchMsg);
		System.out.println(p.getValue(arNum, sc.nextInt()));

//		5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드
		int[] result = p.getMaxAndMin(arNum);
		System.out.println("최대값 : " + result[0]);
		System.out.println("최소값 : " + result[1]);

//		5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드(void로 하되, 출력 없이 사용하는 부분에 결과를 전달한다)전역변수 안됨
//		매개변수는 2개 전달해야 한다.

//		예) getMaxAndMin();
//			여기서부터 최대값, 최소값 사용 가능
		int[] results = new int[2];
		p.getMaxAndMin(arNum, results);
		System.out.println("최대값 : " + results[0]);
		System.out.println("최소값 : " + results[1]);

	}

}
