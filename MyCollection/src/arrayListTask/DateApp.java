package arrayListTask;

import java.util.ArrayList;

public class DateApp {
//	이상형 정보를 담을 DB
	public static ArrayList<Love> idealTypes = new ArrayList<Love>();

//	이상형 추가
	public void addIdealtype(Love love) {
		idealTypes.add(love);
	}

//	사용자가 입력한 나이인 이상형 목록 조회
	public ArrayList<Love> lookup(int age) {
		ArrayList<Love> idealTypeAge = new ArrayList<Love>();
		for (Love love : idealTypes) {
			if (love.getAge() == age) {
				idealTypeAge.add(love);
			}
		}
		return idealTypeAge;
	}

//	이상형의 나이 수정
//	이상형의 회원번호를 추가하고 번호로 조회한다.
	public void setAge(Love love) {
		
		for (int i = 0; i < idealTypes.size(); i++) {
			idealTypes.get(i).setNumber(i + 1);
		}
		for (Love l : idealTypes) {
			if (l.getNumber() == love.getNumber()) {
				idealTypes.set(idealTypes.indexOf(l), love);
				l.setAge(love.getAge());
			}
		}
	}

//	이상형의 나이 순으로 정렬하기 
	public void sortAge() {
		for (int i = 0; i < idealTypes.size(); i++) {
			for (int j = 0; j < idealTypes.size(); j++) {
				if (idealTypes.get(i).getAge() > idealTypes.get(j).getAge()) {
					Love temp = idealTypes.get(i);
					idealTypes.set(i, idealTypes.get(j));
					idealTypes.set(j, temp);
				}
			}
		}
	}

	public static void main(String[] args) {
		DateApp app = new DateApp();
		Love iu = new Love();
		Love ui = new Love();

		ui.setName("이지은");
		ui.setAge(30);
		iu.setName("아이유");
		iu.setAge(30);
		app.addIdealtype(ui);
		app.addIdealtype(iu);

		for (Love l : app.lookup(30)) {
			System.out.println(l.getName());
		}

		System.out.println(idealTypes.size());
		ui.getNumber();
		ui.setAge(31);
		app.setAge(ui);
		for (Love l : idealTypes) {
			System.out.println(l);
		}
	}

}
