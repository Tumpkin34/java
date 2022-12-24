package fileTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class P1 {

	public static void main(String[] args) throws IOException {
		String[] temp = { "고등어", "갈치", "연어", "광어" };
		BufferedWriter bw = new BufferedWriter(new FileWriter("P1.txt"));
		for (String string : temp) {
			bw.write(string);
			bw.newLine();
		}
		bw.close();

		BufferedReader br = new BufferedReader(new FileReader("P1.txt"));
		String line = null;
		while((line = br.readLine()) != null) {
			System.out.print(line);
			
		}
	}

}
