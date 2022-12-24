package wrappperTest;

public class WrapperTest {

	public static void main(String[] args) {
		int data_i = 10;

//		boxing              디프리케이티드 : 더이상 쓰지 말아라(이방식을 권장하지 않는다.)
//		Integer data_I = new Integer(data_i);
//		Integer data_I = Integer.valueOf(data_i);//valueOf메소드는 매개변수의 타입을 해당 클래스의 타입으로 바꿔준다.

//		auto boxing
		Integer data_I = data_i;//변수의 타입을 해당 클래스로 선언을 하면 알아서 해당타입으로 바뀌어 들어간다.
		
		
//		unboxing
//		data_i = data_I.intValue();//unboxing하는 문법

//		auto unboxing
		data_i = data_I;//Integer타입인 data_I를 int 타입인 data_i에 넣으면 알아서 int로 들어간다.

	}

}
