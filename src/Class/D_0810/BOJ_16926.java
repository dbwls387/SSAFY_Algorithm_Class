// BOJ 16926번 배열 돌리기 1

package Class.D_0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {

	static int N, M, R, cnt = 1;
	static int[][] arr;
	static boolean[][] visit;

	// 상-하-좌-우
	static int[] dy = { 0, 1, -1, 0 };
	static int[] dx = { 1, 0, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.print(arr[0][R]+" ");
		solution(0, R);

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

	static void solution(int x, int y) {
		visit[x][y] = true;

		if (visit[x][y] == false)
			return;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) {
				continue;
			}

			System.out.print(arr[ny][nx] + " ");
			cnt++;

			if (cnt == N) {
				cnt = 0;
				System.out.println();
			}

			solution(ny, nx);
		}
	}

}
