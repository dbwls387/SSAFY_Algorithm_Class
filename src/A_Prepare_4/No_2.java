package A_Prepare_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_2 {

	static int T, Ms, Ma, N, L, maxBenefit, ans;
	static int[][] val;

	static List<Stock> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Ms = Integer.parseInt(st.nextToken());
			Ma = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			val = new int[N][L + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < L + 1; j++) {
					val[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int money = Ms;

			for (int month = 0; month < L; month++) {
				list = new ArrayList<>();

				for (int i = 0; i < N; i++) {
					if (val[i][month + 1] - val[i][month] > 0)
						list.add(new Stock(val[i][month], val[i][month + 1], val[i][month + 1] - val[i][month]));
				}

				maxBenefit = 0;
				dfs(0, money, 0);

				money += maxBenefit;
				money += Ma;
			}

			int ans = money - (Ms + Ma * L);
			System.out.println("#" + t + " " + ans);
		}
	}

	static void dfs(int idx, int money, int benefit) {
		if (idx == list.size()) {
			maxBenefit = Math.max(maxBenefit, benefit);
			return;
		}

		Stock stock = list.get(idx);

		if (money - stock.now >= 0) {
			dfs(idx, money - stock.now, benefit + stock.diff);
		}

		dfs(idx + 1, money, benefit);
	}

	static class Stock {
		int now;
		int next;
		int diff;

		public Stock(int now, int next, int diff) {
			this.now = now;
			this.next = next;
			this.diff = diff;
		}
	}
}
