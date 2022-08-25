// BOJ 10026번 적록색약

package HW.D_0824;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10026 {

	static int N, blind_cnt, cnt;
	static char[][] arr;
	static boolean[][] visit;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new char[N][];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		visit = new boolean[N][N];
		cnt = 0;
		blind_cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					dfs(i, j);
					cnt++;
				}
				if (arr[i][j] == 'G')
					arr[i][j] = 'R';
			}
		}

		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					dfs(i, j);
					blind_cnt++;
				}
			}
		}

		System.out.println(cnt + " " + blind_cnt);
	}

	static void dfs(int y, int x) {
		visit[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx])
				continue;

			if (arr[ny][nx] == arr[y][x])
				dfs(ny, nx);
		}
	}

}
