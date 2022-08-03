// BOJ 11659 구간 합 구하기 4

package Class.D_0803;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659__Pro {

	static int N, M;
	static int[] accu; // memoi <= 이전 수부터의 합을 미리 계산
	// 0  1  2  3  4  5
	// 0  1  3  6  10  15 <- accu
	//       *     *

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		accu = new int[N + 1]; // 0 dummy
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			accu[i] = Integer.parseInt(st.nextToken()) + accu[i - 1];
		}

		// M개의 구간합
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			// 두개
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

//			System.out.println(accu[to] - accu[from - 1]);
			sb.append(accu[to] - accu[from - 1]).append("\n");	// 시간 개선
		}
		
		System.out.println(sb.toString());
	}

}
