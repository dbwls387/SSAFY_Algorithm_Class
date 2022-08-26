// BOJ 17144번 미세먼지 안녕! 

package Class.D_0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144 {

	static int R, C, T, ans;
	static int[][] map, cost;

	static int[] cleanX = new int[2]; // idx 0: 위쪽 공기청정기, 1: 아래쪽 공기청정기
	static int[] cleanY = new int[2];

	static Queue<Node> que = new ArrayDeque<>();

	// 상-우-하-좌
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		cost = new int[R][C];

		int idx = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;

				if (n == -1) {
					cleanX[idx] = i;
					cleanY[idx++] = j;
				} else if (n > 0) {
					que.offer(new Node(i, j, 0));
				}
			}
		}

		bfs();

		ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1)
					continue;

				if (map[i][j] > 0)
					ans += map[i][j];
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println(ans);
	}

	static void bfs() {

		for (int time = 1; time <= T; time++) {

			outer: while (!que.isEmpty()) {
				int size = que.size();

				int minusGive = 0;
				for (int i = 0; i < size; i++) {
					Node node = que.poll();

					if (node.t == time)
						break outer;

					for (int d = 0; d < 4; d++) {
						int ny = node.y + dy[d];
						int nx = node.x + dx[d];

						if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == -1)
							continue;

						cost[ny][nx] += map[node.y][node.x] / 5;
						minusGive += map[node.y][node.x] / 5;
						que.offer(new Node(ny, nx, node.t + 1));
					}
					cost[node.y][node.x] -= minusGive;
					minusGive = 0;
				}

				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						map[i][j] += cost[i][j];
						cost[i][j] = 0;
					}
				}
			}

			// 공기청정기 순환 코드
			rotate(); // 위쪽 청정기
			downRotate(); // 아래쪽 청정기
		}
	}

	static void rotate() {
		int sy = 0, ey = cleanX[0]; // sy : 시작 y, ey : 종료 y
		int sx = 0, ex = C - 1; // sx : 시작 x, ex : 종료 x

		while (true) {
			// 기저 조건
			if (ey - sy < 1 || ex - sx < 1)
				return;

			// 반 시계 방향으로 이동
			int temp = map[sy][sx]; // 첫 좌표 복사

			// top 좌로 이동 (오른쪽의 값이 왼쪽의 값으로 이동)
			for (int i = sx; i < ex; i++) {
				map[sy][i] = map[sy][i + 1];
			}

			// right 상으로 이동 ( 밑의 값이 위로 이동 )
			for (int i = sy; i < ey; i++) {
				map[i][ex] = map[i + 1][ex]; // 오른쪽 끝 x 고정
			}

			// bottom 우로 이동 (왼쪽의 값이 오른쪽으로 이동)
			for (int i = ex; i > sx; i--) {
				if (map[ey][i - 1] == -1)
					continue;

				map[ey][i] = map[ey][i - 1];
			}

			// left 하로 이동 ( 위의 값이 밑으로 이동 )
			for (int i = ey; i > sy; i--) {
				if (map[i][sx] == -1)
					continue;
				map[i][sx] = map[i - 1][sx];
			}

			map[sy + 1][sx] = temp;

			// sy, ey, sx, ex 보정
			sy += 1;
			sx += 1;
			ey -= 1;
			ex -= 1;
		}

	}

	static void downRotate() {
		int sy = 0, ey = R - 1; // sy : 시작 y, ey : 종료 y
		int sx = cleanX[1], ex = C - 1; // sx : 시작 x, ex : 종료 x

		while (true) {
			// 기저 조건
			if (sy - ey < 1 || sx - ex < 1)
				return;

			// 반 시계 방향으로 이동
			int temp = map[sy][sx]; // 첫 좌표 복사

			// top 좌로 이동 (오른쪽의 값이 왼쪽의 값으로 이동)
			for (int i = sx; i < ex; i++) {
				map[ey][i] = map[ey][i + 1];
			}

			// right 상으로 이동 ( 밑의 값이 위로 이동 )
			for (int i = sy; i < ey; i++) {
				map[i][ey] = map[i + 1][ey]; // 오른쪽 끝 x 고정
			}

			// bottom 우로 이동 (왼쪽의 값이 오른쪽으로 이동)
			for (int i = ex; i > sx; i--) {
				map[sy][i] = map[sy][i - 1];
			}

			// left 하로 이동 ( 위의 값이 밑으로 이동 )
			for (int i = ey; i > sy; i--) {
				map[i][ex] = map[i - 1][ex];
			}

			map[sy + 1][sx] = temp;

			// sy, ey, sx, ex 보정
			sy += 1;
			sx += 1;
			ey -= 1;
			ex -= 1;
		}

	}

	static class Node {
		int y;
		int x;
		int t;

		public Node(int y, int x, int t) {
			this.y = y;
			this.x = x;
			this.t = t;
		}
	}
}
