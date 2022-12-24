package arrayListTask;

import java.util.Scanner;

public class P1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Restaurant res = new Restaurant();
		String name = "", type = "";
		int price = 0, choice = 0;

		
		Food food = new Food();
		food.setName("불고기");
		food.setPrice(1000);
		food.setType("한식");
		res.addFood(food);
		food = new Food();
		food.setName("제육");
		food.setPrice(1500);
		food.setType("한식");
		res.addFood(food);
		food = new Food();
		food.setName("파스타");
		food.setPrice(2000);
		food.setType("양식");
		res.addFood(food);
		food = new Food();
		food.setName("초밥");
		food.setPrice(2500);
		food.setType("일식");
		res.addFood(food);
		food = new Food();
		food.setName("딤섬");
		food.setPrice(3000);
		food.setType("중식");
		res.addFood(food);

		for (Food f : Restaurant.Foods) {
			System.out.println(f);
		}

//		System.out.println("원하는 음식 종류 : ");
//		type = sc.next();
//		System.out.println(res.TypeNumber(type));

		System.out.println("종류 수정할 음식 : ");
		name = sc.next();
		System.out.println("수정할 타입 : ");
		type = sc.next();
		for (Food f : Restaurant.Foods) {
			if (f.getName().equals(name)) {
				f.setType(type);
				res.changeType (f);
			}
		}
		for (Food f : Restaurant.Foods) {
			System.out.println(f);
		}

//		System.out.println("종류 : ");
//		type = sc.next();
//		for(Food food : res.lookupType(type)) {
//			System.out.println(food.getName());
//		}

//		System.out.println("음식 : ");
//		name = sc.next();
//		System.out.println(res.checkType(name));
	}
}
