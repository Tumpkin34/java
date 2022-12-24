package anonymousTest;

public class Computer {
	public static void main(String[] args) {
//		인터페이스의 구현되지 않은 메소드를 메모리에 올리기 위해선 무조건 구현을 해야한다.
//		따라서, 해당 인터페이스를 객체화 하려고 하면 밑에와 같이 구현을 해야 메모리에 올라간다. 
		Game game = new Game() {// 이 익명클래스가 Game을 지정받은 것이다
//			값 안의 내용
			@Override
			public void play() {//추상메소드를 바디({,})를 닮으로써 구현
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void exit() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
