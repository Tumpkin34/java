package dateTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class P1 {

	public static void main(String[] args) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy년 MM월 dd일");
		Calendar cal = Calendar.getInstance();
		cal.set(2000, 1, 31);
		System.out.println(simple.format(cal.getTime()));
	}

}
