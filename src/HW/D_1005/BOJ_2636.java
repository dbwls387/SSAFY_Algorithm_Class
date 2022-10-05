// BOJ 2636번 치즈 

package HW.D_1005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {

	static int N, M, ans, ansCnt;
	static int[][] map;
	static boolean[][] visit;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visit = new boolean[N][M];
		
		while (true) {
			if (count() == 0) // 치즈가 모두 녹아 없어진 경우
				break;

			ans++;

			// visit 초기화
			for (int i = 0; i < N; i++)
				Arrays.fill(visit[i], false);

			ansCnt = count();

			bfs();			
		}

		System.out.println(ans);
		System.out.println(ansCnt);
	}

	static void bfs() {
		Queue<Node> que = new ArrayDeque<>();
		que.add(new Node(0, 0));
		visit[0][0] = true;

		while (!que.isEmpty()) {
			Node node = que.poll();

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == 2)
					continue;

				if (map[ny][nx] == 1) {
					map[ny][nx] = 2; // 치즈 모서리 2로 바꾸기
					visit[ny][nx] = true;
				} else if (map[ny][nx] == 0) {
					que.offer(new Node(ny, nx));
					visit[ny][nx] = true;
				}
			}
		}

		// 치즈 테두리 지우기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2)
					map[i][j] = 0;
			}
		}

	}

	static int count() {
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					cnt++;
			}
		}

		return cnt;
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
