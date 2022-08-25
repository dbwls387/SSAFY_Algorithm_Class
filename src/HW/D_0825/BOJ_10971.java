// BOJ 10971번 외판원 순회 2

package HW.D_0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971 {

	static int N, sum, min;
	static int[][] W;
	static int[] src, tgt;

	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		src = new int[N];
		tgt = new int[N + 1];
		select = new boolean[N];

		for (int i = 0; i < N; i++) {
			src[i] = i;
		}

		W = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		min = Integer.MAX_VALUE;
		perm(0);

		System.out.println(min);
	}

	static void perm(int tgtIdx) {
		sum = 0;

		if (tgtIdx == N) {
			tgt[N] = tgt[0];

			for (int i = 0; i < N; i++) {
				if (W[tgt[i]][tgt[i + 1]] == 0) {
					return;
				}

				sum += W[tgt[i]][tgt[i + 1]];
			}

			min = Math.min(min, sum);

			return;
		}

		for (int i = 0; i < N; i++) {
			if (select[i])
				continue;

			tgt[tgtIdx] = src[i];
			select[i] = true;
			perm(tgtIdx + 1);
			select[i] = false;
		}
	}

}
