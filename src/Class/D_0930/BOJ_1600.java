// BOJ 1600번 말이 되고픈 원숭이 

package Class.D_0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1600 {

	static int K, W, H, min;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, 0, 0);

		System.out.println(min);
	}

	static int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -1 };

	static int[] d2y = { -1, 1, 0, 0 };
	static int[] d2x = { 0, 0, -1, 1 };

	static void dfs(int y, int x, int cnt, int k) {
		if (y == H - 1 && x == W - 1) {
			min = Math.min(min, cnt);
			return;
		}

		map[y][x] = 2; // visit check

		if (k < K) {
			for (int d = 0; d < 8; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || map[ny][nx] == 2) {
					if (d == 7) {
						for (int d2 = 0; d2 < 4; d2++) {
							int n2y = y + d2y[d2];
							int n2x = x + d2x[d2];

							if (n2y < 0 || n2x < 0 || n2y >= H || n2x >= W || map[n2y][n2x] == 1
									|| map[n2y][n2x] == 2) {
								if (d2 == 3) {
									min = -1;
									return;
								}
								continue;
							}

							dfs(n2y, n2x, cnt + 1, k);
						}
					}
					continue;
				}

				dfs(ny, nx, cnt + 1, k + 1);
			}
		} else {
			for (int d2 = 0; d2 < 4; d2++) {
				int n2y = y + d2y[d2];
				int n2x = x + d2x[d2];

				if (n2y < 0 || n2x < 0 || n2y >= H || n2x >= W || map[n2y][n2x] == 1 || map[n2y][n2x] == 2) {
					if (d2 == 3) {
						min = -1;
						return;
					}
					continue;
				}

				dfs(n2y, n2x, cnt + 1, k);
			}
		}
	}

}
