package anonymousTask;

public class Building {
	public static void main(String[] args) {
//      잠실점 오픈
//      잠실점은 무료 나눔 행사중이라서 판매 방식을 구현할 필요 없다.(sell)
//      본사에서는 전달받은 양식을 검사할 때
//      무료나눔 행사중인 매장이라면 "무료 나눔 행사중" 출력하기

		Starbucks jamsil = new Starbucks();// 잠실점 객체화

//		register 메소드의 매개변수는 Form타입이다.
//		FormAdapter는 Form의 자식 타입이므로 up casting을 통해 전달한다.
		jamsil.register(new FormAdapter() {// Form에서 정해준 틀을 재정의 하지만 잠실점은 sell은 재정의 안해도 되기 때문에 Adapter를 통해서 강제성을 소멸 시켜준다.
			@Override
			public String[] getMenu() {// form의 메소드를 구현
//				판매할 메뉴가 담긴 배열을 리턴해주는 메소드로 오버라이딩
				String[] menus = { "아메리카노", "카푸치노", "캐모마일티" };
				return menus;
			}
		});

		Starbucks gangnam = new Starbucks();// 강남점 객체화
		gangnam.register(new Form() {// 스타벅스클래스필드의 주소안에(주소값은 gangnam에 담겨있음) register메소드를 사용하려하는데 form을 재정의한 메소드가 필요하고
										// 재정의 함과 동시에 필드의 주소가 되어 전달 된다.

			@Override
			public void sell(String order) {// 주문한 음료매개변수로 받아옴 추상메소드를 구현
				String[] menus = getMenu();// getMenu메소드는 메뉴가 담긴 배열의 주소를 전달한다.그걸 여기menus에도 저장한다
				for (int i = 0; i < menus.length; i++) {// 메뉴의 길이 만큼 반복
					if (order.equals(menus[i])) {// 받아온 주문한음료와 일치하는 메뉴가 있다면 실행
						System.out.println("판매 완료");//우리강남점은 판매가 되면 이렇게 출력하겠다
					}
				}
			}

			@Override
			public String[] getMenu() {// 강남점에서 판매할 메뉴
				String[] menus = { "아메리카노", "카푸치노", "캐모마일티" };
				return menus;
			}
		});

	}
}