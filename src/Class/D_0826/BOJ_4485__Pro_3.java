// BOJ 4485번 녹색 옷 입은 애가 젤다지? - 교수님 풀이
// dijkstra 
// no visit 

package Class.D_0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485__Pro_3 {

	static int N;
	static int[][] map;

	static PriorityQueue<Edge> pqueue = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
	static int[][] cost;
	static final int INF = Integer.MAX_VALUE;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			map = new int[N][N];
			cost = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = INF;
				}
			}

			dijkstra();

			System.out.println("Problem " + t + ": " + cost[N - 1][N - 1]);
			t++;
		}
	}

	static void dijkstra() {
		// 첫 방문 비용
		cost[0][0] = map[0][0];
		pqueue.offer(new Edge(0, 0, map[0][0]));

		while (!pqueue.isEmpty()) {
			Edge e = pqueue.poll();

			for (int d = 0; d < 4; d++) {
				int ny = e.y + dy[d];
				int nx = e.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N)
					continue;

				// 꺼낸 좌표에서 이어 가려는 새로운 좌표의 비용을 갱신
				if (e.c + map[ny][nx] < cost[ny][nx]) {
					cost[ny][nx] = e.c + map[ny][nx];
					pqueue.offer(new Edge(ny, nx, cost[ny][nx]));
				}
			}
		}
	}

	static class Edge {
		int y, x, c;

		public Edge(int y, int x, int c) {
			this.y = y;
			this.x = x;
			this.c = c;
		}
	}
}
