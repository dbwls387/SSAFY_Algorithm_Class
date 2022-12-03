// 지역구 나누기 (게리맨더링) 

package A_Prepare_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_5 {

	static int T, N, ans;
	static int[][] arr;
	static int[] people;

	static int[] src;
	static boolean[] select;

	static List<Integer> listA, listB;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			people = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				people[i] = Integer.parseInt(st.nextToken());
			}

			src = new int[N];
			select = new boolean[N];
			for (int i = 0; i < N; i++) {
				src[i] = i;
			}

			ans = Integer.MAX_VALUE;
			subset(0);

			if (ans == Integer.MAX_VALUE)
				ans = -1;
			System.out.println("#" + t + " " + ans);
		}

	}

	static void subset(int srcIdx) {
		if (srcIdx == N) {
			listA = new ArrayList<>();
			listB = new ArrayList<>();
			int sumA = 0;
			int sumB = 0;

			// 팀 나누기
			for (int i = 0; i < N; i++) {
				if (select[i]) {
					listA.add(i);
					sumA += people[i];
				} else {
					listB.add(i);
					sumB += people[i];
				}
			}

			if (listA.size() == 0 || listB.size() == 0)
				return;

			if (!check(listA)) {
				return;
			}
			if (!check(listB)) {
				return;
			}

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

			for (int i = 0; i < arr[x].length; i++) {
				int y = arr[x][i];
				if (y == 1)
					y = i;

				if (area.contains(y) && !visit[y]) {
					visit[y] = true;
					que.offer(y);
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
