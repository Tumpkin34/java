package arrayListTask;

public class Fruit {
//	과일이름, 과일가격
//	private
	private String fruitName;
	private int price;

//	기본 생성자
	public Fruit() {;}
	
	String getFruitName() {
		return fruitName;
	}

	void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	int getPrice() {
		return price;
	}

	void setPrice(int price) {
		this.price = price;
	}

	// toString()
	@Override
	public String toString() {
		return fruitName + "," + price;
	}

}
