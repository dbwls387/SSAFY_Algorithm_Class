// SWEA 4014번 [모의 SW 역량테스트] 활주로 건설

package Class.D_1011;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4014 {

	static int T, N, X, ans;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				func(map[i]);
			}

			System.out.println(ans);
		}

	}

	static void func(int[] arr) {

		int cnt = 0;
		boolean start = false;
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] - arr[i + 1] == 1) {
				start = true;
				cnt++;
			}
			if (start && arr[i] == arr[i + 1]) {
				cnt++;
			}

			if (i == N - 2 && cnt > 0) {
				if (cnt < X) {
					System.out.println(Arrays.toString(arr));
					return;
				}
			}

			if (arr[i] - arr[i + 1] == 1 && cnt > 0) {
				if (cnt < X)
					return;
				else {
					start = false;
				}
			} else {
				return;
			}
		}

		cnt = 0;
		start = false;
		for (int i = N - 1; i >= 1; i--) {
			if (arr[i] - arr[i - 1] == 1) {
				start = true;
			}
			if (start && arr[i] == arr[i - 1]) {
				cnt++;
			}
			
			if (i == 1 && cnt > 0) {
				if (cnt < X)
					return;
			}
			
			if (arr[i] - arr[i - 1] == 1 && cnt > 0) {
				if (cnt < X)
					return;
				else {
					start = false;
				}
			} else {
				return;
			}
		}

		System.out.println(Arrays.toString(arr));
		ans++;
	}

}
