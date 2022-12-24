package arrayListTask;

import java.util.ArrayList;

public class Market {
//	과일들을 저장할 DB 선언
	public static ArrayList<Fruit> arFruit = new ArrayList<>();

//	과일 추가
	public void addFruit(String name, int price) {
		Fruit fruit = new Fruit();
		fruit.setFruitName(name);
		fruit.setPrice(price);
		arFruit.add(fruit);
	}

	public void addFruit(Fruit fruit) {
		arFruit.add(fruit);
	}

//	과일 삭제
//	과일의 이름을 외부에서 전달받는다.
	public void removeFruit(Fruit fruit) {
		arFruit.remove(fruit);
	}

	public void removeFruit(String name) {
		for (Fruit f : arFruit) {// 빠른 for문에서 반복자 자리에 있는 객체의 데이터에 변화가 생기면
//			반복에 대한 기준점이 수정되는 것이므로 오류가 발생한다.

			// DB에서 과일의 이름을 검색한다.
			if (f.getFruitName().equals(name)) {
				// 과일의 이름으로 삭제한다.
				// 과일의 이름이 검색되면 해당 객체를 저장한다.
				// 저장한 객체를 DB에서 삭제한다.
				arFruit.remove(f);
				break;
			}
		}
	}

//	과일 가격이 평균 가격보다 낮은 지 검사
	public static boolean checkPrice(int price) {
		return price < avgPrice();
	}

//	평균
	public static double avgPrice() {
		int sum = 0;
		for (Fruit f : arFruit) {
			sum += f.getPrice();
		}
		return Double.parseDouble(String.format("%.2f", (double) sum / arFruit.size()));
	}

	public static void main(String[] args) {
		Market market = new Market();
		Fruit fruit = new Fruit();
		fruit.setFruitName("수박");
		fruit.setPrice(10000);
		market.addFruit(fruit);
		market.addFruit("바나나", 2500);

		System.out.println(Market.arFruit.get(0));
		System.out.println(Market.arFruit.get(1));

		System.out.println(Market.avgPrice());

	}
}
