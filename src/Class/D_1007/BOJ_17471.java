// BOJ 17471번 게리맨더링

package Class.D_1007;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471 {

	static int N, ans;
	static int[] pop;
	static List<Integer>[] list;
	static List<Integer> A;
	static List<Integer> B;

	static int[] src;
	static boolean[] select;

	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		pop = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			pop[i] = Integer.parseInt(st.nextToken());
		}

		list = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			for (int j = 1; j <= n; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		// 입력 끝

		// 1. 부분집합으로 두 구역 나누기
		// 2. 나눈 구역에서 모든 구역이 이어져 있는지 확인
		// 3. -> 두 선거구 모두 모든 곳이 이어져 있다면 각각의 인구수 check -> 최소값 출력

		// 부분집합
		src = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			src[i] = i;
		}

		ans = Integer.MAX_VALUE;
		select = new boolean[N + 1];
		subset(1);

		// 정답 출력
		if (ans == Integer.MAX_VALUE) // 두 선거구로 나눌 수 없을 경우 -1 출력
			ans = -1;
		System.out.println(ans);
	}

	static void subset(int srcIdx) {
		if (srcIdx == N) {
			// 부분집합으로 골라진 걸로 선거구 A, B 리스트에 담기
			// 담으면서 인구수 바로 구해주기
			A = new ArrayList<>();
			B = new ArrayList<>();

			int cntA = 0, cntB = 0;
			for (int i = 1; i <= N; i++) {
				if (select[i]) {
					A.add(src[i]);
					cntA += pop[i];
				} else {
					B.add(src[i]);
					cntB += pop[i];
				}
			}

			if (A.size() == 0 || B.size() == 0) // 각 선거구는 적어도 하나의 구역을 포함해야 한다.
				return;

			// 나눈 두 선거구에서 모든 구역이 연결되어 있는지 확인
			visit = new boolean[N + 1];
			if (!connect_check(A)) // A 선거구에 연결 안된 구역이 있으면 return
				return;

			visit = new boolean[N + 1]; // visit 초기화
			if (!connect_check(B)) // B 선거구에 연결 안된 구역이 있으면 return
				return;

			// 인구수 차이 최소값 구하기
			ans = Math.min(ans, Math.abs(cntA - cntB));

			return;
		}

		select[srcIdx] = true;
		subset(srcIdx + 1);

		select[srcIdx] = false;
		subset(srcIdx + 1);
	}

	static boolean connect_check(List<Integer> area) { // 모든 구역이 이어져 있는지 확인하는 함수
		Queue<Integer> que = new ArrayDeque<>();
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
		
//		for (int i = 0; i < area.size(); i++) {
//			if (area.contains(i) && !visit[area.get(i)]) {
//				return false;
//			}
//		}

		for (int i = 1; i <= N; i++) {
			if (area.contains(i) && !visit[i]) {
				return false;
			}
		}

		return true;
	}

}
