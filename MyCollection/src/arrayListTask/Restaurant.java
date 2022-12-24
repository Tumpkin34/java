package arrayListTask;

import java.util.ArrayList;

public class Restaurant {
//	음식 정보를 담을 DB선언
	public static ArrayList<Food> Foods = new ArrayList<Food>();

//	음식 추가
	public void addFood(Food food) {
		Foods.add(food);
	}

//	양식인지 중식인지 일식인지 한식인지 검사(문자열로 리턴)
//	예)스파게티 입력 시 "양식"리턴
	public String checkType(String name) {
		String temp = "";
		for (Food food : Foods) {
			if (food.getName().equals(name)) {
				temp = food.getType();
			}
		}
		return temp;
	}

//	사용자가 원하는 종류의 음식 목록 조회(종류는 한 가지만 입력가능)
//	예)한식 입력 시 한식만 조회
	public ArrayList<Food> lookupType(String type) {
		ArrayList<Food> lookupType = new ArrayList<Food>();
		for (Food food : Foods) {
			if (food.getType().equals(type)) {
				lookupType.add(food);
			}
		}
		return lookupType;
	}

//	음식의 종류 수정(가격 10%상승)
//	예)한식 -> 중식, 음식 가격은 10% 상승
	public void changeType(Food food) {
		for (Food existingFood : Foods) {
			if (existingFood.equals(food)) {
				food.setPrice(food.getPrice() / 10 + food.getPrice());
				Foods.set(Foods.indexOf(food), food);
				break;
			}
		}
	}

//	사용자가 원하는 종류의 음식 개수 조회
//	예) 불고기, 제육볶음, 파스타, 초밥
//	한식 입력 시 2개
	public int TypeNumber(String type) {
//		int count = 0;
//		for (Food food : Foods) {
//			if (food.getType().equals(type)) {
//				count++;// 전위형으로 하면 그 라인에서 뭔갈 한다고 생각할 수 있다.
//			}
//		}
//		return count;
		return lookupType(type).size();
	}
}
