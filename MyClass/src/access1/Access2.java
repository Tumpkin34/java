package access1;

public class Access2 {

	public static void main(String[] args) {
		Access1 a1 = new Access1(4);
//		a1.data4 = 10;
		a1.setData4(10);
		System.out.println(a1.getData4());
	}

}
