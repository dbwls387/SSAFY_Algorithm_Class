// SWEA 5215번 햄버거 다이어트 

package HW.D_0811;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {

	static int T, N, L, result;
	static int[] score_arr, cal_arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			score_arr = new int[N];
			cal_arr = new int[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score_arr[i] = Integer.parseInt(st.nextToken());
				cal_arr[i] = Integer.parseInt(st.nextToken());
			}

			result = 0;

			dfs(0, 0, 0);

			System.out.println("#" + t + " " + result);
		}

	}

	static void dfs(int idx, int score, int cal) {
		if (cal > L)
			return;
		if (idx == N) {
			result = Math.max(result, score);
			return;
		}

		dfs(idx + 1, score + score_arr[idx], cal + cal_arr[idx]);
		dfs(idx + 1, score, cal);
	}
}
