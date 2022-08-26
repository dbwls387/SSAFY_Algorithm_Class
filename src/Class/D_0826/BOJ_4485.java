// BOJ 4485번 녹색 옷 입은 애가 젤다지? 

package Class.D_0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485 {

	static int N, t = 1, ans;
	static int[][] map, cost;
	static boolean[][] visit;
	static PriorityQueue<Node> pqueue = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			visit = new boolean[N][N];
			cost = new int[N][N];

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = INF; // 충분히 큰 값으로
				}
			}

			dijkstra();

			sb.append("Problem ").append(t++).append(": ").append(cost[N - 1][N - 1]).append("\n");
		}

		System.out.println(sb);
	}

	static void dijkstra() {
		cost[0][0] = map[0][0];
		pqueue.offer(new Node(0, 0, map[0][0]));

		while (!pqueue.isEmpty()) {
			Node node = pqueue.poll();

			if (node.c > cost[node.y][node.x])
				continue;

			if (visit[node.y][node.x])
				continue;

			visit[node.y][node.x] = true;

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx])
					continue;

				if (cost[node.y][node.x] + map[ny][nx] < cost[ny][nx]) {
					cost[ny][nx] = cost[node.y][node.x] + map[ny][nx];
					pqueue.offer(new Node(ny, nx, cost[ny][nx]));
				}
			}
		}
	}

	static class Node {
		int y;
		int x;
		int c;

		public Node(int y, int x, int c) {
			this.y = y;
			this.x = x;
			this.c = c;
		}
	}
}
