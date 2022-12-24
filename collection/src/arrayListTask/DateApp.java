package arrayListTask;

import java.util.ArrayList;
import java.util.Collections;

public class DateApp {
//	이상형 정보를 담을 DB
	public static ArrayList<Love> loves = new ArrayList<Love>();

//	이상형 추가
	public void add(Love love) {
		loves.add(love);
	}

//	사용자가 입력한 나이인 이상형 목록 조회
	public ArrayList<Love> getList(int age) {//나이 받아옴
		ArrayList<Love> selected = new ArrayList<Love>();//해당 나이인 이상형들 저장할 ArrayList

		for (Love love : loves) {//loves다 뽑아옴
			if (love.getAge() == age) {//뽑아온 주소의 나이를 뽑아오고 매개변수로 받아온 나이와 비교
				selected.add(love);//찾았으면 위의 해당나이 이상형목록에 저장
			}
		}
		return selected;//목록 리턴
	}

//	이상형의 나이 수정
//	이상형의 번호를 추가하고 번호로 조회한다.
//	이름이 똑같으면 어떻게 수정하지?
//	구분점이 필요하다, 고유한 값이 필요하다
	public void update(Love love) {// love의 주소를 받아온다.
		for (Love db : loves) {// 빠른for문을 통해 loves ArrayList안의 주소값들을 불러온다.
			if (db.getNumber() == love.getNumber()) {// ArrayList안에있던 주소의 번호와 매개변수로 받아온 주소의 넘버와 비교
//				객체 통채로 변경
				loves.set(loves.indexOf(db), love);// ArrayList의 위의 주소가 들어있는 인덱스에 값을 매개변수로 받아온 주소값으로 바꿔준다.
//				기존 객체의 필드 변경
//				db.setAge(love.getAge());//ArrayList의 주소의 나이를 받아온 매개변수의 주소의 나이로 바꿔준다. 
				break;
			}
		}
	}

//	이상형의 나이 순으로 정렬하기
	public void sort() {
//		이상형의 나이만 담을 ArrayList
		ArrayList<Integer> ages = new ArrayList<Integer>();

//		오름차순으로 정렬된 이상형 정보를 담을 ArrayList
		ArrayList<Love> loves = new ArrayList<Love>();

		for (Love love : DateApp.loves) {
//			이상형의 나이만 담아주기
			ages.add(love.getAge());
		}

//		나이 오름차순 정렬
		Collections.sort(ages);

		for (int i = 0; i < DateApp.loves.size(); i++) {
//			정렬된 나이 ArrayList에서 첫번째 나이부터 비교
			for (Love love : DateApp.loves) {
				if (ages.get(i) == love.getAge()) {
//				찾았다면 순서대로 loves에 담아주기
					loves.add(love);
				}
			}
		}
//		오름차순으로 정렬된 전체 정보를 DB에 저장
		DateApp.loves = loves;
	}
}
