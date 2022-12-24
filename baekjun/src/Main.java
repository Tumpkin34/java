import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		String b = sc.next();
		for (int i = 0; i < b.length(); i++) {
			System.out.println(a * b.charAt(i));
		}
		System.out.println(a*Integer.parseInt(b));
		System.out.println(b.charAt(2));
		System.out.println((int)(b.charAt(2)));
	}

}
