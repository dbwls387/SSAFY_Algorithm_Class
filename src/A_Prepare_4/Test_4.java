package A_Prepare_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test_4 {

	static int T, N, min;
	static int[][] map, ans;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(ans[i], Integer.MAX_VALUE);
			}

			min = Integer.MAX_VALUE;
			bfs();

			System.out.println("#" + t + " " + min);
		}

	}

	static void bfs() {
		Queue<Node> que = new ArrayDeque<>();
		que.offer(new Node(0, 0));
		ans[0][0] = 0;

		while (!que.isEmpty()) {
			Node node = que.poll();
			int y = node.y;
			int x = node.x;

			if (y == N - 1 && x == N - 1) {
				min = Math.min(min, ans[N - 1][N - 1]);
			}

			if (min <= ans[y][x])
				continue;

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N)
					continue;

				if (map[y][x] == map[ny][nx]) {
					if (ans[y][x] + 1 < ans[ny][nx]) {
						que.offer(new Node(ny, nx));
						ans[ny][nx] = ans[y][x] + 1;
					}
				}
				if (map[y][x] > map[ny][nx]) {
					if (ans[y][x] < ans[ny][nx]) {
						que.offer(new Node(ny, nx));
						ans[ny][nx] = ans[y][x];
					}
				}
				if (map[y][x] < map[ny][nx]) {
					int fuel = (map[ny][nx] - map[y][x]) * 2;
					if (ans[y][x] + fuel < ans[ny][nx]) {
						que.offer(new Node(ny, nx));
						ans[ny][nx] = ans[y][x] + fuel;
					}
				}
			}

		}
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
