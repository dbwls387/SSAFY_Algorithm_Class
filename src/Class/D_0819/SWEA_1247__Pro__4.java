// SWEA 1247번 [S/W 문제해결 응용] 3일차 - 최적 경로 - 교수님 풀이 4
// 가지치기 + dfs

package Class.D_0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1247__Pro__4 {

	static int T, N, comY, comX, homeY, homeX, min;
	static int[][] cust; // src
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;

			N = Integer.parseInt(br.readLine()); // 고객 수
			cust = new int[N][2];
			visit = new boolean[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			comY = Integer.parseInt(st.nextToken());
			comX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				cust[i][0] = Integer.parseInt(st.nextToken());
				cust[i][1] = Integer.parseInt(st.nextToken());
			}

			// 모든 고객을 시작점으로 각각 출발시켜 본다.
			for (int i = 0; i < N; i++) {
				Arrays.fill(visit, false); // visit 초기화
				visit[i] = true;
				dfs(i, 1, distance(comY, comX, cust[i][0], cust[i][1]));
			}

			System.out.println("#" + t + " " + min);
		}
	}

	// c: customer, d: depth, sum: 누적 거리 합
	static void dfs(int c, int d, int sum) {
		// 기저 조건
		if (d == N) {
			sum += distance(homeY, homeX, cust[c][0], cust[c][1]);
			min = Math.min(min, sum);
			return;
		}
		// 모든 고객을 대상으로 선택 ( 이미 선택한 고객은 skip)
		for (int i = 0; i < N; i++) {
			if (visit[i])
				continue;
			int dis = distance(cust[c][0], cust[c][1], cust[i][0], cust[i][1]);
			if (sum + dis >= min) // 가지치기
				continue;
			visit[i] = true;
			dfs(i, d + 1, sum + dis);
			visit[i] = false;
		}
	}

	static int distance(int y1, int x1, int y2, int x2) {
		return Math.abs(y2 - y1) + Math.abs(x2 - x1);
	}

}