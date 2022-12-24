package task;

import java.util.ArrayList;

public class UserField {
	ArrayList<User> memberInfo = new ArrayList<User>();

	public boolean duplicateCheckID(String id) {
		for (int i = 0; i < memberInfo.size(); i++) {
			if (memberInfo.get(1).getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public User signup(String name, String id, String pw, String phoneNumber) {
		User user = new User();
		if (duplicateCheckID(id)) {
			return user = null;
		}
		user.setName(name);
		user.setId(id);
		user.setPw(pw);
		user.setPhoneNumber(phoneNumber);
		return user;
	}

	public boolean login(String id, String pw) {
		if (duplicateCheckID(id)) {
			for (int i = 0; i < memberInfo.size(); i++) {
				if (memberInfo.get(i).getPw().equals(pw)) {
					return true;
				}
			}
		}
		return false;
	}

}
