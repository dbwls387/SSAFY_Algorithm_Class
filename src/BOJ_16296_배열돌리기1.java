
// 배열돌리기 1, 배열 돌리기 2
// 반시계 방향

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16296_배열돌리기1 {

	static int N, M, R;
	static int[][] map;

	// 우-하-좌-상 (반시계 방향)
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int num = Math.min(N, M) / 2;

		int n = N, m = M;
		for (int i = 0; i < num; i++) {
			int len = 2 * n + 2 * m - 4; // 돌아야 하는 칸 수 (둘레)
			int rGo = R % len; // 회전해야 하는 칸 수

			rotate(i, rGo);
			// 박스 안으로 들어갈 때마다 가로 세로 길이가 2씩 줄어듦
			n -= 2;
			m -= 2;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	static void rotate(int i, int rGo) {
		for (int r = 0; r < rGo; r++) {
			int x = i;
			int y = i;
			int tmp = map[y][x];

			int d = 0;

			while (d < 4) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny < i || nx < i || ny >= N - i || nx >= M - i) {
					d++;
				} else {
					map[y][x] = map[ny][nx];

					y = ny;
					x = nx;
				}
			}
			map[i + 1][i] = tmp;
		}
	}

}
