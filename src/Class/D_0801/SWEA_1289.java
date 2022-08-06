// SWEA 1289번 원재의 메모리 복구하기  

package Class.D_0801;
import java.util.Scanner;

public class SWEA_1289 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		/*
		 * int T = sc.nextInt(); for (int t = 1; t <= T; t++) { String input =
		 * sc.next(); int memory = 0; int[] original = new int[input.length()];
		 * 
		 * for (int i = 0; i < original.length; i++) { original[i] = input.charAt(i) -
		 * '0'; } int cnt = original[0];
		 * 
		 * for (int i = 0; i < original.length - 1; i++) { if (original[i] != original[i
		 * + 1]) { cnt++; } }
		 * 
		 * System.out.println("#" + t + " " + cnt); }
		 */

		int T = sc.nextInt();
		sc.nextLine(); // 개행문자 해소

		for (int t = 0; t < T; t++) {
			int count = 0; // 변경 건수
			String str = sc.nextLine(); // 개행문자까지
			// 두개의 배열
			// 1. inputArray / 2. memArray
			int cnt = str.length();
			int[] inputArray = new int[cnt];
			int[] memArray = new int[cnt]; // 0으로 초기화

			for (int i = 0; i < cnt; i++) {
				inputArray[i] = str.charAt(i) - 48; // -'0'
			}

			// 두 배열을 같은 index로 이동하면서 값을 비교
			for (int i = 0; i < cnt; i++) {
				if (memArray[i] != inputArray[i]) {
					// memArray를 뒤까지 변경
					for (int j = i; j < cnt; j++) {
						memArray[j] = inputArray[i];
					}
					count++; // 변경된 수 증가
				}
			}

			System.out.println("#" + t + " " + count);
		}

	}

}