// SWEA 3234번 준환이의 양팔저울 - 교수님 풀이
// Bit Masking
// 시간 초과

package Class.D_0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3234__Pro__2 {

	static int T, N, ans;
	static int[] choo;
//	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			choo = new int[N];
//			select = new boolean[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
			}

			ans = 0;

			perm(0, 0, 0, 0);

			System.out.println("#" + t + " " + ans);
		}
	}

	static void perm(int tgtIdx, int leftSum, int rightSum, int select) {
		// 기저 조건
		if (tgtIdx == N) {
			// complete code
			ans++;
			
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((select & 1 << i) != 0)
				continue;
//			select[i] = true;

			// 2가지의 재귀 호출
			// #1 왼쪽에 추를 올리는 경우
			perm(tgtIdx + 1, leftSum + choo[i], rightSum, select | 1 << i);

			// #2 오른쪽에 추를 올리는 경우 ( 문제의 조건 + 가지치기 )
			if (leftSum >= rightSum + choo[i]) {
				perm(tgtIdx + 1, leftSum, rightSum + choo[i], select | 1 << i);
			}

//			select[i] = false;
		}
	}

}