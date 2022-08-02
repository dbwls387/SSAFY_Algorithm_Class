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
		sc.nextLine(); // ���๮�� �ؼ�

		for (int t = 0; t < T; t++) {
			int count = 0; // ���� �Ǽ�
			String str = sc.nextLine(); // ���๮�ڱ���
			// �ΰ��� �迭
			// 1. inputArray / 2. memArray
			int cnt = str.length();
			int[] inputArray = new int[cnt];
			int[] memArray = new int[cnt]; // 0���� �ʱ�ȭ

			for (int i = 0; i < cnt; i++) {
				inputArray[i] = str.charAt(i) - 48; // -'0'
			}

			// �� �迭�� ���� index�� �̵��ϸ鼭 ���� ��
			for (int i = 0; i < cnt; i++) {
				if (memArray[i] != inputArray[i]) {
					// memArray�� �ڱ��� ����
					for (int j = i; j < cnt; j++) {
						memArray[j] = inputArray[i];
					}
					count++; // ����� �� ����
				}
			}

			System.out.println("#" + t + " " + count);
		}

	}

}
