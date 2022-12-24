package p1;

public class Computer {

	public static void main(String[] args) {
		Game game = new Game() {
			
			@Override
			public void play() {
				System.out.println("안녕하세요 메이플스토리입니다");
			}
			
			@Override
			public void exit() {
				System.out.println("잘가세요 메이플스토리입니다.");
			}
		};
		
		game.play();
		game.exit();
	}

}
