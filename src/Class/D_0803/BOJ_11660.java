// BOJ 11660번 구간 합 구하기 5

package Class.D_0803;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660 {

	static int[][] accu;
	static int N, M, pre;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		accu = new int[N + 1][N + 1];
		pre = accu[0][0];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				accu[i][j] = accu[i][j - 1] + Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from_x = Integer.parseInt(st.nextToken());
			int from_y = Integer.parseInt(st.nextToken());
			int to_x = Integer.parseInt(st.nextToken());
			int to_y = Integer.parseInt(st.nextToken());

			int sum = 0;
			for (int j = from_x; j <= to_x; j++) {
				sum += (accu[j][to_y] - accu[j][from_y - 1]);
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}

}
