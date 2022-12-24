package synchronizedTest;

public class CU {
	public static void main(String[] args) {
		ATM atm = new ATM();
		
//		atm의 run에 접근 예정
		Thread mom = new Thread(atm, "엄마");
		Thread son = new Thread(atm, "아들");
		
//		멀티스레드 실행
		mom.start();
		son.start();
	}
}
