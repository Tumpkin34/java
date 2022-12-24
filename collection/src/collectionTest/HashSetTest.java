package collectionTest;

import java.util.ArrayList;
import java.util.HashSet;
//import java.util.Iterator;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> bloodTypes = new HashSet<String>();

//		혈액형 추가
		bloodTypes.add("A");
		bloodTypes.add("B");
		bloodTypes.add("O");
		bloodTypes.add("AB");
//		같은 혈액형은 추가 안되기 때문에 밑에서 부턴 안들어간다.
		bloodTypes.add("AB");
		bloodTypes.add("AB");
		bloodTypes.add("AB");
		bloodTypes.add("AB");
		bloodTypes.add("AB");

//		set은 순서가 없지만 ArrayList에 담음으로써 순서를 만들어줌
		ArrayList<String> bloodTypeList = null;
		bloodTypeList = new ArrayList<String>(bloodTypes);
		System.out.println(bloodTypeList.get(0));

		System.out.println(bloodTypes);//set은 가져올 수 없다 했는데 가져와진다. 이유는 Iterator타입으로 바뀐후 그안에 재정의된 toString이 사용되었기 때문

		Iterator<String> iter = bloodTypes.iterator();//bloodTypes를 iterator메소드로 Iterator타입으로 바꾼다.

		while (iter.hasNext()) {//iter로 바뀐 bloodTypes의 다음번에 값이 있다면 trues
			System.out.println(iter.next());//해당값을 가져다 준다.
		}
//
//		---------------------------------
//		System.out.println(bloodTypes.toString());
//		for (String string : bloodTypeList) {//빠른 for문은 객체뒤에 자동으로 iterator가 붙고 hasNext로 가져오는 친구이다.
//
//		}
	}
}
