package threadTest2;

import java.util.Scanner;

public class ThreadMain {
	public static void main(String[] args) {
		int[] arInput = new int[3];
		Thread[] arThread = new Thread[arInput.length];//스레드 3개니까 3칸 배열
		ThreadTask threadTask = new ThreadTask();
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < arThread.length; i++) {
			arThread[i] = new Thread(threadTask);//threadTask에 재정의된 run을 사용하겠다.
		}
		
		System.out.print("입력 : ");
		for (int i = 0; i < arThread.length; i++) {
			arInput[i] = sc.nextInt();//입력후 저장
//			입력한 순서대로 쓰레드의 이름으로 설정한다.
			arThread[i].setName(String.valueOf(arInput[i]));//입력한 값을 위에 run재정의된 Runnable 타입을 사용하는 Thread의 name에 저장
//			arThread[i].setName(arInput[i]+"");
		}
		
		for (int i = 0; i < arThread.length; i++) {
			arThread[i].start();//Thread를 start를 통해 운영체제에게 멀티 쓰레드라고 알림 start가 ThreadTask의 run 실행
			try {arThread[i].join();} catch (InterruptedException e) {;}//arThread[i]가 끝나면 다음 쓰레드 실행
		}
		
	}
}













