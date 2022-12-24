package hashSetTest;

import java.util.HashSet;

public class School {
	public static void main(String[] args) {
		HashSet<Student> stds = new HashSet<Student>();
//		set에는 중복으로 안들어가는데 밑에 2코드는 주소값이 다르기 때문에 둘다 들어간다. 그래서 밑의 hashCode를 재정의해
//		하나만 들어갈 수 있게끔 한다.
		stds.add(new Student(1, "한동석"));
		stds.add(new Student(1, "한동석"));

		System.out.println(stds.size());

		// 1,한동석이라는 사람이 같은 사람이라고 볼때 두객체를 비교했을때 true가 나오게끔 equals재정의
		Student han = new Student(1, "한동석");
		System.out.println(han.equals(new Student(1, "한동석")));
	}
}