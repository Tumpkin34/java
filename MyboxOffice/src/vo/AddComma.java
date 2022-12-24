package vo;

public class AddComma {
	public static String addComma(String str) {
		String temp = "", reverseTemp = "";
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (cnt == 3) {
				temp += ",";
				cnt = 0;
			}
			temp += str.charAt(str.length() - 1 - i);
			cnt++;
		}
		for (int i = 0; i < temp.length(); i++) {
			reverseTemp += temp.charAt(temp.length() - 1 - i);
		}
		return reverseTemp;
	}
}
