// SWEA 3234번 준환이의 양팔저울 - 교수님 풀이

package Class.D_0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3234__Pro__4__success {

	static int T, N, ans;
//	static int[] choo;
//	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			int[] choo = new int[N];
			boolean[] select = new boolean[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
			}

			ans = 0;

			perm(choo, select, 0, 0, 0);

			StringBuilder sb = new StringBuilder();

			sb.append("#").append(t).append(" ").append(ans);
			System.out.println(sb);
		}
	}

	static void perm(int[] choo, boolean[] select, int tgtIdx, int leftSum, int rightSum) {
		if (rightSum > leftSum)
			return;

		// 기저 조건
		if (tgtIdx == choo.length) {
			// complete code

			ans++;
			return;
		}

		for (int i = 0; i < choo.length; i++) {
			if (select[i])
				continue;
			select[i] = true;

			// 2가지의 재귀 호출
			// #1 왼쪽에 추를 올리는 경우
			perm(choo, select, tgtIdx + 1, leftSum + choo[i], rightSum);

			// #2 오른쪽에 추를 올리는 경우 ( 문제의 조건 + 가지치기 )
			perm(choo, select, tgtIdx + 1, leftSum, rightSum + choo[i]);

			select[i] = false;
		}
	}

}