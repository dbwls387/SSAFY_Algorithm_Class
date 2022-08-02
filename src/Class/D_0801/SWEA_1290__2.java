package Class.D_0801;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1290__2 {

	// Scanner -> BufferedReader
	// local ���� �� �ֿ� �������� -> static
	// int[] -> char[]
	// String toCharArray()

	static int T, count;
	static char[] input, memory;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			count = 0; // ���� �Ǽ�

			input = br.readLine().toCharArray(); // �迭�� ���� �����ؼ� return

			int cnt = input.length;

			memory = new char[cnt]; // 0���� �ʱ�ȭ
			for (int i = 0; i < cnt; i++) {
				memory[i] = '0';
			}

			// �� �迭�� ���� index�� �̵��ϸ鼭 ���� ��
			for (int i = 0; i < cnt; i++) {
				if (memory[i] != input[i]) {
					// memArray�� �ڱ��� ����
					for (int j = i; j < cnt; j++) {
						memory[j] = input[i];
					}
					count++; // ����� �� ����
				}
			}

			System.out.println("#" + t + " " + count);
		}

	}

}
