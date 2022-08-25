// SWEA 1954번 달팽이 숫자

package HW.D_0802;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1954 {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int N, d;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			arr = new int[N][N];
			d = 0;

			arr[0][0] = 1;
			recursion(0, 0, 2);

			System.out.println("#" + t);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}

				System.out.println();
			}
		}
	}

	static void recursion(int x, int y, int index) {
		if (index == N * N + 1) {
			return;
		}

		if (blocked(x + dx[d], y + dy[d])) {
			turn();
		}

		arr[x + dx[d]][y + dy[d]] = index;
		recursion(x + dx[d], y + dy[d], index + 1);
	}

	static void turn() {
		d = (d + 1) % 4;
	}

	static boolean blocked(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N || arr[x][y] != 0) {
			return true;
		}
		return false;
	}
}