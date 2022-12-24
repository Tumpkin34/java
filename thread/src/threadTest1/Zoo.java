package threadTest1;

public class Zoo {
	public static void main(String[] args) {
		String[] sounds = {"어흥", "야옹", "음메멈멍"};//소리담은 배열
		Animal[] animals = new Animal[sounds.length];//동물 3마리
		Thread[] threads = new Thread[sounds.length];//동물 3마리 스레드로 만들어줄 배열
		
		for (int i = 0; i < threads.length; i++) {
			animals[i] = new Animal();//동물객체화 각각의 주소담음
			threads[i] = new Thread(animals[i], sounds[i]);//각스레드로 만듬 new Thread(Runnable타입, Name)
		}
		
		for (int i = 0; i < threads.length; i++) {
			System.out.println(i);
			threads[i].start();//스래드 실행
			if(i != 0) {//thread[1]부터 join thread[2]도 join되는데 사실 의미 없음
				try {threads[i].join();} catch (InterruptedException e) {;}
			}
		}
		//thread[1]이 끝나고 (thread[0]도 끝나는 시간같음) thread[2]실행 
		
	}
}













