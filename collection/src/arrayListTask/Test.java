package arrayListTask;

public class Test {
	public static void main(String[] args) {
		
//		Fruit f = new Fruit();
//		Market f2 = new Market();
//		f.setName("과일");
//		f.setPrice(1000);
//		f2.add(f);
//		System.out.println(Market.fruits);
		
//		f2.remove("과일");
//		System.out.println(Market.fruits);

		//사과, 바나나 객체화
		Fruit apple = new Fruit();
		Fruit banana = new Fruit();
		
		Market market = new Market();//마켓 객체화
		
		apple.setName("사과");//apple에 사과 저장
		apple.setPrice(1000);//apple에 1000원 저장
		
		banana.setName("바나나");
		banana.setPrice(800);
		
		market.add(apple);//사과 추가
		market.add(banana);
		
		System.out.println(market.getAverage());//평균 구하는 메소드로 평균출력
		
//		market.remove("사과");//사과 삭제
//		System.out.println(Market.fruits.size());//저장된 과일의 개수 출력
		
	}
}








