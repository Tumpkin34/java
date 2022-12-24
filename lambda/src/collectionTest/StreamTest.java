package collectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {
	public static void main(String[] args) {
//		forEach()
//		여러 값을 가지고 있는 컬렉션 객체에서 forEach 메소드를 사용할 수 있다.
//		forEach 메소드에는 Consumer 인터페이스(함수형) 타입의 값을 전달해야 한다.
//		Consumer는 함수형 인터페이스이기 때문에 람다식을 사용할 수 있다.
//		매개변수에는 컬렉션 객체 안에 들어있는 값들이 순서대로 담기고,
//		화살표 뒤에서는 실행하고 싶은 문장을 작성한다.
		HashMap<String, Integer> chinaTown = new HashMap<String, Integer>();
		ArrayList<Integer> datas = new ArrayList<Integer>();
		
		chinaTown.put("자장면", 4500);
		chinaTown.put("짬뽕", 5500);
		chinaTown.put("탕수육", 14500);
//		
//		차이나타운의. value들을 가져다 주고. stream타입으로 바꾼후. 해당 객체의 value를 하나씩 가져와서 출력한다.
		chinaTown.values().stream().forEach(price -> System.out.println(price));
//		forEach를 하도 쓰니까 Collection에도 만들어둠 그래서 stream생략 가능
		chinaTown.values().forEach(price -> System.out.println(price));
//		아차피 값이 들어오자마자 쓰이니까 참조형으로도 사용가능
		chinaTown.values().forEach(System.out::println);
//		
		datas.add(10);
		datas.add(20);
		datas.add(30);
		datas.add(40);
		
		datas.forEach(value -> {//2문장이상의 람다식
			System.out.println(value);
			System.out.println("안녕");
		});
		
//		전달받은 매개변수를 그대로 메소드에 사용할 경우에는 참조형 문법을 사용할 수 있다.
//		소속::메소드명 --> 전달받은 값을 메소드의 매개변수로 바로 전달해준다.
		datas.forEach(System.out::println);
		
//		IntStream이라는 API에 range라는 메소드는 1씩증가한다 Closed는 end포함
//		IntStream.range(start, end) : start부터 end-1까지
//		IntStream.rangeClosed(start, end) : start부터 end까지
		IntStream.range(1, 10).forEach(System.out::println);
//		1~10까지 출력
		IntStream.rangeClosed(1, 10).forEach(System.out::println);
		
//		chars() : 문자열을 IntStream으로 변경
		String data = "ABC";
		data.chars().forEach(System.out::println);//IntStream이기 떄문에 정수로 나옴
		data.chars().forEach(number -> System.out.println((char)number));
		
//		map() : 기존 값을 원하는 값으로 변경
		String data2 = "ABC";
		data2.chars().map(number -> number + 3).forEach(v -> System.out.print((char)v));
		
//		filter() : 조건식을 작성하여 false일 경우 제외시킨다.
		IntStream.rangeClosed(1, 10).filter(n -> n % 2 == 0).forEach(System.out::println);
		
//		sorted()
		Integer[] arData = {10, 40, 20, 30};
//		ArrayList<Integer> datas = new ArrayList<Integer>(Arrays.asList(arData));
		ArrayList<Integer> datas2 = new ArrayList<Integer>(Arrays.asList(10, 40, 20, 30));
		System.out.println(datas2);
		
//		오름차순
		datas.stream().sorted().forEach(System.out::println);
//		내림차순
		datas.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
		
//		collect() : 결과를 다양한 타입으로 리턴해준다.
		ArrayList<Integer> results = 
				(ArrayList<Integer>)datas.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(results);
		
//		Collectors.joining("구분점");
//		문자열 타입의 값을 원하는 구분점으로 연결하여 리턴한다.
//		문자열 타입이 아닌 값은 joining을 사용할 수 없다.
		String result = datas.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "));
		System.out.println(result);
	}
}












