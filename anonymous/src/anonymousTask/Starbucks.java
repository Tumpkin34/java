package anonymousTask;

public class Starbucks {// 본사
//	양식을 받는 메소드 구현
	public void register(Form form) {//form의 틀을 기반으로 작성된 양식을 받는다.(매개변수) register(등록하다)
		String[] menus = form.getMenu();//받아온 양식주소에 담긴 판매할 메뉴가 담긴 주소를 menus배열에 담아준다.

		System.out.println("=======메뉴========");
		for (int i = 0; i < menus.length; i++) {//위에 담긴 판매할 메뉴를 출력한다.
			System.out.println(i + 1 + ". " + menus[i]);
		}

		if (form instanceof FormAdapter) {//넘겨받은 주소가 formAdapter타입이라는것은 넘겨받은 주소에서 구현을 직접하지않았다는 뜻이고 구현을 직접하지 않았다는건 무료행사중이라는 뜻
			System.out.println("무료 나눔 행사중");
			return;//무료행사중이기 때문에 바로 끝내준다.
		}

		form.sell("카푸치노");//"카푸치노"를 판매하면 출력할 문구를 출력하는 메소드
	}
}