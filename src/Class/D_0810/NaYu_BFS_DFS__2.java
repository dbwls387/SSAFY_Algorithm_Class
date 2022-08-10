package Class.D_0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import Class.D_0810.BASIC_BFS_DFS.Node;

public class NaYu_BFS_DFS__2 {

	static int N, M;
	static int[][] arr;

	// 상-하-좌-우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static boolean[][] visit;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bfs(i, j);
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	static void bfs(int y, int x) {
		if (visit[y][x] == false)
			return;
		visit[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || nx >= N || ny >= M || visit[ny][nx]) {
				continue;
			}

			if (!visit[ny][nx] && arr[ny][nx] % 2 == 0) {
				bfs(ny, nx);
				visit[ny][nx] = true;
			}
		}
	}
}
