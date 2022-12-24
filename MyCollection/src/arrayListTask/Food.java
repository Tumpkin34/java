package arrayListTask;

public class Food {
//	이름, 가격, 종류(한식, 중식, 일식, 양식)
	String name;
	int price;
	String type;

//	private
//	기본생성자
	public Food() {
		;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getPrice() {
		return price;
	}

	void setPrice(int price) {
		this.price = price;
	}

	String getType() {
		return type;
	}

	void setType(String type) {
		this.type = type;
	}

	// toString
	@Override
	public String toString() {
		return name + "," + price + "," + type;
	}
}
