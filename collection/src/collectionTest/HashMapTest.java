package collectionTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class HashMapTest {
   public static void main(String[] args) {
//      아이디, 비밀번호, 이름, 나이
      HashMap<String, Object> userMap = new HashMap<String, Object>();
      
//      HashMap에 키값 밸류값 세트로 저장
      userMap.put("id", "hds1234");
      userMap.put("pw", "1234");
      userMap.put("name", "한동석");
      userMap.put("age", 20);
      
      System.out.println(userMap.size());//key value가 한쌍이니까 4개의 값이있다.
      System.out.println(userMap);//저장된 값을 가져온다.(toString이 재정의 되어있음)
      System.out.println(userMap.get("id"));//id에 해당하는 hds1234를 가져온다.
      
//      ---------------------------------------------밑에 부터는 나중에 공부(회사에서 분리해서 사용할 일이 없기때문에 천천히 공부)
//    한 쌍씩 가져오는 것 자바에서 한쌍은 entry라 표현한다.
      
//      entrySet을 통해 Entry타입(Key,value를 갖고있다.)의 Set을 리턴  
//      Set에 순서부여하기 위해 Iterator로 변환 iter가 이제 한 쌍씩 분리해서 가져온다.
      Iterator<Entry<String, Object>> iter = userMap.entrySet().iterator();
      
      while(iter.hasNext()) {//다음 값이 있으면 true
         Entry<String, Object> entry = iter.next();//Entry객체에 담아서 사용 또쓰려고 iter.next를 쓰면 다른게 불러와짐
         System.out.println(entry.getKey() + ": " + entry.getValue());//해당 객체의 key,value 가져옴
      }
      
//     keySet key값만 분리 
      Iterator<String> iter2 = userMap.keySet().iterator();//위와 같은 방식으로 key값 iterator타입으로 저장
      
      System.out.println("=====================");
      
      while(iter2.hasNext()) {
         System.out.println(iter2.next());//키값만 저장된 iter2를 출력
      }
      
      System.out.println("=====================");
      
      for (Object value : userMap.values()) {//컬렉션 타입은 이름을 s를 붙여 사용한다.
         System.out.println(value);//value분리
      }
      
   }
}












