package dateTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTask {

	public static void main(String[] args) {
//		본인의 생년월일 출력
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		Calendar my = Calendar.getInstance();

		my.set(1998, 05, 29);
		System.out.println(simpleDateFormat.format(my.getTime()));
	}

}
