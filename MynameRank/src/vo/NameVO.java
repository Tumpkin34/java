package vo;

public class NameVO {
	private String name;
	private int rank;
	private int nameNumber;

	public NameVO() {
		;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getNameNumber() {
		return nameNumber;
	}

	public void setNameNumber(int nameNumber) {
		this.nameNumber = nameNumber;
	}

	@Override
	public String toString() {
		String str = name + "\t" + rank + "\t" + nameNumber;
		return str;
	}
}
