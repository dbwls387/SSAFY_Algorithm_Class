package A_Prepare_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1 {

	static int T, N, max, ans;
	static int[] tree;

	// 나무에 물을 줘서 모든 나무가 최대높이까지 갈 수 있는 최소 날짜를 구하는 문제
	// 홀수날 나무의 키 +1, 짝수날 나무의 키 +2
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			max = 0; // 나무 최대 높이
			tree = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, tree[i]);
			}

			ans = Integer.MAX_VALUE;
			calc(); // 최소날짜 계산 시작

			System.out.println("#" + t + " " + ans);
		}

	}

	static void calc() {
		int oddSum = 0; // 홀수 날
		int evenSum = 0; // 짝수 날

		for (int i = 0; i < N; i++) {
			// 이미 최대 높이인 경우 pass
			if (tree[i] == max)
				continue;

			// 최대 높이까지 필요한 나무 키
			int remain = max - tree[i];

			oddSum += remain % 2; // 홀수날 최솟값 저장
			evenSum += remain / 2; // 짝수날 최댓값 저장
		}

		calcDay(oddSum, evenSum);

		// 1일 (홀수날)부터 시작이므로 홀수날 >= 짝수날이 되어야 함
		// 홀수날 == 짝수날 +1 또는 홀수날 == 짝수날이 되어야 최소 날짜
		while (evenSum > oddSum) {
			// 1짝수날 == 2홀수날
			evenSum--;
			oddSum += 2;

			calcDay(oddSum, evenSum);
		}
	}

	static void calcDay(int oddSum, int evenSum) {
		// 홀수날이 더 많아진 경우 홀수날로 선정
		// 홀수날과 짝수날이 동일할 경우 짝수날로 선정
		int day = oddSum > evenSum ? (oddSum - 1) * 2 + 1 : evenSum * 2;
		ans = Math.min(ans, day);
	}

}
