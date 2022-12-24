package dao;

import vo.BoyVO;

public class BoyDAO {
	public BoyVO setObject(String line) {
		String[] datas = line.split("\t");//메모장에서 뽑아온 한줄을 각 정보로 나눔
		BoyVO boyVO = new BoyVO();//boyVO객체화
		
		//각 정보 초기화
		boyVO.setName(datas[0]);
		boyVO.setRanking(Integer.valueOf(removeComma(datas[1])));
		boyVO.setPopulation(Integer.valueOf(removeComma(datas[2])));
		
		return boyVO;//초기화된 주소 리턴
	}
	
	public String removeComma(String data) {
		return data.replaceAll(",", "");//메소드로 ,를 빈문자열로 바꿔줌
	}
}
