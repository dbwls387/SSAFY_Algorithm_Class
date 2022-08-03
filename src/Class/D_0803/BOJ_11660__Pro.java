// BOJ 11660번 구간 합 구하기 5

package Class.D_0803;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660__Pro {

	static int[][] accu;
	static int N, M, pre;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		accu = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			// 행별 누적 계산
			for (int j = 1; j <= N; j++) {
				accu[i][j] = accu[i][j - 1] + Integer.parseInt(st.nextToken());

			}
		}
		
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				System.out.print(accu[i][j] + " ");
			}
			System.out.println();
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			// x가 행
			int sum = 0;
			for (int x = x1; x <= x2; x++) { // 행별로 내려가면서
				sum += accu[x][y2] - accu[x][y1 - 1];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}

}
