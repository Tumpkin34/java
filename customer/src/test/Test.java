package test;

import java.util.ArrayList;
import java.util.Scanner;

import dao.UserDAO;
import vo.UserVO;

public class Test {
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();

//      아이디 검사
//		public static final int DELETED_USER_CODE = -1;//탈퇴
//		public static final int RESTORED_USER_CODE = 0;//일반
//		public static final int DUPLICATED_ID_CODE = 1;//중복
//		public static final int ENABLED_ID_CODE = 2;//활성화
//      System.out.println(userDAO.checkId("hds"));//입력한 아이디 토대로 위에 결과들 리턴

//      회원가입
//      UserVO userVO = new UserVO();//회원 정보 담을 객체 선언
//      
//      ArrayList<UserVO> users = null;
//      Scanner sc = new Scanner(System.in);//입력메소드
//      String userId = null, userPassword = null;//입력할때 쓸 변수
//      int i = 0, status = 0;
//      
//      회원가입에 필요한 정보 입력
//      userVO.setUserId("lss");
//      userVO.setUserName("이순신");
//      userVO.setUserPassword("8888");
//      userVO.setUserPhoneNumber("01012341234");
//      userVO.setUserBirth("2008-12-04");
//      
//      if(userDAO.insert(userVO)) {//회원가입에 성공하면 true리턴
//         System.out.println("성공, 로그인페이지로 이동");
//         
//      }else {//회원가입에 실패시
//         System.out.println("실패");
//         users = userDAO.findUsersByUserPhoneNumber(userVO.getUserPhoneNumber());//같은번호로 저장된 정보들 ArrayList저장
//      	같은번호로 저장된 정보들 출력
//         for(UserVO user : users) {
//            System.out.print(++i + ". " + user.toString() + ", ");
//      		유저상태에 따른 출력메세지
//            System.out.println(user.getUserStatus() == UserDAO.DELETED_USER_CODE ? "복구하기" : "로그인하기");
//         }
//         
//         System.out.println("다음단계로 진행할 번호를 선택하세요.");
//         i = sc.nextInt() - 1;
//         if(users.get(i).getUserStatus() == UserDAO.DELETED_USER_CODE) {//입력한 번호가 탈퇴한 계정이라면
//            userDAO.restore(users.get(i).getUserNumber());//복구 메소드실행
//         }
//      	로그인 정보
//         System.out.print("아이디 : ");
//         userId = sc.next();
//         System.out.print("비밀번호 : ");
//         userPassword = sc.next();
//         
//		public static final int DELETED_USER_CODE = -1;//탈퇴
//		public static final int RESTORED_USER_CODE = 0;//일반
//		public static final int DUPLICATED_ID_CODE = 1;//중복
//		public static final int ENABLED_ID_CODE = 2;//활성화
//         status = userDAO.login(userId, userPassword);//로그인후 해당 계정이 어떤 계정인지 저장
//         
//         if(status != 0) {//0이 아니라는 것은 데이터에 등록된 계정이라는 것
//            if(status == UserDAO.DELETED_USER_CODE) {//탈퇴한 계정(-1)이라면
//               System.out.println("탈퇴된 계정입니다.");
//            }else {//
//               System.out.println("로그인 성공");
//            }
//         }else {//0이라는 것은 데이터에 가입된 계정이 아니라는 것
//            System.out.println("로그인 실패");
//         }
//      }

//      탈퇴 하기
//      int userNumber = userDAO.login("hds", "1234");//로그인 후 userNumber받아옴
//      if(userNumber > 0) {//1이상이라는 것은 로그인 성공
//         userDAO.delete(userNumber);//userNumber로 로우 삭제
//         System.out.println("회원 탈퇴 성공");
//      }

//      회원 번호로 회원 정보 전체 조회
//      System.out.println(userDAO.selectUser(1));//1이라는 userNumber인 회원 정보 객체 받고 toString해서 정보 조회

//      회원정보 수정
//		로그인해서 받아온 userNumber가 있는 객체 가져와서
//      UserVO userVO = userDAO.selectUser(userDAO.login("hgd", "1111"));
//		그 객체에 밑의 값으로 초기화
//      userVO.setUserName("길동st");
//      userDAO.update(userVO);//새로운 정보로 초기화된 객체 전달후 수정 메소드 실행
//      System.out.println("수정 성공");

//      아이디 찾기
//		전화번호로 찾은 Id들 정보 forEach로 전부 출력
//      userDAO.findId("01012341234").forEach(System.out::println);

	}
}
