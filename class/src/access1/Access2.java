package access1;

public class Access2 {
	public static void main(String[] args) {
		Access1 a1 = new Access1();
		//같은 패키지 내에 다른 클래스에서 접근가능 (private제외)
		a1.data1 = 0;//default
		a1.data2 = 0;//public
		a1.data3 = 0;//protected

	}
}
