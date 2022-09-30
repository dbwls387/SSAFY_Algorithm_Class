// BOJ 1463번 1로 만들기  - 교수님 풀이 (재귀) 

package Class.D_0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1463__Pro_RC {

	static int[] memoi;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		memoi = new int[N + 1]; // 0 dummy

		System.out.println(dp(N));
	}

	static int dp(int n) {
		// 기저조건
		if (n == 1)
			return 0;

		// n에 대해서 미리 계산된 값이 있으면 그 값을 활용
		if (memoi[n] > 0)
			return memoi[n];

		// 아직 n에 대해서 계산된 값이 없다.

		// 이전 단계 + 1
		memoi[n] = dp(n - 1) + 1; // n보다 1 작은 숫자를 만드는 경우의 수 + 1 (횟수)

		// 2로 나누어지면 이전 단계 (n/2) + 1
		if (n % 2 == 0)
			memoi[n] = Math.min(memoi[n], dp(n / 2) + 1);

		// 3로 나누어지면 이전 단계 (n/3) + 1
		if (n % 3 == 0)
			memoi[n] = Math.min(memoi[n], dp(n / 3) + 1);

		return memoi[n];
	}
}
