package methodTest;

public class MethodTask {

//	1~ 10까지 println()으로 출력하는 메소드
	void banbok() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1);
		}
	}

//	"홍길동"을 n번 println()으로 출력하는 메소드
	void hong(int n) {// 받아온 변수 (매개변수)
		for (int i = 0; i < n; i++) {
			System.out.println("홍길동");
		}
	}

//	이름을 n번 println()으로 출력하는 메소드
	void yourName(String name, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(name);
		}
	}

//	세 정수의 뺄셈을 해주는 메소드
	int substract(int num1, int num2, int num3) {
		return num1 - num2 - num3;
	}

//	두 정수의 나눗셈을 해주는 메소드(몫과 나머지 둘다)
	int[] divide(int num1, int num2) { // 몫과 나머지를 리턴을 받아야하는데 리턴을 하나뿐이 못 받는다.

		int[] results = null;// num2가 0을 받아오면 result의 주소값을 null로 하고 리턴할 예정이다.

		if (num2 != 0) {// 어떤수를 0으로는 나눌 수 없기 때문에 0으로 나누는 경우를 막아준다.
			results = new int[2];// num2가 0이 아니기 때문에 몫과 나머지를 저장하기 위해 result의 공간을 2칸으로 만들어준다.

			results[0] = num1 / num2;// 0번에 몫을 넣어준다.
			results[1] = num1 % num2;// 1번에 나머지를 넣어준다.
		}
		return results;// 배열의 주소를 넘겨준다.
	}

//	1~n까지의 합을 구해주는 메소드
	int sum(int n) {
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += i + 1;
		}
		return result;
	}

	int getTotalFrom1(int end) {// 외부에서 n을 받아온다.
		int total = 0;// 더하기를 저장할 변수 선언
		for (int i = 0; i < end; i++) {// n까지 반복한다.
			total += i + 1;// i+1이기 때문에 1부터 시작을 하고 total에 하나씩 담아간다.
		}
		return total;// 1~n까지의 합이 들어있는 total을 리턴한다.
	}
//-----------------------------------------

//	홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
	int change(int num) {
		return num + 1;
	}

	int change2(int number) {// 숫자를 하나 받는다.
		return ++number;// 넘겨받은 숫자에 +1을 해서 돌려준다.
	}

//	문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
	String bigSmall(String word) {
		String changeWord = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
				changeWord += (char) (word.charAt(i) + 32);
			} else if (word.charAt(i) >= 97 && word.charAt(i) <= 122) {
				changeWord += (char) (word.charAt(i) - 32);
			} else {
				changeWord += word.charAt(i);
			}
		}
		return changeWord;
	}

	String changeString(String string) {// String 타입으로 리턴을 해줄거고, 문자열을 받는다.
		String result = "";// 리턴해줄 문자열을 담을 변수 선언

		for (int i = 0; i < string.length(); i++) {// 받아온 문자열의 길이만큼 반복한다.
			char c = string.charAt(i);// 밑에서 여러번 쓰지않게 c에 담는다.

			if (c >= 65 && c <= 90) {// 대문자 일 때 실행할 코드
				result += (char) (c + 32);// 위의 c에 32를 더하면 해당 영어의 소문자의 아스키코드값을 받을 수 있다. 그값을 (char)로 형변환을 해 result에 연결시켜
											// 나간다. result에 초기값이 ""이기 때문에 여기에 char가 더해지기 때문에 연결될 수 있다.
			} else if (c >= 96 && c <= 122) {// 소문자 일 때 실행할 코드
				result += (char) (c - 32);// 위와 같은 맥락으로 32를 빼면 대문자의 아스키코드값을 받는다.
			} else {// 대문자도, 소문자도 아닐때 실행할 코드
				result += c;// 대문자도, 소문자도 아닐 때는 그냥 연결 시켜준다.
			}
		}

		return result;// 위에서 연결시킨 문자열을 리턴해준다.
	}

//	문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드 ***
	int count(String word, char wantLetter) {// 원하는 문자의 개수이기 때문에 돌려줄 자료형은 int이다 입력받은 문자열과, 찾을 문자를 받는다.
		int cnt = 0;// 문자열안에 해당 문자가 몇개 있는지 샐 변수 선언
		for (int i = 0; i < word.length(); i++) {// 받아온 문자열의 길이 만큼 반복
			if (word.charAt(i) == wantLetter) {// 받아온 문자열의 index번호에 있는 문자가 찾는 문자이면 실행한다.
				cnt++;// 해당 문자를 찾았기 때문에 카운트 해준다.
			}
		}
		return cnt;// 몇개를 찾았는지 리턴해준다.
	}

	int getCount(String string, char c) {
		int count = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}

