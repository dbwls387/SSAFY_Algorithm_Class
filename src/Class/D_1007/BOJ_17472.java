// BOJ 17472번 다리 만들기 2

package Class.D_1007;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472 {

	static int N, M;
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

		// 섬 번호 표시하기
		visit = new boolean[N][M];
		int num = 1; // 섬 번호
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visit[i][j])
					number(i, j, num++);
			}
		}

		// 다리 만들기
		Arrays.fill(visit, false);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visit[i][j])
					bfs(i, j, map[i][j]);
			}
		}

	}

	static void bfs(int y, int x, int num) { // 다리 만들기
		Queue<Node> que = new ArrayDeque<>();
		que.offer(new Node(y, x));

		while (!que.isEmpty()) {
			Node node = que.poll();

			int len = 0;

			int d = 0;
			int ny = node.y;
			int nx = node.x;

			while (true) {
				ny += dy[d];
				nx += dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) // 섬을 못만나고 map을 벗어나는 경우 다리를 만들 수 X
					break;

				len++; // 다리 길이

				if (map[ny][nx] != num && map[ny][nx] != 0) { // 다른 섬을 만났을 경우 // 다리 만들어짐
					if (len < 2) // 다리 길이가 2보다 작은 경우 다리 X
						break;
				}

				que.add(new Node(ny, nx));
				visit[ny][nx] = true;
			}
		}
	}

	static void number(int y, int x, int num) { // 섬마다 번호로 표시하기
		Queue<Node> que = new ArrayDeque<>();
		que.offer(new Node(y, x));
		visit[y][x] = true;
		map[y][x] = num;

		while (!que.isEmpty()) {
			Node node = que.poll();

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx])
					continue;

				if (map[ny][nx] == 1) {
					map[ny][nx] = num;
					que.offer(new Node(ny, nx));
					visit[ny][nx] = true;
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
