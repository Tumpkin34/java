package objectTest;

import java.util.Random;

class Student {
	//전역변수 선언
   int number;
   String name;
   
   public Student() {;}//기본생성자

   public Student(int number, String name) {//초기화 생성자
      super();
      this.number = number;
      this.name = name;
   }
   
   @Override
   public String toString() {//toString 재정의
      return number + ", " + name;//번호와 이름 문자열 리턴
   }
}

public class ToStringTest {
   public static void main(String[] args) {
      Random r = new Random();
      System.out.println(r);// 그동안 객체명을 쓰면 toString이 생략되어 나왔었다.
      System.out.println(r.toString());//toString메소드는 경로@주소값이 문자열로 나왔다 이렇게 쓸일이 별로 없어 대부분 재정의 하여 사용한다.
      
      Student std = new Student(1, "황지수");//1과 이름으로 초기화해준다.
      System.out.println(std);//toString을 이름과 번호가 연결된 문자열이 리턴된걸 출력한다.
   }
}




