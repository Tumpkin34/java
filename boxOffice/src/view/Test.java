package view;

import java.io.IOException;

import dao.BoxOfficeDAO;
import vo.BoxOfficeVO;

public class Test {
	public static void main(String[] args) throws IOException {
		BoxOfficeDAO boxOfficeDAO = new BoxOfficeDAO();//객체화
		boxOfficeDAO.selectAll().forEach(System.out::println);//리턴받은 ArrayList Stream으로 모든 영화정보 출력
		
//		boxOfficeDAO.select("0").forEach(System.out::println);//영화제목에 0이 포함된 영화 목록 출력
		
//		if(boxOfficeDAO.delete(7)) {//7위 영화 삭제하고 삭제 성공하면 리턴받는 true로 실행
//			System.out.println("삭제 성공");
//		}
		
//		BoxOfficeVO boxOfficeVO = boxOfficeDAO.select("아바타").get(0);//아바타가 포함된 영화들 찾은후 그중 0번째 영화 가져온후 VO객체에 담음
//		boxOfficeVO.setRanking(8);//랭킹을 8위로 바꿈
//		boxOfficeVO.setName("아바타2");//이름을 아바타2로 바꿈
		
//		if(boxOfficeDAO.update(boxOfficeVO)) {//바뀐 값의 VO로 update
//			System.out.println("수정 성공");
//		}else {
//			System.out.println("수정 실패");
//		}
		
//		영화 정보 만듬
//		BoxOfficeVO boxOfficeVO = new BoxOfficeVO();
//		boxOfficeVO.setRanking(7);
//		boxOfficeVO.setName("황지수짱2");
//		if(boxOfficeDAO.add(boxOfficeVO)) {//만든 영화 정보 추가
//			System.out.println("추가 성공");
//		}
	}
}
