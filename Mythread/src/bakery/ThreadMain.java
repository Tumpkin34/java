package bakery;

import javax.swing.JOptionPane;

public class ThreadMain {

	public static void main(String[] args) {
		Thread t = new Thread(new ThreadTest());
		String[] btns = {"계속하기","나가기"};
		t.start();//스레드 실행
		
//		자바에서 제공하는 GUI인데 실무에서 사용하지 않아서 외울 필요없음
		if(JOptionPane.showOptionDialog(null, "", "종료테스트", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, btns, t) ==1) {
			t.interrupt();//스레드 종료
		}
	}

}
