package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//	버퍼열고 닫기매번 쓰기 효율이 떨어지기에 메소드로 써두고 갖다쓰기위해 만듬
public class DBConnecter {
	public static final String PATH = "boxOffice.txt";//대상 파일 변수
	
	public static BufferedWriter getWriter() throws IOException{//쓰는 버퍼
		return new BufferedWriter(new FileWriter(PATH));
	}
	
	public static BufferedWriter getAppend() throws IOException{//추가로 쓰는 버퍼
		return new BufferedWriter(new FileWriter(PATH, true));
	}
	
	public static BufferedReader getReader() throws IOException{//읽는 버퍼
		return new BufferedReader(new FileReader(PATH));
	}
}



















