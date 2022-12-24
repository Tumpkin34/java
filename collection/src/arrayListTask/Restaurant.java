package arrayListTask;

import java.util.ArrayList;
import java.util.Iterator;

public class Restaurant {
//   음식 정보를 담을 DB 선언
   public static ArrayList<Food> foods = new ArrayList<Food>();
      
//   음식 추가
   public void add(Food food) {
      foods.add(food);
   }
   
//   양식인지 중식인지 일식인지 한식인지 검사(문자열로 리턴)
//   예)스파게티 입력 시 "양식"리턴
   public String checkKinds(String name) {//음식 이름 받아옴
      for (Food food : foods) {//foods다 꺼냄
         if(food.getName().equals(name)) {//foods의 주소의 이름과 받아온 이름 비교
            return food.getKinds();//찾은 foods의 주소의 타입 문자열로 리턴
         }
      }
      return null;//못찾았을 경우
   }
   
//   사용자가 원하는 종류의 음식 목록 조회(종류는 한 가지만 입력가능)
//   예)한식 입력 시 한식만 조회
   public ArrayList<Food> getFoods(String kinds){//음식 종류 받아옴
      ArrayList<Food> results = new ArrayList<Food>();//찾은 목록 저장할 ArrayList
      for (Food food : foods) {//foods다 꺼냄
         if(food.getKinds().equals(kinds)) {//꺼낸 주소의 음식종류와 받아온 음식종류 비교
            results.add(food);//찾았다면 찾은 목록에 저장
         }
      }
      return results;//목록주소 리턴
   }
   
//   음식의 종류 수정(가격 10% 상승)
//   예)한식 -> 중식, 음식 가격은 10% 상승
   public void updateKinds(Food food) {//수정된 주소 받아옴
      for (Food temp : foods) {//foods다 꺼냄
         if(temp.getName().equals(food.getName())) {//foods에 저장된 주소안에 이름과 받아온 주소안의 이름이 같은지 확인
            temp.setKinds(food.getKinds());//temp주소에 종류에 받아온 종류 덮어씀 main에서 해당 필드주소에 직접 접근해서 같은 값일 것임
            temp.setPrice((int)(temp.getPrice() * 1.1));//10%상승한 값 저장
            break;
         }
      }
   }
   
//   사용자가 원하는 종류의 음식 개수 조회
//   예) 불고기, 제육볶음, 파스타, 초밥
//   한식 입력 시 2개
//   public int getCount() {
   public int searchFood(String kinds) {//음식 종류 받아옴
//      int count = 0;//세어주는 변수
//      for (Food food : foods) {
//         if(food.getKinds().equals(kinds)) {//ArrayList에 저장된 주소에 저장된 음식 종류와 받아온 음식종류가 같으면
//            count ++;//count +1
//         }
//      }
//      return count;//샌 카운트 리턴
      return getFoods(kinds).size();//getFoods메소드로 음식 목록 찾아오면 그 목록의 길이를 리턴
   }
}
