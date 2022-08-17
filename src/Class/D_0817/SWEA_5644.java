// SWEA 5644번 [모의 SW 역량테스트] 무선 충전

package Class.D_0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_5644 {

	static int T, M, A;
	static int[] moveA, moveB;
	static int[][] AP;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			map = new int[10][10];
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			moveA = new int[M];
			moveB = new int[M];
			AP = new int[A][4];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					AP[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			solve();

			System.out.println(Arrays.toString(map));
			System.out.println("#" + t + " ");
		}
	}

	static void solve() {
		int xIdx, yIdx;
		for (int i = 0; i < A; i++) {
			xIdx = AP[i][0];
			yIdx = AP[i][1];
			for (int j = 0; j < AP[i][2]; j++) {
				map[xIdx - j][yIdx] = AP[i][3];
				map[xIdx][yIdx - j] = AP[i][3];
				map[xIdx + j][yIdx] = AP[i][3];
				map[xIdx][yIdx + j] = AP[i][3];
			}
		}

		int sumA = 0;
		int sumB = 0;
		xIdx = 0;
		yIdx = 0;
		for (int i = 0; i < M; i++) {
			if (moveA[i] == 1) {
				yIdx++;
				if (map[xIdx][yIdx] > 0) {
					sumA += map[xIdx][yIdx];
				}
			}
		}
	}
}
