// BOJ 1600번 말이 되고픈 원숭이 - 교수님 풀이 (bfs) 

package Class.D_0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600__Pro_bfs {

	static int K, W, H;
	static int[][] map;
	static boolean[][][] visit;

	// 상-하-좌-우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	// 말, 8방
	static int[] hdy = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] hdx = { -2, -1, 1, 2, 2, 1, -1, -2 };

	static Queue<Node> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		visit = new boolean[H][W][K + 1];
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		queue.offer(new Node(0, 0, K, 0));

		bfs();
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			Node node = queue.poll();

			// 기저 조건
			// 목표지점에 도착한 첫번째 경우에 바로 출력 및 종료
			if (node.y == H - 1 && node.x == W - 1) {
				System.out.println(node.d);
				return;
			}

			// 탐색 2가지
			// 탐색 #1 - 상하좌우
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][node.k])
					continue;

				visit[ny][nx][node.k] = true;
				queue.offer(new Node(ny, nx, node.k, node.d + 1)); // k에 변화 X
			}

			// 탐색 #2 - 말, 8방
			if (node.k == 0)
				continue; // k가 모두 소진되면 skip

			for (int d = 0; d < 8; d++) {
				int ny = node.y + hdy[d];
				int nx = node.x + hdx[d];

				if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][node.k - 1])
					continue;

				visit[ny][nx][node.k - 1] = true;
				queue.offer(new Node(ny, nx, node.k - 1, node.d + 1)); // k-1 로 처리
			}
		}

		System.out.println(-1);
	}

	static class Node {
		int y, x, k, d;

		Node(int y, int x, int k, int d) {
			this.y = y;
			this.x = x;
			this.k = k;
			this.d = d;
		}
	}

}
