// BOJ 1463번 1로 만들기 

package Class.D_0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1463 {

	static int N;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dp = new int[N + 1];

		dp[0] = 0;
		dp[1] = 0;

		for (int i = 2; i < N + 1; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 2 == 0)	// 2로 나눠 떨어질 경우 
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);

			if (i % 3 == 0)	// 3으로 나눠 떨어질 경우
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
		}

		System.out.println(dp[N]);
	}
}
