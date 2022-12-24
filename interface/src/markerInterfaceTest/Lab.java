package markerInterfaceTest;

public class Lab {

//	외부에서 모든 동물을 받아와서
//	초식동물인지 육식동물인지 그리고 잡식동물인지 구분하는 메소드
//	초식 동물 : Herbivore
//	육식 동물 : Carnivore
	public void checkKinds(Animal[] animal) {//동물타입의 각 동물의 주소값을 담은 배열의 주소를 가져온다.
//		외부에서 Animal 타입의 배열을 전달받고
//		instanceof를 사용하여 종을 검사한다.
		for (int i = 0; i < animal.length; i++) {//동물타입의 배열 넘겨 해당 배열의 길이 만큼 반복
			if (animal[i] instanceof HerbivoreMaker) {//만약 넘겨받은 동물타입배열의 i번째 방의 주소값이 초식동물인터페이스를 지정당했으면 true(인터페이스도 부모클래스처럼 지정받은 자식이 인터페이스의 타입을 띈다)
				System.out.println("초식");
			} else if (animal[i] instanceof CarnivoreMaker) {//만약 넘겨받은 동물타입배열의 i번째 방의 주소값이 육식동물 인터페이스를 지정당했으면 true
				System.out.println("육식");
			} else {//위의 두 조건이 아니라는건 잡식이라는 말이다.
				System.out.println("잡식");
			}
			
		}
	}

	public static void main(String[] args) {
		Lab l = new Lab();//checkKinds메소드 사용하기 위해 객체화
		Animal[] animals = { new Bear(), new Cow(), new Dog(), new Tiger() };//각 동물의 주소를 Animal타입의 배열에 업캐스팅하여 담김
		l.checkKinds(animals);//위에서 주소를 담은 Animal타입배열의 주소를 매개변수로 넘겨준다.
	}

}
