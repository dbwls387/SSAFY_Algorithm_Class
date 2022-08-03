// BOJ 11660번 구간 합 구하기 5

package Class.D_0803;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660__xiu {

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
			for (int j = 1; j <= N; j++) {
				accu[i][j] += Integer.parseInt(st.nextToken());
				accu[i][j] += accu[i - 1][j] + accu[i][j - 1] - accu[i - 1][j - 1];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from_x = Integer.parseInt(st.nextToken());
			int from_y = Integer.parseInt(st.nextToken());
			int to_x = Integer.parseInt(st.nextToken());
			int to_y = Integer.parseInt(st.nextToken());

			sb.append(accu[to_x][to_y] - accu[to_x][from_y - 1] - accu[from_x - 1][to_y] + accu[from_x - 1][from_y - 1])
					.append("\n");
		}
		System.out.println(sb.toString());
	}

}
