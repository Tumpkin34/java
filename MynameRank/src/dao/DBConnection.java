package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DBConnection {
	public static BufferedWriter writeFemaleName() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("femaleName.txt"));
		return bw;
	}
	public static BufferedReader readFemaleName() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("femaleName.txt"));
		return br;
	}
	public static BufferedWriter writeMaleName() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("maleName.txt"));
		return bw;
	}
	public static BufferedReader readMaleName() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("maleName.txt"));
		return br;
	}
	public static BufferedWriter writeMerge() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("merge.txt"));
		return bw;
	}
	public static BufferedReader ReadMerge() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("merge.txt"));
		return br;
	}
	

}
