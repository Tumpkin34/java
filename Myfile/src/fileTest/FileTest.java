package fileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {
//		절대 경로 : 어디에서 작성해도 찾아갈 수 있는 경로, C:/a/b
//		상대 경로 : 현재 위치에 따라 변경되는 경로, ../a/b

//		"황지수황지수황지수\r\n"//return에 r
//		+ "황지수\r\n"
//		+ "황지수\r\n"
//		+ ""
//		try {
////		점하나 현재 경로 점두개 이전 경로
////		이클립스에서 현재경로는 프로젝트폴더이다.
//			버퍼를 사용한 출력 클래스 
//			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt", true));
//			버퍼에 황지수를 쓴다.	
////		bufferedWriter.write("황지수\n");
//			bufferedWriter.write("황지수");
//			bufferedWriter.newLine();// 운영체제에 맞는 줄바꿈으로 해준다.
//			버퍼에 들어있는 것들을 test.txt로 내보내 작성한다.
//			bufferedWriter.close();
//		} catch (
//
//		IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		읽을 txt파일 경로
		File file = new File("test.txt");
		try {
//			읽는 용도의 버퍼를 열어준다.
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//			readLine이 한줄만 가져와준다. 해당 메소드를 여러번 쓰면 다른 값들을 가져오기 때문에 다른곳에서도 사용하기 위해 가져온 값을 저장할 line을 선언한다.
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {//줄을 가져왔을때 null이 아니라면 반복한다.
				System.out.print(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("해당 경로는 존재하지 않습니다.");
		}
		
		if(file.exists()) {//해당 경로가 존재하면
			System.out.println(file.delete());//삭제
		}
	}

}
