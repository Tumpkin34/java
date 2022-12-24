package vo;

public class BoxOfficeVO {
	//테이블의 내용 대로 변수선언,초기화,getter,setter,toString재정의
	private int ranking;
	private String name;
	private String releaseDate;
	private long income;
	private int guestCount;
	private int screenCount;

	public BoxOfficeVO() {
		;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public long getIncome() {
		return income;
	}

	public void setIncome(long income) {
		this.income = income;
	}

	public int getGuestCount() {
		return guestCount;
	}

	public void setGuestCount(int guestCount) {
		this.guestCount = guestCount;
	}

	public int getScreenCount() {
		return screenCount;
	}

	public void setScreenCount(int screenCount) {
		this.screenCount = screenCount;
	}

//  숫자타입은 3자리마다 , 삽입   
	private String insertComma(String data) {//문자열을 받아오면 3자리마다 ,찍어주는 메소드
		String result = "";//,찍은 문자열
		for (int i = 0; i < data.length(); i++) {//받아온 문자열의 길이만큼 반복
			if (i % 3 == 0 && i != 0) {//3번째 자리일 때마다
				result = "," + result;//result 앞에 , 찍음
			}
			//마지막 인덱스부터 앞으로 연결
			result = data.charAt(data.length() - 1 - i) + result;
		}
		return result;//,찍은 문자열 리턴
	}

	@Override
	public String toString() {//toString 재정의
		String str = null;
		str = ranking + "\t" + name + "\t" + releaseDate + "\t" + insertComma(String.valueOf(income)) + "\t"
				+ insertComma(String.valueOf(guestCount)) + "\t" + insertComma(String.valueOf(screenCount));
		return str;
	}
}
