package wrappperTest;

public class WrapperTask {

	public static void main(String[] args) {
		// 1, 12.5, 86.6F, 'Z', "Hi", false
		// 위 6개의 값을 6칸 배열에 담기
		//밑에서 boxing을 해준후(내가한 방법)
		Integer i = 1;
		Double d = 12.5;
		Float f = 86.6F;
		Character c = 'Z';
		String s = "Hi";
		Boolean b = false;

		Object[] datas = { 1, 12.5, 86.6F, 'Z', "Hi", false };//autoboxing이 되어 datas에 들어간다.
//		위에서 박싱한 값들을 업캐스팅해 담는다.(내가한 방법)
		Object[] temp = { i, d, f, c, s, b };

//		단순출력
		for (Object o : datas) {
			System.out.println(o);
		}
		
	}

}
