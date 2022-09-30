// BOJ 1463번 1로 만들기  - 교수님 풀이 (dp)

package Class.D_0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1463__Pro {

	static int[] memoi;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		memoi = new int[N + 1]; // 0 dummy

		memoi[1] = 0;

		for (int i = 2; i <= N; i++) {
			// 3가지 연산 중 최소 비용을 선택해서 간다.

			// 1 빼는 (거꾸로 더하는)
			memoi[i] = memoi[i - 1] + 1;

			// 2로 나누는
			if (i % 2 == 0)
				memoi[i] = Math.min(memoi[i], memoi[i / 2] + 1);

			// 3으로 나누는
			if (i % 3 == 0)
				memoi[i] = Math.min(memoi[i], memoi[i / 3] + 1);
		}

		System.out.println(memoi[N]);
	}
}
