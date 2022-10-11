// SWEA 5643번 [Professional] 키 순서

package HW.D_1007;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_5643 {

	static int T, N, M, tmp, ans;
	static List<Integer>[] list;

	static int[] cnt;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			list = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				list[a].add(b);
			}

			cnt = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				tmp = 0;
				visit = new boolean[N + 1];
				dfs(i, i);
				cnt[i] += tmp;
			}

			ans = 0;
			for (int i = 1; i <= N; i++) {
				if (cnt[i] == N)
					ans++;
			}

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}

		System.out.println(sb.toString());
	}

	static void dfs(int cur, int start) {
		tmp += 1;
		for (int i = 0; i < list[cur].size(); i++) {
			int next = list[cur].get(i);
			if (visit[next])
				continue;

			visit[next] = true;
			cnt[next] += 1;
			dfs(next, start);
		}
	}

}
