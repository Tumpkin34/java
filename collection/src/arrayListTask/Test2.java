package arrayListTask;

public class Test2 {
	public static void main(String[] args) {
		//이상형 2명 추가
		Love love = new Love();
		Love love2 = new Love();
		
		//dateApp객체화
		DateApp dateApp = new DateApp();
		
		//이상형 한명의 정보 추가
		love.setName("황지수");
		love.setAge(20);
		love.setNumber(1);
		
		//위와 같음
		love2.setName("홍길동");
		love2.setAge(25);
		love2.setNumber(2);
		
		//위 정보를 담은 주소를 추가
		dateApp.add(love);
		dateApp.add(love2);
		
//		System.out.println(DateApp.loves);
//		love인 황지수나이 30살로 변경
		love.setAge(30);
		System.out.println(DateApp.loves);//loves에 저장된 데이터들 다 출력
		dateApp.update(love);//위의 love를 update를 통해 덮어쓰기
//		
//		System.out.println(DateApp.loves);
		
//		나이에 따라 정렬 메소드
		dateApp.sort();
		
		System.out.println(DateApp.loves);
	}
}