//	5개의 정수를 입력받은 후 원하는 번째 값을 구해주는 메소드
	int yourNumber(int[] arNum, int n) {// int[]배열이기 때문에 찾아서 돌려줄 값도 int형이다.5개의 정수를 담은 배열과 원하는 번째 숫자를 받는다.
		String msg = "인덱스 범위가 넘었습니다";// 배열의 길이보다 찾을 번호가 더 큰경우 알려줄 문장
		if (n >= arNum.length) {// 배열의 길이보다 찾을 번호가 큰 경우 실행할 코드
			System.out.println(msg);// 배열의 길이보다 찾을 번호가 더 큰경우 알려줄 문장
		}
		return arNum[n];// 배열의 길이보다 찾을 번호가 크다면 오류가 나고, 아니라면 해당 인덱스번호에 있는 값을 돌려준다.
	}

	int getValue(int[] nums, int wantedNumber) {
		return nums[wantedNumber - 1];
	}

//	한글을 정수로 바꿔주는 메소드 일공이사 indexof
	int koreanChangeInt(String hangle) {
		String number = "0123456789";
		String koreanNumber = "공일이삼사오육칠팔구";
		String changeNumber = "";
		for (int i = 0; i < hangle.length(); i++) {
			for (int j = 0; j < koreanNumber.length(); j++) {
				if (hangle.charAt(i) == koreanNumber.charAt(j)) {
					changeNumber += number.charAt(j);
				}
			}
		}
		return Integer.parseInt(changeNumber);
	}

	int koreanChangeInt2(String hangle) {
		String koreanNumber = "공일이삼사오육칠팔구", result = "";
		for (int i = 0; i < hangle.length(); i++) {
			result += koreanNumber.indexOf(hangle.charAt(i)) + "";
		}
		return Integer.parseInt(result);
	}

	int changeToInteger(String hangle) {//정수로 바꿀 거기 때문에 리턴받을 값은 int형, 정수로 바꿀 한글을 받는다.
		String hangleOriginal = "공일이삼사오육칠팔구", result = "";//밑에서 검사하기 위해 필요한 준비물, 그 결과를 담을 변수
		for (int i = 0; i < hangle.length(); i++) {//받아온 한글의 길이만큼 반복
			result += hangleOriginal.indexOf(hangle.charAt(i));//받아온 한글의 i번째 받의 있는 문자를 hangleOriginal에서 찾고 그문자가 있는 인덱스 번호를 돌려주고 그 인덱스 번호를 result에 연결 시켜준다.
		}
		return Integer.parseInt(result);// 정수로 바꾸는 것이기 때문에 위에서 연결시킨 문자열을 int로 형변환 해준다.
	}

//	5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드
	int[] minMax(int[] arNum) {//최대값, 최소값 2개의 값을 담은 배열을 넘겨줄 거기떄문에int[] ,5개의 정수를 담고 있는 배열을 받는다.
		int max = arNum[0];
		int min = arNum[1];
		int[] returnMinMax = new int[2];
		for (int i = 0; i < arNum.length; i++) {
			if (arNum[i] > max) {
				max = arNum[i];
			}
			if (arNum[i] < min) {
				min = arNum[i];
			}
		}
		returnMinMax[0] = max;
		returnMinMax[1] = min;
		return returnMinMax;

	}

	int[] getMaxAndMin(int[] nums) {//최대값, 최소값 2개의 값을 담은 배열을 넘겨줄 거기떄문에int[] ,5개의 정수를 담고 있는 배열을 받는다.
		int[] results = new int[2];//최대값, 최소값 2개이기 때문에 2칸 배열을 만든다.
		results[0] = nums[0];// results[0]은 최대값 담을 공간 일단 nums안에있는 아무 숫자나 넣어준다.
		results[1] = nums[0];// results[1]은 최소값 담을 공간 일단 nums안에있는 아무 숫자나 넣어준다.

		for (int i = 1; i < nums.length; i++) {//받아온 정수의 개수 만큼 반복
			if (results[0] < nums[i]) {//nums의 i번째 방에 있는 숫자가 현재 results에 담긴 숫자보다 크다면 실행시킨다.
				results[0] = nums[i];//해당 숫자를 담아준다.
			}
			if (results[1] > nums[i]) {//nums의 i번째 방에 있는 숫자가 현재 results에 담긴 숫자보다 작다면 실행시킨다.
				results[1] = nums[i];//해당 숫자를 담아준다.
			}
		}

		return results;//위의 최대값 최소값이 담긴 배열의 주소를 넘겨준다.
	}

