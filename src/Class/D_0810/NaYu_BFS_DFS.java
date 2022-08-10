package Class.D_0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import Class.D_0810.BASIC_BFS_DFS.Node;

public class NaYu_BFS_DFS {

	static int N, M;
	static int[][] arr;

	// 상-하-좌-우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M + 1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(1, 1);

	}

	static void bfs(int y, int x) {
		visit = new boolean[N + 1][M + 1];

		Queue<Node> queue = new ArrayDeque<>();

		queue.offer(new Node(y, x));
		visit[y][x] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if (arr[node.y][node.x] % 2 == 0)
				System.out.print(arr[node.y][node.x] + " ");

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 1 || nx < 1 || ny >= (N + 1) || nx >= (M + 1) || visit[ny][nx])
					continue;

				queue.offer(new Node(ny, nx));
				visit[ny][nx] = true;
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
