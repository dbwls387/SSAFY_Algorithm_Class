// 나무의 키 

package A_Prepare_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test_1_tree {

	static int T, N, max, ans;
	static int[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			max = 0;

			tree = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, tree[i]);
			}

			ans = Integer.MAX_VALUE;
			calc();

			System.out.println("#" + t + " " + ans);
		}
	}

	static void calc() {
		int oddSum = 0;
		int evenSum = 0;

		for (int i = 0; i < N; i++) {
			if (tree[i] == max)
				continue;

			int remain = max - tree[i];

			oddSum += remain % 2;
			evenSum += remain / 2;
		}

		calcDay(oddSum, evenSum);

		while (evenSum > oddSum) {
			evenSum--;
			oddSum += 2;

			calcDay(oddSum, evenSum);
		}
	}

	static void calcDay(int oddSum, int evenSum) {
		int day = oddSum > evenSum ? (oddSum - 1) * 2 + 1 : evenSum * 2;
		ans = Math.min(ans, day);
	}

}
