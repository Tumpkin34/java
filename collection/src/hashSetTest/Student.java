package hashSetTest;

public class Student {
   private int number;
   private String name;
   
   public Student() {;}

   public Student(int number, String name) {
      super();
      this.number = number;
      this.name = name;
   }

   public int getNumber() {
      return number;
   }

   public void setNumber(int number) {
      this.number = number;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
   
   @Override
   public boolean equals(Object obj) {
//	   주소비교 주소가 같으면 그필드가 그필드여서 검사할 필요도 없이 true
      if(obj == this) {
         return true;
      }
      
//      넘겨받은 주소가 업캐스팅된 Student타입이라면
      if(obj instanceof Student) {
         Student std = (Student) obj;//Student의 필드를 쓰려 다시 다운캐스팅
//         치자면 equals 앞의 주소의 값과 받아온 주소의 값을 비교
         if(this.number == std.number) {
            return true;//맞으면 true
         }
      }
      
      return false;//위의 Student타입이 아니면 볼것도없이 다른 타입이니까 false
   }
   
//   equals()를 재정의했다면, hashCode()도 재정의해야 한다.
//   hashCode()로 비교하는 자료구조가 여러 번 나타나기 때문에
//   equals()만 재정의하게 되면 원하는 값으로 비교하지 않고, 필드의 주소로 비교하는
//   상황이 발생한다. 따라서 equals()에서 비교한 값을 hashCode()의 리턴값으로 재정의해야 한다.
   @Override
   public int hashCode() {
	   //해시코드를 리턴하는 메소드를 해당객체의 number를 리턴하는 걸로 재정의
      return this.number;
   }
   
}

















