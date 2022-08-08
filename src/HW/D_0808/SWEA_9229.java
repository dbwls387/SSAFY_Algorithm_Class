// SWEA 9229번 한빈이와 Spot Mart

package HW.D_0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229 {

	static int T, N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int max = 0;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					sum = arr[i] + arr[j];
					if (sum <= M) {
						if (sum > max) {
							max = sum;
						}
					}
				}
			}

			if (max == 0) {
				max = -1;
			}

			System.out.println("#" + t + " " + max);
		}
	}
}
