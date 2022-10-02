// SWEA 1249번 [S/W 문제해결 응용] 4일차 - 보급로 

package HW.D_0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1249 {

	static int T, N, min;
	static int[][] map, ans;
	static boolean[][] visit;

	static Queue<Node> que = new LinkedList<>();

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] tmp = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = tmp[j] - '0';
				}
			}

			min = Integer.MAX_VALUE;
			visit = new boolean[N][N];

			ans = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(ans[i], Integer.MAX_VALUE);
			}
			ans[0][0] = 0;

			bfs(0, 0);

			System.out.println("#" + t + " " + min);
		}

	}

	static void bfs(int y, int x) {
		que.offer(new Node(y, x));
		visit[y][x] = true;

		while (!que.isEmpty()) {
			Node node = que.poll();

			int a = node.y;
			int b = node.x;

			if (a == N - 1 && b == N - 1)
				min = Math.min(min, ans[N - 1][N - 1]);

			if (min <= ans[a][b])
				continue;

			for (int d = 0; d < 4; d++) {
				int ny = a + dy[d];
				int nx = b + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N)
					continue;

				if (!visit[ny][nx] || ans[ny][nx] > ans[a][b] + map[ny][nx]) {
					visit[ny][nx] = true;
					ans[ny][nx] = ans[a][b] + map[ny][nx];
					que.offer(new Node(ny, nx));
				}

			}
		}
	}

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
