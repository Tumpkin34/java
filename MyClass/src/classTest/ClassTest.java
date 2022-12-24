package classTest;

class A {
	int data;

	A(int data) {
		System.out.println("클래스에서 확인한 주소 : " + this);
		this.data = data;
	}

	void printData() {
		System.out.println(data);
	}
}

public class ClassTest {
	public static void main(String[] args) {
		A a = new A(10);
		System.out.println("메인메소드에서 확인한 주소 : " + a);

		a.printData();
	}
}