//	5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드(void로 하되, 출력 없이 사용하는 부분에 결과를 전달한다)전역변수 안됨
//	매개변수는 2개 전달해야 한다.
//	예) getMaxAndMin();
//		여기서부터 최대값, 최소값 사용 가능
	void hardMinMax(int[] arNum, int[] address) {
		int max = arNum[0];
		int min = arNum[1];
		for (int i = 0; i < arNum.length; i++) {
			if (arNum[i] > max) {
				max = arNum[i];
			}
			if (arNum[i] < min) {
				min = arNum[i];
			}
		}
		address[0] = max;
		address[1] = min;
	}

	void getMaxAndMin(int[] nums, int[] results) {//메인 메소드에서 results라는 배열을 선언할 것이다. 그 주소를 넘겨 주었기 때문에 이 메소드가 종료 되어도 main에서 주소를 메모리에 만들었기때문에 해당 주소가 없어지지않는다.
		results[0] = nums[0];// 최대값 위에 설명한 배열의 주소의 인덱스 방에 값을 담는다.
		results[1] = nums[0];// 최소값 위에 설명한 배열의 주소의 인덱스 방에 값을 담는다.

		for (int i = 1; i < nums.length; i++) {//받아온 정수의 개수 만큼 반복
			if (results[0] < nums[i]) {//nums의 i번째 방에 있는 숫자가 현재 results에 담긴 숫자보다 크다면 실행시킨다.
				results[0] = nums[i];//해당 숫자를 담아준다.
			}
			if (results[1] > nums[i]) {//nums의 i번째 방에 있는 숫자가 현재 results에 담긴 숫자보다 작다면 실행시킨다.
				results[1] = nums[i];//해당 숫자를 담아준다.
			}
		}
	}

	void test(int[] data) {
		System.out.println(data);
		data[0] = 10;
	}

	public static void main(String[] args) {
		MethodTask mt = new MethodTask();//객체화 MethodTask클래스 heap메모리에 올려주고 생성된 주소값을 가져오고 MetHodTask형인 mt객체명(저장공간임은 변수와 같지만 객체명은 주소값를, 변수는 값)을 담는다.  

//      mt.printFrom1To10(); 필드의 주소안에 있는 printFrom1To10메서드를 실행시킨다.
//      mt.printHong(10);
//      mt.printName("한동석", 10); 필드의 주소안에 있는 printName메소드에 매개변수를 "한동석",10이라는 값을 넘겨준다.
//      System.out.println(mt.substract(5, 4, 2));
//      int[] results = mt.divide(10, 3);
//      String msg = null;
//      msg = results == null ? "0으로 나눌 수 없습니다." : "몫 : " + results[0] + "\n나머지 : " + results[1];
//      System.out.println(msg);

//      1~n까지의 합을 구해주는 메소드
//      int getTotalFrom1(int end)
//      System.out.println(mt.getTotalFrom1(10));

//      홀수를 짝수로, 짝수를 홀수로 바꿔주는 메소드
//      int change(int number)
//      boolean result = mt.change(11) % 2 == 0;
//      System.out.println(result ? "홀수에서 짝수로 바뀌었습니다." : "짝수에서 홀수로 바뀌었습니다.");

//      문자열을 입력받고 소문자는 대문자로, 대문자는 소문자로 바꿔주는 메소드
//      String changeString(String string)
//      System.out.println(mt.changeString("aPplE1234!@#$"));

//      문자열을 입력받고 원하는 문자의 개수를 구해주는 메소드
//      int getCount(String string, char c)
//      System.out.println(mt.getCount("apple", 'p') + "개");

//      5개의 정수를 입력받은 후 원하는 번째 값을 구해주는 메소드
//      int getValue(int[] nums, int wantedNumber)
//      int[] arData = {1, 2, 5, 7, 8};
//      System.out.println(mt.getValue(arData, 3));

//      한글을 정수로 바꿔주는 메소드
//      int changeToInteger(String hangle)
//      int result = mt.changeToInteger("삼공오이사");
//      System.out.println(result - 3);

//      5개의 정수를 입력받고 최대값과 최소값을 구해주는 메소드
//      void getMaxAndMin(int[] nums, int[] results)
		int[] arData = { 1, 2, 5, 7, 8 };
		int[] results = new int[2];

		mt.getMaxAndMin(arData, results);// 값을 받을 배열의 주소를 넘겨준다.

		System.out.println("최대값 : " + results[0]);
		System.out.println("최소값 : " + results[1]);

	}
}
