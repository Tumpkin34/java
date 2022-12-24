package arrayListTask;

public class Love {
//	이름, 나이
//	private
	private int number;
	private String name;
	private int age;

//	기본 생성자
	public Love() {
		;
	}

	int getNumber() {
		return number;
	}

	void setNumber(int number) {
		this.number = number;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}

//	toString()
	@Override
	public String toString() {
		return name + "," + age;
	}
}
