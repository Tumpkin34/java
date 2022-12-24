package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import vo.NameVO;

public class NameDAO {

	public ArrayList<NameVO> maleSetObject() throws IOException {// 남아 vo객체로 리턴
		BufferedReader br = DBConnection.readMaleName();
		NameDAO dao = new NameDAO();
		NameVO nameVO = null;
		ArrayList<NameVO> nameInfos = new ArrayList<NameVO>();
		String line = "";
		while ((line = br.readLine()) != null) {
			String[] temp = line.split("\t");
			nameVO = new NameVO();
			nameVO.setName(temp[0]);
			nameVO.setRank(dao.removeComma(temp[1]));
			nameVO.setNameNumber(dao.removeComma(temp[2]));
			nameInfos.add(nameVO);
		}
		return nameInfos;
	}

	public ArrayList<NameVO> femaleSetObject() throws IOException {// 여아 vo객체로 리턴
		BufferedReader br = DBConnection.readFemaleName();
		NameDAO dao = new NameDAO();
		NameVO nameVO = null;
		ArrayList<NameVO> nameInfos = new ArrayList<NameVO>();
		String line = "";
		while ((line = br.readLine()) != null) {
			String[] temp = line.split("\t");
			nameVO = new NameVO();
			nameVO.setName(temp[0]);
			nameVO.setRank(dao.removeComma(temp[1]));
			nameVO.setNameNumber(dao.removeComma(temp[2]));
			nameInfos.add(nameVO);
		}
		return nameInfos;
	}

	public void merge() throws IOException {// 여자,남자이름 데이터 병합
		BufferedWriter bw = DBConnection.writeMerge();
		ArrayList<NameVO> total = new ArrayList<NameVO>();
		ArrayList<NameVO> a = femaleSetObject();
		ArrayList<NameVO> b = maleSetObject();
		String temp = "";

		total.addAll(a);
		total.addAll(b);

		for (NameVO nameVO : total) {
			temp += nameVO + "\n";
		}
		bw.write(temp);
		bw.close();
	}

//	public void merge() throws IOException {
//		BufferedWriter bw = DBConnection.writeMerge();
//		BufferedReader brXX = DBConnection.readFemaleName();
//
//		String temp = "";
//
//		String line = "";
//		while ((line = brXX.readLine()) != null) {
//			temp += "F\t" + line + "\n";
//		}
//		BufferedReader brXY = DBConnection.readMaleName();
//		while ((line = brXY.readLine()) != null) {
//			temp += "M\t" + line + "\n";
//		}
//
//		bw.write(temp);
//		bw.close();
//	}

	public void updateRanking() throws IOException {// 병합된 파일에서 랭킹 수정
		BufferedReader br = DBConnection.ReadMerge();
		NameDAO dao = new NameDAO();
		NameVO nameVO = null;
		ArrayList<Integer> nameNumbers = new ArrayList<Integer>();
		ArrayList<NameVO> infos = new ArrayList<>();
		String line = "", updateInfo = "";
		String[] temp = null;
		int rankCount = 0, count = 0;
		while ((line = br.readLine()) != null) {
			nameVO = new NameVO();
			temp = line.split("\t");
			nameNumbers.add(dao.removeComma(temp[2]));
			nameVO.setName(temp[1]);
			nameVO.setRank(dao.removeComma(temp[1]));
			nameVO.setNameNumber(dao.removeComma(temp[2]));
			infos.add(nameVO);
		}
		Collections.sort(nameNumbers);
		Collections.reverse(nameNumbers);

		for (int i = 0; i < nameNumbers.size(); i++) {
			rankCount++;
			count = 0;
			for (int j = 0; j < infos.size(); j++) {
				if (nameNumbers.get(i) == infos.get(j).getNameNumber()) {
					infos.get(j).setRank(rankCount-count);
					count++;
					updateInfo += infos.get(j) + "\n";
				}
			}

		}

		System.out.println(updateInfo);
	}

	public int removeComma(String str) {// 쉼표 삭제
		int temp = 0;
		temp = Integer.parseInt(str.replace(",", ""));
		return temp;
	}
	
	
}
