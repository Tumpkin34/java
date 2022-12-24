package vo;

public class NameDTO {//테이블에 성별은 없던 데이터니까 DTO만듬 
	private String gender;
	private String name;
	private int ranking;
	private int population;
	
	public NameDTO() {;}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	private String insertComma(String data) {//콤마 붙혀주는 메소드
		String result = "";
		for (int i = 0; i < data.length(); i++) {
//			첫번째 반복이 아니고 3번째 인덱스 마다 ,를 앞에 붙혀줌 
			if(i % 3 == 0 && i != 0) {
				result = "," + result;
			}
//			result앞에 data를 역순으로 붙혀줌
			result = data.charAt(data.length() - 1 - i) + result;
		}
//		, 붙힌 문자열 리턴
		return result;
	}
	
	@Override
	public String toString() {
		String str = gender + "\t" + name + "\t" + ranking + "\t" + insertComma(String.valueOf(population));
		return str;
	}
}
