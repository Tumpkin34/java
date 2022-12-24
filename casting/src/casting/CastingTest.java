package casting;

class Car{//부모 클래스
	void engineStart() {
		System.out.println("열쇠로 시동 킴");
	}
}

class SuperCar extends Car{//자식 클래스 Car를 상속받음
	@Override
	void engineStart() {//부모클래스의 engineStart를 오버라이딩(재정의)
		System.out.println("음성으로 시동 킴");
	}
	
	void openRoof() {//자식클래스만의 새로운 기능
		System.out.println("지붕 열기");
	}
	
}


public class CastingTest {
	public static void main(String[] args) {
		Car matiz = new Car();//Car필드의 주소값을 Car자료형의 마티즈라는 객체명에 저장
		SuperCar ferrari = new SuperCar();//SuperCar필드의 주소를 SuperCar자료형의 페라리에 저장
		
		//up casting
		Car noOptionFerrari = new SuperCar();//SuperCar필드의 주소를 Car자료형의 노옵션페라리라는 객체명에 저장 SuperCar의 +a부분은 숨겨진다.
		
		//down casting
		SuperCar fullOptionFerrari = (SuperCar)noOptionFerrari;//위에 업캐스팅된 Car자료형의 노옵션 페라리를 SuperCar로 다운캐스팅(형변환)후 SuperCar타입에 풀옵션페라리로 저장
		
		//오류
//		SuperCar brokenFerrai = (SuperCar)new Car();
		
//		matiz instanceof Car : true
		System.out.println(matiz instanceof Car); // 마티즈는 Car클래스로 객체화 했으니 당연히 true
		
//		matiz instanceof SuperCar : false
		System.out.println(matiz instanceof SuperCar);// 마티즈는 Car클래스로 객체화 했으니 당연히 false
		
//		ferrari instanceof Car : true
		System.out.println(ferrari instanceof Car);// 페라리는 SuperCar클래스로 객체화 했으나 SuperCar클래스는 Car클래스를 상속 받았으니 Car클래스 타입도 가지고 있어 true 
		
//		ferrari instanceof SuperCar : true
		System.out.println(ferrari instanceof SuperCar);// 페라리를 SuperCar클래스로 객치화 했으니 당연히 true
		
//		noOptionFerrari instanceof Car : true
		System.out.println(noOptionFerrari instanceof Car);// 노옵션페라리를 Car로 업캐스팅했으니 true
		
//		noOptionFerrari instanceof SuperCar : true
		System.out.println(noOptionFerrari instanceof SuperCar);// 노옵션페라리를 Car로 업캐스팅했으나 그래도 SuperCar인건 변함없음으로 true
		
//		fullOptionFerrari instanceof Car : true
		System.out.println(fullOptionFerrari instanceof Car);// Car로 업캐스팅(형변환)되었던 노옵션페라리를 (SuperCar)로 형변환후 다시 SuperCar로 담아 줬으니 자식은 부모의 타입도 가지고 있어 true 
		
//		fullOptionFerrari instanceof SuperCar : true
		System.out.println(fullOptionFerrari instanceof SuperCar);// 다시 SuperCar로 형변환 되었으니 true
		
	}
}





















