package collectionTest;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTask {
//	선언,출력제외 나머지 한줄로 코드작성
	public static void main(String[] args) {
//		1~10까지 ArrayList에 담고 출력
		ArrayList<Integer> nums = new ArrayList<Integer>();
//		IntStream.rangeClosed(1, 10).forEach(n -> nums.add(n));
		IntStream.rangeClosed(1, 10).forEach(nums::add);
		nums.forEach(System.out::println);

//		1~100까지 중 홀수만 ArrayList에 담고 출력
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		IntStream.rangeClosed(1, 100).filter(n -> n%2 != 0).forEach(nums2::add);
//		IntStream.rangeClosed(1, 51).map(n -> n * 2 - 1).forEach(nums2::add);
		nums2.forEach(System.out::println);

//		ABCDEF를 각 문자별로 출력
		String data = "ABCDEF";
		data.chars().forEach(n -> System.out.println((char)n));
		IntStream.rangeClosed('A', 'F').forEach(n -> System.out.println((char)n));

//		A~F까지 ArrayList에 담고 출력
		ArrayList<Character> nums3 = new ArrayList<>();
		IntStream.rangeClosed(65, 70).forEach(n -> nums3.add((char)n));
		nums.forEach(System.out::println);

//		A~F까지 중 D제외하고 ArrayList에 담고 출력
		ArrayList<Character> nums4 = new ArrayList<>();
		IntStream.rangeClosed(65, 69).map(number -> number >= 68 ? number + 1 : number)
				.forEach(n -> nums4.add((char) n));
		nums4.forEach(System.out::println);

//		5개의 문자열을 입력받은 후 모두 소문자로 변경(String.toLowerCase())
//		String[] str = { "blaCK", "WHite", "yeLLow", "REd", "PinK" };
//		ArrayList<String> temp = new ArrayList<String>(Arrays.asList(str));
		ArrayList<String> temp = new ArrayList<String>(Arrays.asList("blaCK","WHite","yeLLow","REd","PinK"));
		temp.stream().map(String::toLowerCase).forEach(System.out::println);
		temp.forEach(n -> n.toLowerCase());
		temp.forEach(System.out::println);

//		Apple, banana, Melon 중 첫번째 문자가 대문자인 문자열 출력
		String[] fruit = { "Apple", "banana", "Melon" };
		ArrayList<String> fruits = new ArrayList<String>(Arrays.asList(fruit));
		fruits.stream().filter(n -> n.charAt(0) >=65 &&n.charAt(0) <=90).forEach(System.out::println);;

//		chars map forEach
//		한글을 정수로 변경
		String hangle = "공일이삼사오육칠팔구";
		String temp2 = "공구일삼";
		temp2.chars().forEach(n -> System.out.print(hangle.indexOf(n)));
//		temp2.chars().map(n -> hangle.indexOf(n)).forEach(n -> System.out.print(n));

//		정수를 한글로 변경
		String hangle2 = "공일이삼사오육칠팔구";
		int temp3 = 3468;
		String temp4 = temp3+"";
		temp4.chars().forEach(n -> System.out.print(hangle2.charAt(n-48)));
//		temp4.chars().map(n -> n-48).forEach(n -> System.out.print(hangle2.charAt(n)));

	}

}
