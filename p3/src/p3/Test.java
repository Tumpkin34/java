package p3;

import java.util.Scanner;

public class Test implements Runnable {
	Thread previousThread = null;

	public void turnoff() {
		Thread turnoff = new Thread(this);
		if (previousThread != null) {
			previousThread.interrupt();
		}
		previousThread = turnoff;
		turnoff.start();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("타이머리셋");
			return;
		}
		System.out.println("선풍기가 종료됩니다.");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Test test = new Test();
		int choice = 0;
		while (true) {
			choice = sc.nextInt();
			if (choice == 1) {
				test.turnoff();
			}
		}
//		Thread turnoff = new Thread(runnable);
	}
}
