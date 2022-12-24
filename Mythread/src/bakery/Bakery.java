package bakery;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Bakery {
	public static void main(String[] args) {
		BreadMaker breadMaker = new BreadMaker();//BreadMaker에 run 재정의 해둠
		Thread maker = new Thread(breadMaker);//재정의한 BreadMaker 넘겨줌
		BreadPlate breadPlate = BreadPlate.getInstance();//싱글톤 패턴으로 객체화
		String[] btns = { "빵 먹기", "나가기" };//버튼 구현재료
		int choice = 0;

		ImageIcon icon = new ImageIcon("src/img/bread2.gif");//이미지 경로

		maker.start();//빵 만들기 스레드 시작

//		빵먹기
		while (true) {
			choice = JOptionPane.showOptionDialog(null, "", "빵집", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					icon, btns, null);
			if (choice == 0) {
				breadPlate.eatBread();//빵먹기
			} else {
//				System.exit(0);//모든 스레드 종료
				maker.interrupt();//강제로 오류를 발생시킴 catch로 오류 잡아줌
				break;
			}
		}
	}
}
