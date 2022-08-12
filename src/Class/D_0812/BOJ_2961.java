// BOJ 2961번 도영이가 만든 맛있는 음식 

package Class.D_0812;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961 {

	static int N, S, B, result;
	static int[] shin_arr, ssn_arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		shin_arr = new int[N];
		ssn_arr = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			shin_arr[i] = Integer.parseInt(st.nextToken());
			ssn_arr[i] = Integer.parseInt(st.nextToken());
		}

		result = Integer.MAX_VALUE;

		dfs(0, 1, 0);

		System.out.println(result);
	}

	static void dfs(int srcIdx, int shin, int ssn) {
		if (srcIdx == N) {
			if (ssn == 0) // 반드시 하나는 선택해야 함 
				return;
			
			result = Math.min(result, Math.abs(shin - ssn));
			return;
		}

		dfs(srcIdx + 1, shin, ssn);
		dfs(srcIdx + 1, shin * shin_arr[srcIdx], ssn + ssn_arr[srcIdx]);
	}

}
