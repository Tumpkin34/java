package collectionTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListTest {

	public static void test(int data) {
		data = 20;
	}

	public static void main(String[] args) {

		int data = 10;
		ArrayListTest.test(data);
		System.out.println(data);

//		<?> : 제네릭(일반적인, 포괄적인, *이름이 없는)
//		객체화 시 타입을 지정하는 기법
//		설계할 때에는 타입을 지정할 수 없기 때문에 임시로 타입을 선언할 때 사용한다.
//		따로 다운 캐스팅을 할 필요가 없다.
//		지정할 타입에 제한을 줄 수 있다.

		ArrayList<Integer> datas = new ArrayList<>();//ArrayList를 Integer타입을 받겠다 하고 객체화

//		ArrayList의 배열은 0칸 부터 시작하고 값이 들어오때 마다 배열이 길이를 늘린다.
		datas.add(10);
		datas.add(20);
		datas.add(40);
		datas.add(50);
		datas.add(90);
		datas.add(80);
		datas.add(70);
		datas.add(60);

//		배열의 길이는 length를 썻지만 ArrayList는 size를 사용한다.
//		System.out.println(datas.size());
//		for (int i = 0; i < datas.size(); i++) {
//			System.out.println(datas.get(i));
//		}

		System.out.println(datas);
		System.out.println(datas.toString());//ArrayList에서 toString은 [10, 20, 40, 50, 90, 80, 70, 60]이렇게 재정의 되어있다.

		Collections.sort(datas);//오름차순으로 정렬하는 메소드이다.
		System.out.println(datas);

		Collections.reverse(datas);//배열의 순서를 거꾸로 정리한다.
		System.out.println(datas);

		Collections.shuffle(datas);//배열의 순서를 섞는다.
		System.out.println(datas);

//		추가(삽입)
//		50 뒤에 500 삽입
		if (datas.contains(50)) {//datas의 값중에 50이 있는지 찾는 메소드를 사용해 있다면 true
			datas.add(datas.indexOf(50) + 1, 500);//50이들어있는 index번호는 찾고 해당 index +1 다음 인덱스 방에 오른쪽의 500의 값을 삽입한다.
		}

//		내 방법
//		int i = 0;
//		for (i = 0; i < datas.size(); i++) {
//			if (datas.get(i) == 50) {
//				break;
//			}
//		}
//		datas.add(i, 500);

//		수정
//		90을 9로 수정
		if (datas.contains(90)) {//90이 있는지 찾고
			//set왼쪽의 90이 들어있는 인덱스번호를 찾고 해당 번호의 값을 오른쪽의 9로 바꾼다.
			System.out.println(datas.set(datas.indexOf(90), 9) + "이 9로 변경되었습니다.");// pop이라고한다.
		}

//		내 방법
//		int i = 0;
//		for (i = 0; i < datas.size(); i++) {
//			if (datas.get(i) == 90) {
//				break;
//			}
//		}
//		datas.set(i, 9);

//		삭제
//		80삭제
//		1. 인덱스로 삭제
		if (datas.contains(80)) {//80이 있는지 찾고
			// 80이 있는 인덱스 번호를 찾고 remove의 매개변수로 넘겨준다.
			System.out.println(datas.remove(datas.indexOf(80)) + " 삭제");
		}

//		내 방법
//		int i = 0;
//		for (i = 0; i < datas.size(); i++) {
//			if (datas.get(i) == 80) {
//				break;
//			}
//		}
//		datas.remove(i);
//		System.out.println(datas);

//		2. 값으로 삭제
		if(datas.remove(Integer.valueOf(80))) {//int 타입그대로 80을 입력하면 인덱스 번호로 인식하기에 Integer로 boxing후 찾는다 리턴값을 boolean이기에 삭제했으면 true를 리턴해준다.
			System.out.println("삭제 완료");;
		}
		
//		내 방법
//		Integer i = 80;
//		datas.remove(i);
//		System.out.println(datas);

	}

}
