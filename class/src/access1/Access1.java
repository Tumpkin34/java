package access1;

class F {
}

public class Access1 {
	// 접근 권한 제어자들
	int data1 = 10;// default 다른 패키지에서 접근불가
	public int data2 = 20;// 모든 곳에서 접근가능 해당파일의 메인클래스일 경우만 사용
	protected int data3 = 30;// 다른 패키지에서 접근불가 단, 상속받은 자식클래스가 되면 가능
	private int data4 = 40;// 다른 클래스에서 접근불가, 초기화생성자로 접근하던가 게터와 세터로 접근해야함

	public Access1() {
		;
	}

	public Access1(int data4) {// 초기화생성자로 private에 접근가능 하게함
		this.data4 = data4;
	}

	public int getData4() {// 게터로 data4의 값을 줄 수 있음
		return data4;
	}

	public void setData4(int data4) {// 세터로 data4의 값을 변경할 수 있음
		this.data4 = data4;
	}

	public static void main(String[] args) {
		Access1 a1 = new Access1();
		//같은 클래스에서 모두 잘 불러와진다.
		a1.data1 = 0; 
		a1.data2 = 0;
		a1.data3 = 0;
		a1.data4 = 0;
	}
}
