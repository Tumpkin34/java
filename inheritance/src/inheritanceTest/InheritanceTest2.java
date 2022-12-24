package inheritanceTest;

class Human {//부모클래스로 사용할 Human클래스
	//인간이라면 하는 행동 메소드로 구현 하지만 Monkey에도 쓸거기 때문에 원숭이도 하는 행동
	void eat() {
		System.out.println("먹기");
	}

	void sleep() {
		System.out.println("잠자기");
	}

	void walk() {
		System.out.println("두 발로 걷기");
	}
}

class Monkey extends Human {//Human을 상속받은 Monkey클래스
	void 이잡아라() {// 자식클래스인 원숭이만 하는 행동 구현
		System.out.println("이잡기");
	}

	@Override//어노테이션 : 가독성
	void walk() {// 원숭이도 두 발로 걷긴하지만 네 발로도 걷기 때문에 오버라이딩으로 재정의 
//		부모의 코드를 그대로 사용하고자 할 때
		super.walk();// 부모의 walk를 가져옴
		System.out.println("네 발로 걷기");// 자식클래스에서 새로생긴 걷는 방법
	}
}

public class InheritanceTest2 {

	public static void main(String[] args) {
		Human hu = new Human();// 부모클래스 객체화
		Monkey kingkong = new Monkey();// 자식클래스 객체화
		kingkong.walk();//원숭이가 걷는 두 발, 네 발 보행 출력
		hu.walk();//인간이 걷는 두 발 출력
	}

}
