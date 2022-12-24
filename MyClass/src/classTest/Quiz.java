package classTest;

public class Quiz {

//	문제, 정답, 먹이개수, 잭팟문제인지 여부를 결정할 전역변수 선언
	String question;
	String answer;
	int feedCount;
	boolean jackPot;

//	기본 생성자
	public Quiz() {;}// ; = 일부로 비워뒀다는걸 표시

//	초기화 생성자
	public Quiz(String question, String answer, int feedCount, boolean jackPot) {//문제와 정답, 보상, 잭팟 여부를 받아온다. 
//		받아온 정보들을 전역변수에 넣는다. 
		this.question = question;
		this.answer = answer;
		this.feedCount = feedCount;
		this.jackPot = jackPot;
	}

}
