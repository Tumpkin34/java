package threadTest2;

import java.util.Scanner;

public class ThreadMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] eng = { "third", "first", "second" };
		int choice = 0;
		ThreadTask task = new ThreadTask();
//		task.
		Runnable run = () -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(Thread.currentThread().getName() + " ");
		};
		for (int i = 0; i < eng.length; i++) {

		}
		Thread thread2 = new Thread(run, "first");
		Thread thread3 = new Thread(run, "second");
		Thread thread1 = new Thread(run, "third");
		Thread[] threads = { thread2, thread3, thread1 };

//		우선 Thread1,2,3순서대로 실행 시키고 .join으로 
		
		for (int i = 0; i < 3; i++) {
			choice = sc.nextInt();
			threads[choice - 1].start();
			try {
				threads[choice - 1].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
