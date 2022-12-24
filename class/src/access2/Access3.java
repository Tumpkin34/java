package access2;

import access1.Access1;

public class Access3 extends Access1 {// Access1을 상속받음 그래서 protected사용 가능하게됨
	public static void main(String[] args) {
//		Access1 a1 = new Access1();
		Access3 a3 = new Access3();// Access3 객체화 Access1 필드사용가능(접근 권한 제어자에 따라 사용불가능)
		a3.data2 = 0; // public 같은 프로젝트 내의 다른 패키지 임에도 사용가능
		a3.data3 = 0; // protected 다른 패키지에 사용불가지만 Access1를 상속 받았기에 사용가능해짐
		System.out.println(a3.getData4());//get으로 data4에 접근가능
		a3.setData4(100);//set으로 data4에 접근가능
		System.out.println(a3.getData4());//set으로 바꿔준 값 확인

	}
}
