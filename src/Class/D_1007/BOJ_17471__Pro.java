// BOJ 17471번 게리맨더링 - 교수님 풀이 

package Class.D_1007;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 부분집합 
// 인접행렬 
// 연결 여부 => BFS

public class BOJ_17471__Pro {

	static int N, min;
	static int[][] matrix;
	static boolean[] select; // subset
	static boolean[] visit; // bfs - 연결 확인
	static Queue<Integer> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		matrix = new int[N + 1][N + 1]; // 0 dummy <= 인구수 저장해서 활용
		select = new boolean[N + 1];
		visit = new boolean[N + 1];
		min = Integer.MAX_VALUE;

		// 구역별 인구수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			matrix[i][0] = Integer.parseInt(st.nextToken());
		}

		// 구역별 인접 행렬
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		subset(1);

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	static void check() {
		// 2개의 선거구에 포함된 구역들이 모두 연결 => bfs
		// 적어도 1개의 구역을 포함

		// 초기화
		Arrays.fill(visit, false);
		queue.clear();

		// A
		for (int i = 1; i <= N; i++) {
			if (select[i]) {
				visit[i] = true;
				queue.offer(i);
				break;
			}
		}

		if (queue.size() == 0) // size == N 확인 X
			return;

		// 방문할 수 있는 곳을 방문하고 visit 만 체크
		while (!queue.isEmpty()) {
			int v = queue.poll();

			for (int i = 1; i <= N; i++) {
				int adj = matrix[v][i];
				if (adj != 0 && !visit[adj] && select[adj]) { // 연결되어 있고, 아직 방문하지 않았고, A 그룹에 속하는 (select[adj] true)
					visit[adj] = true; // 연결된 정점이 true로 표시된다.
					queue.offer(adj);
				}
			}
		}

		// B
		for (int i = 1; i <= N; i++) {
			if (!select[i]) {
				visit[i] = true;
				queue.offer(i);
				break;
			}
		}

		// 방문할 수 있는 곳을 방문하고 visit 만 체크
		while (!queue.isEmpty()) {
			int v = queue.poll();

			for (int i = 1; i <= N; i++) {
				int adj = matrix[v][i];
				if (adj != 0 && !visit[adj] && !select[adj]) { // 연결되어 있고, 아직 방문하지 않았고, A 그룹에 속하는 (select[adj] false)
					visit[adj] = true; // 연결된 정점이 true로 표시된다.
					queue.offer(adj);
				}
			}
		}

		// 모두 방문할 수 있는지 확인
		// visit[] 검사
		boolean visitAll = true;
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				visitAll = false;
				break;
			}
		}

		// 모두 방문할 수 있다. (모두 연결)
		// A, B 각각 인구수 계산하고 차이를 min 에 반영
		// 각 구역의 인구수는 matrix[v][0]
		if (visitAll) {
			int sumA = 0;
			int sumB = 0;

			for (int i = 1; i <= N; i++) {
				if (select[i])
					sumA += matrix[i][0];
				else
					sumB += matrix[i][0];
			}

			min = Math.min(min, Math.abs(sumA - sumB));
		}
	}

	// select[]에 표기를 한다. (선택, 비선택)
	static void subset(int srcIdx) {
		// 기저 조건
		if (srcIdx == N + 1) {
			check();
			return;
		}

		select[srcIdx] = true;
		subset(srcIdx + 1);
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}
}
