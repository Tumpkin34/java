package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

import vo.BoyVO;
import vo.GirlVO;
import vo.NameDTO;

public class NameDAO {
//	어디에도 쓰니까 전역으로 ArrayList선언
	public ArrayList<GirlVO> girls;
	public ArrayList<BoyVO> boys;

	// 병합
	public void merge(String path1, String path2, String path3) throws IOException {// 외부에서 병합할 txt받아오고 병합해서 저장할 txt도
																					// 받아옴
//		버퍼 읽는 기능으로 열어줌
		BufferedReader boyReader = DBConnecter.getReader(path1);
		BufferedReader girlReader = DBConnecter.getReader(path2);

		BufferedWriter bufferedWriter = null;

//		각 VO객체 가져오기 위해 객체화
		BoyDAO boyDAO = new BoyDAO();
		GirlDAO girlDAO = new GirlDAO();

//		ArrayList도 객체화
		girls = new ArrayList<GirlVO>();
		boys = new ArrayList<BoyVO>();

//		readLine을 또 쓰면 다음 줄을 가져오기 때문에 line변수에 담음, temp 병합된 데이터를 담을 변수
		String line = null, temp = "";

//		다음줄 가져왔을 때 null 뜰 때 까지 반복
		while ((line = boyReader.readLine()) != null) {
//			뽑아온 줄에 \n붙혀서 temp에 저장
			temp += line + "\n";
//			DAO에 line을 VO객체로 리턴해서 VO객체들 저장
			boys.add(boyDAO.setObject(line));
		}

//		버퍼는 동시에 못여니까 열려있는 버퍼 닫아줌
		boyReader.close();

		while ((line = girlReader.readLine()) != null) {
			temp += line + "\n";
			girls.add(girlDAO.setObject(line));
		}

//		버퍼는 동시에 못여니까 열려있는 버퍼 닫아줌
		girlReader.close();

//		병합된 거 저장할 txt버퍼 열어주고
		bufferedWriter = DBConnecter.getWriter(path3);
//		txt에 쓰고
		bufferedWriter.write(temp);
//		버퍼 닫음
		bufferedWriter.close();
	}

	// 랭킹 수정
	public void updateRanking(String path) throws IOException {
		BufferedWriter bufferedWriter = DBConnecter.getWriter(path);
		ArrayList<Object> datas = new ArrayList<Object>();
		ArrayList<Integer> populations = new ArrayList<Integer>();
		HashSet<Integer> populationSet = null;
		String temp = "";
		int ranking = 1, count = 0;

//		datas에 boys와 girls정보 둘다 넣음
		datas.addAll(boys);
		datas.addAll(girls);

//		boys와 girls의 이름수만 populations에 저장
		boys.stream().map(v -> v.getPopulation()).forEach(populations::add);
		girls.stream().map(v -> v.getPopulation()).forEach(populations::add);

//		populations를 hashset에 집어 넣을으로써 중복된 값 제거 후 다시 ArrayList에 담음
		populationSet = new HashSet<Integer>(populations);
		populations = new ArrayList<Integer>(populationSet);

//		stream을 통해 populations를 내림차순으로 정렬후 List로 바꾼후 저장
		populations = (ArrayList<Integer>) populations.stream().sorted(Collections.reverseOrder())
				.collect(Collectors.toList());

		for (Integer population : populations) {//내림차순으로 정렬된 populations반복
			count = 0;
			for (Object obj : datas) {//남아,여아 모든 이름 저장된 datas반복
				if (obj instanceof BoyVO) {//datas에서 꺼낸 값이 BoyVO타입이라면 실행
					BoyVO boyVO = (BoyVO) obj;//다운캐스팅으로 없어졌던 VO클래스의 필드 살림
					if (population == boyVO.getPopulation()) {//내림차순된 이름수와 다운캐스팅한 이름수비교
//						테이블에 없던 gender를 가지고있는 nameDTO에 정보들 초기화
						NameDTO nameDTO = new NameDTO();
						nameDTO.setGender("B");
						nameDTO.setName(boyVO.getName());
						nameDTO.setRanking(ranking);//이름 순위가같다면 ranking은 같음
						nameDTO.setPopulation(population);

						temp += nameDTO + "\n";//저장된 주소 toString으로 재정의된 값 temp에 연결
						count++;//이름 순위가 같은 만큼 카운트 공동순위에 사용됨 
					}
				}

				if (obj instanceof GirlVO) {//위와 같은 동작
					GirlVO girlVO = (GirlVO) obj;
					if (population == girlVO.getPopulation()) {
						NameDTO nameDTO = new NameDTO();
						nameDTO.setGender("G");
						nameDTO.setName(girlVO.getName());
						nameDTO.setRanking(ranking);
						nameDTO.setPopulation(population);

						temp += nameDTO + "\n";
						count++;
					}
				}
			}
			if (count > 1) {//카운트가 2이상일때는 공동순위가 있다는 말
				ranking += count - 1;//공동순위개수만큼 랭킹에서 빼고 밑에서 상관없이 ranking이 오르기에 -1
			}
			ranking++;
		}

		bufferedWriter.write(temp);
		bufferedWriter.close();
	}
}
