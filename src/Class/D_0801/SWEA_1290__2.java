package Class.D_0801;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1290__2 {

	// Scanner -> BufferedReader
	// local 변수 중 주요 변수들을 -> static
	// int[] -> char[]
	// String toCharArray()

	static int T, count;
	static char[] input, memory;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			count = 0; // 변경 건수

			input = br.readLine().toCharArray(); // 배열을 새로 생성해서 return

			int cnt = input.length;

			memory = new char[cnt]; // 0으로 초기화
			for (int i = 0; i < cnt; i++) {
				memory[i] = '0';
			}

			// 두 배열을 같은 index로 이동하면서 값을 비교
			for (int i = 0; i < cnt; i++) {
				if (memory[i] != input[i]) {
					// memArray를 뒤까지 변경
					for (int j = i; j < cnt; j++) {
						memory[j] = input[i];
					}
					count++; // 변경된 수 증가
				}
			}

			System.out.println("#" + t + " " + count);
		}

	}

}
