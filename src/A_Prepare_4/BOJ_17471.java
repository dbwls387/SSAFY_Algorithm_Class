package A_Prepare_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471 {

	static int T, N, ans;
	static int[] people;
	static List<Integer>[] list;

	static int[] src;
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		people = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		list = new List[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			for (int j = 0; j < n; j++) {
				list[i].add(Integer.parseInt(st.nextToken()) - 1);
			}
		}

		src = new int[N];
		for (int i = 0; i < N; i++) {
			src[i] = i;
		}

		ans = Integer.MAX_VALUE;
		select = new boolean[N];
		subset(0);

		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}

	static void subset(int srcIdx) {
		if (srcIdx == N) {
			List<Integer> listA = new ArrayList<>();
			List<Integer> listB = new ArrayList<>();
			int sumA = 0;
			int sumB = 0;

			for (int i = 0; i < N; i++) {
				if (select[i]) {
					listA.add(i);
					sumA += people[i];
				} else {
					listB.add(i);
					sumB += people[i];
				}
			}

			if (listA.size() == 0 || listB.size() == 0) {
				return;
			}

			if (!check(listA))
				return;
			if (!check(listB))
				return;

			ans = Math.min(ans, Math.abs(sumA - sumB));

			return;
		}

		select[srcIdx] = true;
		subset(srcIdx + 1);
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}

	static boolean check(List<Integer> area) {
		Queue<Integer> que = new ArrayDeque<>();
		boolean[] visit = new boolean[N];
		que.offer(area.get(0));
		visit[area.get(0)] = true;

		while (!que.isEmpty()) {
			int x = que.poll();

			for (int i = 0; i < list[x].size(); i++) {
				int y = list[x].get(i);

				if (area.contains(y) && !visit[y]) {
					que.offer(y);
					visit[y] = true;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			if (area.contains(i) && !visit[i])
				return false;
		}

		return true;
	}
}
