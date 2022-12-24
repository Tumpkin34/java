package objectTest;

import java.util.Random;

public class HashCodeTest {//부족한 부분

	public static void main(String[] args) {
		String data1 = "ABC";
		String data2 = "ABC";
		String data3 = new String("ABC");//필드우선순위가 높은데 String에서 문자열값의 해시코드값을 리턴하게끔 재정의 되어있다.
		String data4 = new String("ABC");
		
		//String에서 재정의된 hashCode는 필드의 주소 해시코드가 아니라 문자열 상수값의 해시코드값을 리턴한다
		//밑 두개의 해쉬코드 값은 같다.
		System.out.println(data1.hashCode());
		System.out.println(data2.hashCode());
		
		//필드의 주소가 우선순위가 높지만 문자열값의 해시코드를 리턴하게끔 재정의 되어있기 때문에 같다
		System.out.println(data3.hashCode());
		System.out.println(data4.hashCode());
		
		Random r1 = new Random();
		Random r2 = new Random();
		
		System.out.println(r1);//사실 주소값이 아니라 해시코드의 값을 16진수 나타낸거였음
		System.out.println(r1.hashCode());//jvm의 해시코드값 출력 10진수로 출력됨
		System.out.println(r2.hashCode());

	}

}
