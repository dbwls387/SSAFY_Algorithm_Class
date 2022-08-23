// SWEA 3124번 최소 스패닝 트리

package Class.D_0823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3124 {

	static int T, V, E, A, B, C;
	static long sum;
	static int[] parent;
	static int[][] graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parent = new int[V + 1];
			graph = new int[E][3];

			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				graph[e][0] = Integer.parseInt(st.nextToken());
				graph[e][1] = Integer.parseInt(st.nextToken());
				graph[e][2] = Integer.parseInt(st.nextToken());
			}

			makeSet();

			// 가중치를 이용해 간선 정렬
			Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

			int cnt = 0; // 간선의 수 ( V-1개가 되면 종료)
			for (int e = 0; e < E; e++) {
				if (findSet(graph[e][0]) != findSet(graph[e][1])) {
					cnt++;
					union(graph[e][0], graph[e][1]);
					sum += graph[e][2];
				}
				if (cnt == V - 1) {
					break;
				}
			}

			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}

		System.out.println(sb);
	}

	static void makeSet() {
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}

	static int findSet(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = findSet(parent[x]);
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (px < py)
			parent[py] = px;
		else
			parent[px] = py;
	}
}
