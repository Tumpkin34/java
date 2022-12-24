package arrayListTask;

public class Test3 {
   public static void main(String[] args) {
//	   객체화
      Restaurant restaurant = new Restaurant();

//      food에 주소 생성
      Food food = new Food();
//      food주소에 이름, 가격, 종류 저장
      food.setName("치즈돈까스");
      food.setPrice(8500);
      food.setKinds("일식");
//      foods ArrayList에 위에 저장한 음식 주소 추가
      Restaurant.foods.add(food);
      
//      food가 새로운 주소 생성
      food = new Food();
      food.setName("한우갈비찜");
      food.setPrice(12000);
      food.setKinds("한식");
      
      Restaurant.foods.add(food);

      food = new Food();
      
      food.setName("잡채찜닭돼지고기두루치기");
      food.setPrice(1500);
      food.setKinds("한식");
      
      Restaurant.foods.add(food);
      
//      System.out.println(restaurant.checkKinds("한우갈비찜"));
//      System.out.println(restaurant.checkKinds("치즈돈까스"));
      
//      for (Food selected : restaurant.getFoods("한식")) {//빠른 for문
//         System.out.println(selected);
//      }
      
      food.setKinds("일식");//마지막에 추가한 잡채찜닭돼지고기두루치기의 종류를 바꿈
      restaurant.updateKinds(food);//바뀌 주소를 updateKinds메소드로 보냄
//      System.out.println(Restaurant.foods);
      
      System.out.println(restaurant.searchFood("한식"));//searchFood메소드에 매개변수에 한식 보냄
   }
}
