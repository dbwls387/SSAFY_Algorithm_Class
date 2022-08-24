// BOJ 7576번 토마토 

package Class.D_0824;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {

	static int M, N, not;
	static int[][] tomato, visited;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		not = 0;
		tomato = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 0)
					not++;
			}
		}

		visited = new int[N][M];

		bfs();
	}

	static void bfs() {
		Queue<Node> que = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 1) {
					que.offer(new Node(i, j));
					visited[i][j] = 1;
				}
			}
		}

		while (!que.isEmpty()) {
			Node node = que.poll();

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || tomato[ny][nx] == -1 || tomato[ny][nx] == 1
						|| visited[ny][nx] > 0)
					continue;

				que.offer(new Node(ny, nx));
				visited[ny][nx] = visited[node.y][node.x] + 1;
				not--;
			}
		}

		int maxDepth = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] >= maxDepth) {
					maxDepth = visited[i][j];
				}
			}
		}

		if (not > 0) {
			System.out.println(-1);
		} else {
			System.out.println(maxDepth - 1);
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
