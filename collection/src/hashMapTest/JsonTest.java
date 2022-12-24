package hashMapTest;

import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonTest {

	public static void main(String[] args) {
		HashMap<String, Object> userMap = new HashMap<String, Object>();
		JSONObject userJSON = null;
		JSONArray users = new JSONArray();

		userMap.put("id", "hds1234");
		userMap.put("pw", "1234");
		userMap.put("name", "한동석");
		userMap.put("age", 20);

		userJSON = new JSONObject(userMap);
		System.out.println(userJSON.toJSONString());
		
		users.add(userJSON);
		
		userMap.put("id", "hgd1234");
		userMap.put("pw", "5555");
		userMap.put("name", "한동석");
		userMap.put("age", 25);
		
	}

}
