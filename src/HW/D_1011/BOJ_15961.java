package HW.D_1011;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961 {

	static int N, d, k, c, ans;
	static int[] arr, visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		visit = new int[d + 1];

		func();

		System.out.println(ans);
	}

	static void func() {
		int inSlide = 0;

		for (int i = 0; i < k; i++) {
			if (visit[arr[i]] == 0)
				inSlide++;
			visit[arr[i]]++;
		}

		int chance = inSlide;

		for (int i = 1; i < N; i++) {
			if (chance <= inSlide) {
				if (visit[c] == 0)
					chance = inSlide + 1;
				else
					chance = inSlide;
			}

			visit[arr[i - 1]]--;

			if (visit[arr[i - 1]] == 0)
				inSlide--;

			if (visit[arr[(i + k - 1) % N]] == 0)
				inSlide++;

			visit[arr[(i + k - 1) % N]]++;
		}

		ans = chance;
	}

}
