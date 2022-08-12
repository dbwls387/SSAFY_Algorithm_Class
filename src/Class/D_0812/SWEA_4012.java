// SWEA 4012번 [모의 SW 역량테스트] 요리사

package Class.D_0812;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012 {

	static int T, N, min;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j)
						continue;
//					A = arr[i][j] + arr[j][i];
				}
			}

			min = Integer.MAX_VALUE;

			dfs(0, 0, 0, 0);

			System.out.println("#" + t + " " + min);
		}

	}

	static void dfs(int srcIdx, int x, int y, int taste) {
		int taste_curr = arr[x][y] + arr[y][x];

		if (y == N - 1) {
			y = 0;
			x++;
		}

		if (x == N - 1 && y == N - 1) {
			int dis = Math.abs(taste - taste_curr);
			min = Math.min(min, dis);

			return;
		}

		dfs(srcIdx + 1, x, y, taste);
		dfs(srcIdx + 1, x, y + 1, taste);
	}

}
