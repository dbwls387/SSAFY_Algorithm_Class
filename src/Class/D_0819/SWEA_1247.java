// SWEA 1247번 [S/W 문제해결 응용] 3일차 - 최적 경로

package Class.D_0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247 {

	static int T, N, min;
	static int[] x_arr, y_arr;
	static boolean[] visit;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			visit = new boolean[N + 2];
			x_arr = new int[N + 2];
			y_arr = new int[N + 2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N + 2; i++) {
				x_arr[i] = Integer.parseInt(st.nextToken());
				y_arr[i] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;

//			dfs(0, 0, 0);

		}
	}

//	static void dfs(int y, int x, int dis) {
//		if (y == y_arr[1] && x == x_arr[1])
//			return;
//
//		min = Math.min(min, dis);
//		visit[n] = true;
//
//		for (int d = 0; d < 4; d++) {
//			int ny = y + dy[d];
//			int nx = x + dx[d];
//
//			if (ny < 0 || nx < 0 || ny >= 100 || nx >= 100 || visit[n])
//				continue;
//
//			dis += (Math.abs(y_arr[y] - y_arr[ny]) + Math.abs(x_arr[x] - x_arr[nx]));
//
//			dfs(ny, nx, dis);
//		}
//
//		visit[n] = false;
//		dis = 0;
//	}

}
