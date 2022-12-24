package collectionTest;

public class ForEachTest {

	public static void main(String[] args) {
		int[][] arrData = { { 10, 30, 80 }, { 20, 40, 10 } };
//		각 학생의 총점과 평균 출력
		int sum = 0;
		String temp = "";

		for (int[] i : arrData) {
			for (int j : i) {
				sum += j;
			}
			System.out.println(sum);
			temp = String.format("%.2f", (double) sum / arrData[0].length);
			System.out.println(temp);
			sum = 0;
		}
//		for (int[] i : arrData) {
//			for (int j : i) {
//				System.out.println(j);
//			}
//
//		}

	}

}

//package collectionTest;
//
//public class ForEachTest {
//   public static void main(String[] args) {
//      int[][] arrData = {{10, 30, 80}, {20, 40, 10}};
////      각 학생의 총점과 평균 출력
//      int total = 0;
//      double average = 0.0;
//      
//      for (int[] arData : arrData) {
//         total = 0;
//         for (int score : arData) {
//            total += score;
//         }
//         average = total / (double)arData.length;
//         average = Double.parseDouble(String.format("%.2f", average));
//         
//         System.out.println(total);
//         System.out.println(average);
//      }
//      
//   }
//}