package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import vo.UserVO;

public class UserDAO {
	
	private final int KEY = 3;//암호화 키
	
	public Connection connection; //연결 객체
	public PreparedStatement preparedStatement; //쿼리(SQL문) 객체
	public ResultSet resultSet; //결과 테이블 객체
	
//	아이디 중복검사
	public boolean checkId(String id) {//사용자가 입력한 id
//		USER_ID 컬럼에서 사용자가 입력한 id 검사
		String query = "SELECT COUNT(USER_ID) FROM TBL_USER WHERE USER_ID = ?";
		boolean check = false;
		try {
//			연결 객체 가져오기
			connection = DBConnecter.getConnection();
//			작성한 쿼리문을 preparedStatement에 전달
			preparedStatement = connection.prepareStatement(query);
//			? 채우기(좌에서 우로 1부터 1씩 증가)
			preparedStatement.setString(1, id);
//			쿼리 실행
			resultSet = preparedStatement.executeQuery();
//			결과 행 1개 가져오기
			resultSet.next();
//			결과 첫번째 열 1개 가져오기
//			1이라면 사용자가 입력한 아이디가 1개 조회된 것이기 때문에 중복된 아이디이다.
			check = resultSet.getInt(1) == 1;//COUNT(USER_ID)가 1이라면 true
			
		} catch (SQLException e) {
			System.out.println("checkId()에서 쿼리문 오류");
		} finally {
			try {
//				연결 객체 모두 닫기
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return check;//찾았는지 여부 리턴
	}
//	회원가입
	public void insert(UserVO userVO) {//회원정보가 담긴 객체받아옴
//		쿼리문 작성 받아온 객체를 토대로 테이블에 값 집어넣음
		String query = "INSERT INTO TBL_USER "
				+ "(USER_NUMBER, USER_ID, USER_NAME, USER_PASSWORD, USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH_DATE, USER_GENDER, USER_RECOMMENDER_ID, USER_JOB)"
				+ "VALUES(SEQ_USER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
//			연결 객체 가져오기
			connection = DBConnecter.getConnection();
//			쿼리문 전달
			preparedStatement = connection.prepareStatement(query);
//			? 채우기
			preparedStatement.setString(1, userVO.getUserId());
			preparedStatement.setString(2, userVO.getUserName());
			preparedStatement.setString(3, userVO.getUserPassword());
			preparedStatement.setString(4, userVO.getUserPhone());
			preparedStatement.setString(5, userVO.getUserNickname());
			preparedStatement.setString(6, userVO.getUserEmail());
			preparedStatement.setString(7, userVO.getUserAddress());
			preparedStatement.setString(8, userVO.getUserBirthDate());
			preparedStatement.setString(9, userVO.getUserGender());
			preparedStatement.setString(10, userVO.getUserRecommenderId());
			preparedStatement.setString(11, userVO.getUserJob());
//			결과값을 필요로 한게 아니기 때문에 Update
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("insert()에서 쿼리문 오류");
			
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
//	로그인
	public int login(String userId, String userPassword) {//사용자가 입력한 아이디, 비밀번호
//		사용자가 입력한 값과 해당하는 컬럼 비교 해서 USER_NUMBER가져옴
		String query = "SELECT USER_NUMBER FROM TBL_USER WHERE USER_ID = ? AND USER_PASSWORD = ?";
		int userNumber = 0;//찾은 유저 번호 담을 변수
		try {
//			연결객체 가져오기
			connection = DBConnecter.getConnection();
//			쿼리문 전달
			preparedStatement = connection.prepareStatement(query);
//			? 채음
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userPassword);
//			조회된 결과 저장
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {//조회된 값이 있을 때 실행
//				조회된값 저장
				userNumber = resultSet.getInt("USER_NUMBER");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("login() 쿼리문 오류");
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return userNumber;//저장한 유저번호 리턴
	}
//	암호화
	public String encrypt(String password) {//이전에 여러번 나왔기에 생략
		String encryptedPassword = "";
		for (int i = 0; i < password.length(); i++) {
			encryptedPassword += (char)(password.charAt(i) * KEY);
		}
		return encryptedPassword;
	}
	
//	회원탈퇴
	public void delete(int userNumber) {//유저번호를 받음
//		받아온 유저번호와 일치하는 컬럼 찾아서 지우는 쿼리문
		String query = "DELETE FROM TBL_USER WHERE USER_NUMBER = ?";
		try {
//			연결 객체 가져오기 
			connection = DBConnecter.getConnection();
//			쿼리문 전달
			preparedStatement = connection.prepareStatement(query);
//			? 채움
			preparedStatement.setInt(1, userNumber);
//			조회하는게 아니어서 Update
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("delete() 쿼리문 오류");
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
//	아이디 찾기
	public String findId(String userPhone) {//핸드폰 번호 받아옴
		String userId = null;
//		받은 핸드폰 번호와 일치하는 컬럼에서 찾고 아이디 보여줌		
		String query = "SELECT USER_ID FROM TBL_USER WHERE USER_PHONE = ?";
		try {
//			연결 객체 가져오기
			connection = DBConnecter.getConnection();
//			쿼리문 전달
			preparedStatement = connection.prepareStatement(query);
//			? 채움
			preparedStatement.setString(1, userPhone);
//			조회된 결과 저장
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {//조회된 결과가 있다면
				userId = resultSet.getString(1);//userId에 저장
			}
			
		} catch (SQLException e) {
			System.out.println("findId() 쿼리문 오류");
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return userId;//찾은 아이디 리턴
	}
	
//	비밀번호 변경
	public void updateUserPassword(String userId, String userPassword) {//아이디 ,비밀번호 받음
//		USER_ID컬럼에서 받은 아이디와 같다면 해당 USER_PASSWORD를 받아온 값으로 수정
		String query = "UPDATE TBL_USER SET USER_PASSWORD = ? WHERE USER_ID = ?";
		try {
//			연결 객체 전달
			connection = DBConnecter.getConnection();
//			쿼리문 전달
			preparedStatement = connection.prepareStatement(query);
//			? 채움
			preparedStatement.setString(1, userPassword);
			preparedStatement.setString(2, userId);
//			저장할게 없기에 그냥 Update
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("updateUserPassword() 쿼리 오류");
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
//	회원정보 수정
	public void update(UserVO userVO) {//수정된 정보가 담긴 객체 받음
//		받아온 객체에 유저 번호가 같은 로우 찾고 해당 로우에 받아온 객체의 정보들로 수정해줌
		String query = "UPDATE TBL_USER "
				+ "SET USER_NAME=?, USER_PASSWORD=?, USER_PHONE=?, USER_NICKNAME=?, USER_ADDRESS=?, USER_BIRTH_DATE=?, USER_GENDER=? , USER_RECOMMENDER_ID=?, USER_JOB=?"
				+ "WHERE USER_NUMBER = ?";
		
		try {
//			연결 객체 가져오기
			connection = DBConnecter.getConnection();
//			쿼리문 전달
			preparedStatement = connection.prepareStatement(query);
//			? 채우기
			preparedStatement.setString(1, userVO.getUserName());
			preparedStatement.setString(2, userVO.getUserPassword());
			preparedStatement.setString(3, userVO.getUserPhone());
			preparedStatement.setString(4, userVO.getUserNickname());
			preparedStatement.setString(5, userVO.getUserAddress());
			preparedStatement.setString(6, userVO.getUserBirthDate());
			preparedStatement.setString(7, userVO.getUserGender());
			preparedStatement.setString(8, userVO.getUserRecommenderId());
			preparedStatement.setString(9, userVO.getUserJob());
			preparedStatement.setInt(10, userVO.getUserNumber());
//			조회할게 아니기에 Update
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("update() 쿼리 오류");
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
//	회원정보 조회
	public UserVO selectUser(int userNumber) {//유저 번호 가져옴
//		USER_NUMBER컬럼에 받아온 유저 번호 객체와 비교후 정보 조회
		String query = "SELECT USER_NUMBER, USER_ID, USER_NAME, USER_PASSWORD, USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH_DATE, USER_GENDER, USER_RECOMMENDER_ID, USER_JOB FROM TBL_USER "
				+ "WHERE USER_NUMBER = ?";
//		날짜 형식 객체
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int i = 0;//밑에서 숫자로 일일히 안쓰고 변수 선언해서 ++로 올려주는 방법도 있다.
		UserVO userVO = new UserVO();//조회된값 담을 객체 만들기
		try {
//			연결 객체 가져오기
			connection = DBConnecter.getConnection();
//			쿼리문 작성
			preparedStatement = connection.prepareStatement(query);
//			? 채움
			preparedStatement.setInt(1, userNumber);
//			조회된 주소값 저장
			resultSet = preparedStatement.executeQuery();
//			다음 로우로 포커스
			resultSet.next();
			
//			해당 로우 값들 다 뽑아서 userVO에 저장
			userVO.setUserNumber(resultSet.getInt(++i));
			userVO.setUserId(resultSet.getString(++i));
			userVO.setUserName(resultSet.getString(++i));
			userVO.setUserPassword(resultSet.getString(++i));
			userVO.setUserPhone(resultSet.getString(++i));
			userVO.setUserNickname(resultSet.getString(++i));
			userVO.setUserEmail(resultSet.getString(++i));
			userVO.setUserAddress(resultSet.getString(++i));
			try {userVO.setUserBirthDate(sdf.format(sdf.parse(resultSet.getString(++i))));} catch (Exception e) {;}
			userVO.setUserGender(resultSet.getString(++i));
			userVO.setUserRecommenderId(resultSet.getString(++i));
			userVO.setUserJob(resultSet.getString(++i));
			
		} catch (SQLException e) {
			System.out.println("updateUser() 쿼리문 오류");
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return userVO;//조회된 값 저장된 객체 리턴
	}
	
	
//	추천수
	public int getTotalOfRecommender(String userId) {//아이디 받아옴
//		추천인과 받은 아이디 비교후 같은 것들 카운트
		String query = "SELECT COUNT(USER_RECOMMENDER_ID) FROM TBL_USER WHERE USER_RECOMMENDER_ID = ?";
//		리턴한 변수
		int count = 0;
		try {
//			연결 객체 가져오기 
			connection = DBConnecter.getConnection();
//			쿼리문 작성
			preparedStatement = connection.prepareStatement(query);
//			? 채움
			preparedStatement.setString(1, userId);
//			조회된 결과 저장
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
//				추천수 카운트한거 저장
				count = resultSet.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return count;//저장된 카운트 리턴
	}
	
//	나를 추천한 사람
	public ArrayList<UserVO> selectRecommenders(String userId){//아이디 받음
//		추천인과 비교 후 같은 사람 정보 조회
		String query = "SELECT USER_NUMBER, USER_ID, USER_NAME, USER_PASSWORD, USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH_DATE, USER_GENDER, USER_RECOMMENDER_ID, USER_JOB FROM TBL_USER "
				+ "WHERE USER_RECOMMENDER_ID = ?";
//		추천한 사람 정보가 담긴 객체를 담을 list
		ArrayList<UserVO> recommenders = new ArrayList<>();
//		날짜 형식 지정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		int i = 0;
		try {
//			연결 객체 가져오기
			connection = DBConnecter.getConnection();
//			쿼리문 전달
			preparedStatement = connection.prepareStatement(query);
//			? 채움
			preparedStatement.setString(1, userId);
//			조회된 결과 저장
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				i = 0;//숫자로 안쓰고 i로 했으니까 반복 돌때마다 초기화
//				조회된값 담을 객체 선언
				UserVO userVO = new UserVO();
//				조회된값으로 초기화
				userVO.setUserNumber(resultSet.getInt(++i));
				userVO.setUserId(resultSet.getString(++i));
				userVO.setUserName(resultSet.getString(++i));
				userVO.setUserPassword(resultSet.getString(++i));
				userVO.setUserPhone(resultSet.getString(++i));
				userVO.setUserNickname(resultSet.getString(++i));
				userVO.setUserEmail(resultSet.getString(++i));
				userVO.setUserAddress(resultSet.getString(++i));
//				가끔null이라던가 하는 이유로 형식을 못만들어주는 경우를 try/catch로 잡음
				try {userVO.setUserBirthDate(sdf.format(sdf.parse(resultSet.getString(++i))));} catch (Exception e) {;}
				userVO.setUserGender(resultSet.getString(++i));
				userVO.setUserRecommenderId(resultSet.getString(++i));
				userVO.setUserJob(resultSet.getString(++i));
				
//				초기화된 객체 저장
				recommenders.add(userVO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return recommenders;//추천한 사람 정보가 담긴 객체를 담을 list리턴
	}
//	내가 추천한 사람
	public UserVO getMyRecommender(String userId) {//아이디 받음
//		받아온 아이디와 USER_ID컬럼에 같은 값 찾고 찾은로우의 RECOMMENDER_ID 조회하고 조회된 추천인과 USER_ID컬럼을 비교하여 같은 사람의 정보조회 
		String query = "SELECT USER_NUMBER, USER_ID, USER_NAME, USER_PASSWORD, USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH_DATE, USER_GENDER, USER_RECOMMENDER_ID, USER_JOB " +
				"FROM TBL_USER WHERE USER_ID = " + 
				"(" +
					"SELECT USER_RECOMMENDER_ID FROM TBL_USER " + 
					"WHERE USER_ID = ?" +
				")";
//		날짜 형식 지정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		조회된 값 저장할 때 쓸 객체선언
		UserVO userVO = new UserVO();

		int i = 0;
		try {
//			연결 객체 가져오기
			connection = DBConnecter.getConnection();
//			쿼리문 전달
			preparedStatement = connection.prepareStatement(query);
//			? 채움
			preparedStatement.setString(1, userId);
//			조회된 값 저장
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				//조회된 값으로 userVO 초기화
				userVO.setUserNumber(resultSet.getInt(++i));
				userVO.setUserId(resultSet.getString(++i));
				userVO.setUserName(resultSet.getString(++i));
				userVO.setUserPassword(resultSet.getString(++i));
				userVO.setUserPhone(resultSet.getString(++i));
				userVO.setUserNickname(resultSet.getString(++i));
				userVO.setUserEmail(resultSet.getString(++i));
				userVO.setUserAddress(resultSet.getString(++i));
//				가끔null이라던가 하는 이유로 형식을 못만들어주는 경우를 try/catch로 잡음
				try {userVO.setUserBirthDate(sdf.format(sdf.parse(resultSet.getString(++i))));} catch (Exception e) {;}
				userVO.setUserGender(resultSet.getString(++i));
				userVO.setUserRecommenderId(resultSet.getString(++i));
				userVO.setUserJob(resultSet.getString(++i));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return userVO;//초기화된 객체 리턴
	}
}



















