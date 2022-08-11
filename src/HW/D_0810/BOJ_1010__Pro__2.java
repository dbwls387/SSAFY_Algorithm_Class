// BOJ 1010번 다리 놓기 - 교수님 풀이 

package HW.D_0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 단순하게 조합의 경우의 수 
public class BOJ_1010__Pro__2 {

	// 공 7개 중에 4개를 뽑는다. (조합)
	// 공 한개를 선택한 경우의 수 => 6개 중에 3개
	// 공 한 개를 선택하지 않은 경우의 수 => 6개 중에 4개
	// 7C4 = 6C3 + 6C4
	// = 5C2 + 5C3 + 5C3 + 5C4

	// => 중복이 많이 발생한다. => 미리 한 번 계산한 값을 저장할 수 있는 자료구조를 만들고, 반복되는 경우는 기록해 두고 재사용한다.
	// memoization
	// memoization 을 이용해서 작은 수 -> 큰 수로 확대해 나가는 방법 DP

	static int T, N, M;
	static int[][] dp; // 역할은 재귀호출을 줄여주는 효과

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			dp = new int[M + 1][N + 1];

			// dp로 배열 완성하기
			for (int i = 0; i <= M; i++) {
				for (int j = 0; j <= Math.min(i, N); j++) {
					if (j == 0 || j == i)
						dp[i][j] = 1;
					else
						dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]);
				}
			}

			System.out.println(dp[M][N]);
		}
	}
}
