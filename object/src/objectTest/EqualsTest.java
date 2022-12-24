package objectTest;

import java.util.Random;

class Employee {// 직원
	int number;
	String name;

	public Employee() {
		;
	}

	public Employee(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {// 기존 주소값을 비교하는 메소드에서 값을 비교하는 메소드로 변경
		// 주소 비교
		if (this == obj) {// 주소가 같다는건 값도 같은거기 때문에
			return true;// 바로 true를 넘겨준다.
		}

		// 타입 비교
		if (obj instanceof Employee) {// 모든 타입을 받아온 매개변수의 타입이 Employee타입이라면
			// Object에 up casting되었기 때문에 Employee에 새롭게 만든 number와 name은 Object에 없다.
			Employee anotherEmployee = (Employee) obj;// 업캐스팅된 obj를 해당 필드의 변수를 사용하기 위해 다운캐스팅
			if (this.number == anotherEmployee.number) {// 여기 주소의 number와 다운캐스팅한 받아온 주소의 number와 같다면
				return true;// true리턴
			}
		}
		return false;// 같은 주소도 아니고 같은 타입도 아니면 false;
	}
}

public class EqualsTest {
	public static void main(String[] args) {

		Employee han = new Employee(1, "한동석") {// 익명클래스로 구현한 방법
			@Override
			public boolean equals(Object obj) {
				if (this == obj) {
					return true;
				}
				if (obj instanceof Employee) {
					Employee employee = (Employee) obj;
					if (employee.name == this.name) {
						return true;
					}
				}
				return false;
			}
		};
		System.out.println(han.equals(new Employee(1, "한동석")));
		
//      String data1 = "ABC";
//      String data2 = "ABC";
//		String data3 = new String("ABC");
//		String data4 = new String("ABC");
//      
//      System.out.println(data1 == data2);// true 
//      System.out.println(data1.equals(data2));//true
//      
//      System.out.println(data3 == data4);// false new로 메모리에 각각 할당 되었기에 주소가 다르다
//      System.out.println(data3.equals(data4));// true String 클래스안에 equals는 주소가 아닌 값비교를 하게끔 재정의 되어있기때문에 값을 비교한다. 

      Random r1 = new Random();
      Random r2 = new Random();
      
      System.out.println(r1 == r2);//위에 주소값을 new로 생성해 주었기 때문에 서로 주소가 달라서 false
      System.out.println(r1.equals(r2));//위에 주소값을 new로 생성해 주었기 때문에 서로 주소가 달라서 false
      
      r1 = r2;//r2의 주소값을 r1에 넣음
      System.out.println(r1 == r2);//그렇기에 주소가 같으니 true
      System.out.println(r1.equals(r2));//그렇기에 주소가 같으니 true

	}
}