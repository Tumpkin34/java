package threadTest1;

public class Main {
	public static void main(String[] args) {
		String[] sounds = { "어흥", "야옹", "음메멍멍" };
		Animal[] animals = new Animal[3];
		Thread[] threads = new Thread[3];

		for (int i = 0; i < threads.length; i++) {
			animals[i] = new Animal();
			threads[i] = new Thread(animals[i], sounds[i]);

		}
		for (int i = 0; i < threads.length; i++) {

			threads[i].start();
			if (i != 0) {
				try {
					threads[i].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

//		Runnable bug = new Animal();
//		Runnable mos = new Animal();
//		Runnable mouse = new Animal();
//		Thread bug1 = new Thread(new Animal(), "벌레벌레");
//		Thread mos1 = new Thread(new Animal(), "윙윙");
//		Thread mouse1 = new Thread(new Animal(), "찍찍");
//		bug1.start();
//		mos1.start();
//
//		try {
//			bug1.join();
//			mos1.join();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//		mouse1.start();

	}
}
