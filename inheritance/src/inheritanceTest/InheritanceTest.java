package inheritanceTest;

class A {//부모클래스로 쓰일 예정
	//부모클래스에 정의된 필드들
	String name = "A";
	int data = 10;

	void printName() {
		System.out.println(name);
		System.out.println("부모");
	}
}

class B extends A {// extends키워드 : 상속받는다 A를

	public B() {//기본 생성자 매개변수를 받아오지 않았기 때문 
		super(); // 부모 생성자(super클래스라고도 함) ※부모먼저 생성해야한다. 
		name = "B";// 자식에서 새로운 값으로 초기화
		System.out.println("자식");
	}

	void printData() {// 자식클래스에서 새롭게 생긴 메소드
		System.out.println(data);
	}
}

public class InheritanceTest {

	public static void main(String[] args) {
		B b = new B();// 자식클래스 객체화
		b.printName();// 부모클래스에 있는 메소드 실행(상속 받았기에 가능)부모클래스의 메소드를 사용했기만 자식클래스의 생성자에서 name에 B값을 넣어줬으니 name출력에서 B출력
		b.printData();// 자식클래스에 있는 메소드 실행, 부모클래스에서 data에 10을 넣어줬고 그걸 상속 받았기에 자식에서 data를 출력했을떄 10출력
	}

}
