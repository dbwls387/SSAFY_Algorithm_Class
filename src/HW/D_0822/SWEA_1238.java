// SWEA 1238번 [S/W 문제해결 기본] 10일차 - Contact

package HW.D_0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238 {

	static int N, start, maxIdx;
	static List<Integer>[] list;
	static int[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			list = new ArrayList[101];
			for (int i = 1; i <= 100; i++) {
				list[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				list[from].add(to);
			}

			visited = new int[101];
			bfs(start);

			sb.append("#" + t + " " + maxIdx + "\n");
		}
		
		System.out.println(sb);
	}

	static void bfs(int v) {
		Queue<Integer> que = new LinkedList<>();

		que.offer(v);
		visited[v] = 1;

		while (!que.isEmpty()) {
			int x = que.poll();

			for (int i = 0; i < list[x].size(); i++) {
				int y = list[x].get(i);

				if (visited[y] == 0) {
					que.offer(y);
					visited[y] = visited[x] + 1;
				}
			}
		}

		int maxDepth = 0;
		maxIdx = 0;
		for (int i = 1; i < 101; i++) {
			if (visited[i] >= maxDepth) {
				maxDepth = visited[i];
				maxIdx = i;
			}
		}
	}

}
