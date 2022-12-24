package jobTask;

import java.util.Random;

public class Job {
	Random r = new Random();
	String name;
	String jobName;
	int money;
	int income;
	int life;
	int rating;
	int maxRating = 90;

	public Job(String name, String jobName, int money, int life) {
		this.name = name;
		this.jobName = jobName;
		this.money = money;
		this.life = life;
		this.rating = 90;
	}

	int work() {// 대성공 : 0, 성공 : 1, 실패 : 2, 고소 : 3
		if (rate(rating) == 1) {// 사기 성공
			rating -= 5;
			if (rate(20) == 1) {// 고소 당함
				income();
				agreement();// 합의
				return 3;// 고소
			}
			if (income()) {// 사기 대성공
				money += income * 1000000;
				return 0;
			}
			money += income * 100000;
			return 1;// 성공

		}
		return 2;// 실패

	}

	void sleep() {
		life += 2;

	}

	void goToPrison() {
		int healRate = 20;

		if (rating + 20 > maxRating) {
			rating = maxRating;
		} else {
			rating += healRate;
		}

	}

	void agreement() {
		money -= income * 100000;
	}

	int rate(int rate) {
		int[] persent = new int[100];
		for (int i = 0; i < rate; i++) {
			persent[i] = 1;
		}
		return persent[r.nextInt(persent.length)];
	}

	boolean income() {

		if (rate(10) == 1) {
			while (true) {
				if ((income = r.nextInt(13)) > 9) {
					return true;
				}
			}
		}
		while (true) {
			if ((income = r.nextInt(21)) > 9) {
				return false;
			}
		}
	}

}
