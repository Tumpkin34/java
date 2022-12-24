package collectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamTask {
	public static void main(String[] args) {
//		1~10까지 ArrayList에 담고 출력
		ArrayList<Integer> datas = new ArrayList<Integer>();
		IntStream.range(1, 11).forEach(datas::add);//range를 통해 1~11(미포함)까지의 범위를 forEach로 datas에 추가
		System.out.println(datas);
		
//		1~100까지 중 홀수만 ArrayList에 담고 출력
		ArrayList<Integer> datas2 = new ArrayList<Integer>();
		IntStream.range(1, 101).filter(v -> v % 2 != 0).forEach(datas2::add);//100번 반복 filter를 사용해 해당 숫자가 2의 배수가 아닌걸 찾아냄
		IntStream.range(1, 51).map(v -> v * 2 - 1).forEach(datas2::add);//50번 반복 map을 사용해 해당 숫자 *2는 2의 배수니까 +1한값으로 바꿈
		System.out.println(datas2);
		
//		ABCDEF를 각 문자별로 출력
		String data = "ABCDEF";
		data.chars().forEach(v -> System.out.print((char)v));//문자열에서 하나씩 뺴와서(정수임) 형변환후 출력
		IntStream.rangeClosed('A', 'F').forEach(c -> System.out.println((char)c));//intStream으로 A~F까지의 범위를 형변환후 출력
		
//		A~F까지 ArrayList에 담고 출력
		ArrayList<Character> datas3 = new ArrayList<Character>();//
		IntStream.rangeClosed('A', 'F').forEach(c -> datas3.add((char)c));//A~F까지 형변환후 담음
		System.out.println(datas3);
		
//		map()
//		A~F까지 중 D제외하고 ArrayList에 담고 출력
		ArrayList<Character> datas4 = new ArrayList<Character>();
		IntStream.rangeClosed('A', 'E').map(v -> v > 67 ? v + 1 : v).forEach(v -> datas4.add((char)v));//68부터는 +1 후 형변환후 추가
		System.out.println(datas4);
		
//		map()
//		5개의 문자열을 입력받은 후 모두 소문자로 변경(String.toLowerCase())
		System.out.println("ABC".toLowerCase());//메소드 어떻게 실행되는지 확인
		ArrayList<String> datas5 = new ArrayList<String>(Arrays.asList("Black", "WHITE", "reD", "yeLLow", "PINk"));//괄호안에 값을 바로 담을 수 있음
		datas5.stream().map(String::toLowerCase).forEach(System.out::println);//해당 값을 toLowerCase()로 대소문자반전후 출력
		
//		filter()
//		Apple, banana, Melon 중 첫번째 문자가 대문자인 문자열 출력
		ArrayList<String> datas6 = new ArrayList<String>(Arrays.asList("Apple", "banana", "Melon"));
		//filter를 통해 대문자가 아니라면 제외 후 출력
		datas6.stream().filter(fruit -> fruit.charAt(0) >= 'A').filter(fruit -> fruit.charAt(0) <= 'Z').forEach(System.out::println);
		
//		chars(), map(), forEach()
//		한글을 정수로 변경
		String hangle = "공일이삼사오육칠팔구";
		String data2 = "일공이사";
//		chars로 하나씩 가져옴.가져온 값이 hangle의 몇번쨰 인덱스인지 찾은후. 그걸 출력
		data2.chars().map(hangle::indexOf).forEach(System.out::print);
		
//		정수를 한글로 변경
		String hangle2 = "공일이삼사오육칠팔구";
		String data3 = "1024";
//		chars로 하나씩 가져오는데. 아스키코드로 바뀌니까 -48로 정수로 바꾸고. hangle의 바꾼값의 인덱스 번호에 있는 값 출력
		data3.chars().map(c -> c - 48).forEach(c -> System.out.print(hangle2.charAt(c)));
	}
}
