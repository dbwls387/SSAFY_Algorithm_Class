// SWEA 1289번 원재의 메모리 복구하기

package Class.D_0801;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1289 {

	static int T, cnt;
	static char[] memory, input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			input = br.readLine().toCharArray();

			memory = new char[input.length];
			for (int i = 0; i < input.length; i++) {
				memory[i] = '0';
			}

			cnt = 0;
			for (int i = 0; i < input.length; i++) {
				if (input[i] != memory[i]) {
					for (int j = i; j < input.length; j++) {
						memory[j] = input[i];
					}
					cnt++;
				}
			}

			System.out.println("#" + t + " " + cnt);
		}
	}

}
