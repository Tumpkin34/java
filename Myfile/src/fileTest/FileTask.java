package fileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;

public class FileTask {

	public static void main(String[] args) throws IOException {
//		고등어, 갈치, 꽁치, 전어
//		배열로 출력하고 전체 내용 가져와서 콘솔에 출력하기
//		String[] fish = { "고등어", "갈치", "꽁치", "전어" }; //4개의 생선 담은 배열
//		ArrayList<String> fishs = new ArrayList<String>(Arrays.asList(fish));//생선배열을 ArrayList로 바꿈
//		stream으로 시도해 본것 값 하나씩 받을 때 마다 text.txt에 써준다.
//		fishs.forEach(t -> {
//			try {
//				BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt", true));
//				bw.write(t + "\n");
//				bw.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		});
//		
//		BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt", true));
//		fishs.forEach(t -> {
//			try {
//				bw.write(t);
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		});
//		try {
//			BufferedReader br = new BufferedReader(new FileReader("text.txt"));
//			String line = null;
//			while ((line = br.readLine()) != null) {
//				System.out.println(line);
//			}
//			br.close();
//		} catch (FileNotFoundException e) {
//			System.out.println("없는 경로");
//		}
//		수정(갈치 -> 연어)
//		try {
//			BufferedReader bufferedReader = new BufferedReader(new FileReader("fish.txt"));
//			String line = null, temp = "";
//			while ((line = bufferedReader.readLine()) != null) {
//				if (line.equals("갈치")) {
//					temp += "연어\n";
//					continue;
//				}
//				temp += line + "\n";
//			}
//
//			bufferedReader.close();
//			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fish.txt"));
//			bufferedWriter.write(temp);
//			bufferedWriter.close();
//			
//		} catch (FileNotFoundException e) {
//			System.out.println("없는 경로입니다");
//		}
		
//		고등어 삭제
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("fish.txt"));
			String line = null, temp = "";
			while ((line = bufferedReader.readLine()) != null) {
				if (line.equals("고등어")) {
					continue;
				}
				temp += line + "\n";
			}
			
			bufferedReader.close();
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fish.txt"));
			bufferedWriter.write(temp);
			bufferedWriter.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("없는 경로입니다");
		}

	}

}
