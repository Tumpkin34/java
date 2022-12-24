package classTest;

class Test {
	int data;

	public Test() {;}// 세미콜론 : "나 일부로 비운거야"

	public Test(int data) {
		this.data = data;
	}

	void printData() {
		System.out.println(data);
	}

}

public class ClassArray {

	public static void main(String[] args) {
		Test[] arTest = new Test[12];// null들어가 있음

		for (int i = 0; i < arTest.length; i++) {
			arTest[i] = new Test(i + 1);
		}
		
		arTest[10].printData();
	}

}
