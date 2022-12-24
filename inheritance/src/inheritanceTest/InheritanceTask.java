package inheritanceTest;

class Car {
// 브랜드, 색상, 가격
	// 자동차라면 가지고있을 정보
	String brand;
	String color;
	int price;

	public Car() {;}// 기본생성자

	public Car(String brand, String color, int price) {// 초기화 생성자 매개변수로 값을 받아 전역변수에 담는다.
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

// 열쇠로 시동 킴
	void engineStart() {// 자동차라면 있는 기능
		System.out.println("열쇠로 시동 킴");
	}

// 열쇠로 시동 끔
	void engineStop() {// 자동차라면 있는 기능
		System.out.println("열쇠로 시동 끔");
	}
}

class SuperCar extends Car {// Car상속 받음 그렇기에 Car의 필드들 사용가능 

// 모드
	//Car엔 없고 SuperCar엔 있는 정보 추가
	String mode;
	boolean roof;
	
//	자식 기본 생성자는 부모의 기본 생성자를 호출한다.
//	부모에 기본 생성자가 없으면 자식의 기본 생성자는 오류가 발생한다.
	public SuperCar() {;} //SuperCar 기본 생성자
	
	public SuperCar(String brand, String color, int price, String mode) {// 초기화생성자
//		부모의 생성자 중 3개의 값을 전달받는 생성자 호출
		super(brand, color, price);//super로 부모생성자 호출하고 부모생성자는 기본생성자도 있지만 초기화 생성자도 있기에 매개변수를 받아온값을 넣어줌으로 초기화
		this.mode = mode;
	}

// 음성으로 시동 킴
	@Override
	void engineStart() {//오버라이딩 음성으로 시동을 켜기 위해 부모클래스의 시동키는 메소드를 재정의
		System.out.println("음성으로 시동 킴");
	}

// 음성으로 시동 끔
	@Override
	void engineStop() {//오버라이딩 음성으로 시동을 끄기 위해 부모클래스의 시동끄는 메소드를 재정의
		System.out.println("음성으로 시동 끔");
	}

// 지붕 열기
	void openRoof() {//슈퍼카에만 있는 기능 추가
		System.out.println("뚜껑열림");
		roof = true;
	}

// 지붕 닫기
	void closeRoof() {//슈퍼카에만 있는 기능 추가
		System.out.println("뚜껑닫힘");
		roof = false;
	}
}

public class InheritanceTask {

	public static void main(String[] args) {
		SuperCar Ferrai = new SuperCar("페라리", "파랑", 20_000, "일상");//기본생성자가 있어 값을 안넣어도 되지만 넣어줌
		Ferrai.engineStart();//페라리의 시동켜는 메소드 실행 SuperCar에서 재정의된 engineStart실행
		Ferrai.engineStop();//페라리의 시동끄는 메소드 실행 SuperCar에서 재정의된 engineStop실행
		Ferrai.openRoof();//페라리만의 메소드 실행
		Ferrai.closeRoof();//페라리만의 메소드 실행
	}

}
