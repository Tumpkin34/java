package casting;

import java.util.Scanner;

//	넷플릭스
// 	애니메이션, 영화, 드라마 클래스 선언
//	사용자가 선택한 영상이
//	애니메이션이라면 "자막지원"기능 사용 printSubtitle
//	영화라면 "4D"기능 사용
//	드라마라면 "굿즈"기능 사용


class Video {
}

// 	애니메이션, 영화, 드라마 클래스 선언
//	애니메이션이라면 "자막지원"기능 사용 printSubtitle
class Animation extends Video {
	void printSubtitle() {
		System.out.println("자막지원");
	}
}

//	영화라면 "4D"기능 사용
class Movie extends Video {
	void get4D() {
		System.out.println("4D");
	}
}

//	드라마라면 "굿즈"기능 사용
class Drama extends Video {
	void getGoods() {
		System.out.println("굿즈");
	}
}

public class CastingTask {

	void search(Video name) {
		if (name instanceof Animation) {
			Animation onePunchMan = (Animation) name;
			onePunchMan.printSubtitle();
		} else if (name instanceof Movie) {
			Movie avengers = (Movie) name;
			avengers.get4D();
		} else {
			Drama chuno = (Drama) name;
			chuno.getGoods();
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CastingTask ct = new CastingTask();
		Video video = null;
//		Video onePunchMan = new Animation();
//		Video avengers = new Movie();
//		Video chuno = new Drama();

		int choice = 0;
		while (true) {
//	사용자가 선택한 영상이
			System.out.println("1.onePunchMan\n2.avengers\n3.chuno");
			choice = sc.nextInt();
			if (choice == 1) {
				video = new Animation();
			} else if (choice == 2) {
				video = new Movie();
			} else if (choice == 3) {
				video = new Drama();
			} else {
				System.out.println("?");
				continue;
			}
			
			ct.search(video);
		}
	}
}
