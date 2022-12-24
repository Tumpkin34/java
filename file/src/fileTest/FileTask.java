package fileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTask {
	public static void main(String[] args) throws IOException{
//		고등어, 갈치, 꽁치, 전어 --> 0, 1, 2, 3
		String[] fishs = {"고등어", "갈치", "꽁치", "전어"};
		
//		배열로 출력하고 전체 내용 가져와서 콘솔에 출력하기
//		txt에 쓰는 버퍼 엶
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fish.txt"));
//		for (String fish : fishs) {//빠른 for문 쓰면서 버퍼에 생선들 집어 넣음
//			bufferedWriter.write(fish + "\n");
//		}
//		bufferedWriter.close();//버퍼에 있는 생선 text에 쓰고 버퍼 닫음
		
//		try {
//	 	읽는 버퍼 엶 
//			BufferedReader bufferedReader = new BufferedReader(new FileReader("fish.txt"));
//		readLine으로 줄을 가져왔을 때 null이 아닐때까지 반복 후 하나씩 출력 	
//			String line = null;
//			while((line = bufferedReader.readLine()) != null) {
//				System.out.println(line);
//			}
//		다끝나면 버퍼 닫아줌
//			bufferedReader.close();
//			
//		} catch (FileNotFoundException e) {
//			System.out.println("없는 경로");
//		}
		
//		수정(갈치 -> 연어)
//		try {
//			버퍼 열고
//			BufferedReader bufferedReader = new BufferedReader(new FileReader("fish.txt"));
//			String line = null, temp = "";
//			
//			한 줄 씩 가져옴
//			while((line = bufferedReader.readLine()) != null) {
//				if(line.equals("갈치")) {//가져온 줄이 갈치랑 같다면
//					temp += "연어\n";//연어를 저장
//					continue;//바로 다음 반복
//				}
//				temp += line + "\n";//가져온 줄이 갈치라면 위에서 걸리고 아니라면 밑에서 그냥 해당줄 temp에 저장
//			}
//			
//			bufferedReader.close(); 끝났으면 버퍼 닫음
//			
//			쓰는 버퍼 엶
//			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fish.txt"));
//			아까 temp에 저장해둔 생선들 버퍼에 올려줌
//			bufferedWriter.write(temp);
//			버퍼에 있던 생선들 txt에 적고 버퍼 닫음
//			bufferedWriter.close();
//			
//		} catch (FileNotFoundException e) {
//			System.out.println("없는 경로입니다.");
//		}
		
//		고등어 삭제
		try {
//			버퍼 엶
			BufferedReader bufferedReader = new BufferedReader(new FileReader("fish.txt"));
			String line = null, temp = "";
			
			while((line = bufferedReader.readLine()) != null) {
				if(line.equals("고등어")) {// 고등어 찾으면 
					continue;//바로 다음 반복(그러면 고등어는 temp에 저장 되지않고 건너뜀)
				}
				temp += line + "\n";//고등어 제외한 생선은 temp에 담음
			}
			
			bufferedReader.close();//버퍼 닫음
			
//			쓰기 버퍼 열고
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fish.txt"));
			bufferedWriter.write(temp);//버퍼에 temp올림
			bufferedWriter.close();//버퍼의 내용 txt에 내보내고 닫음
			
		} catch (FileNotFoundException e) {
			System.out.println("없는 경로입니다.");
		}
	}
}






















