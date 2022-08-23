// SWEA 3124번 최소 스패닝 트리
// 크루스칼 

package Class.D_0823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3124__Pro_1__Kruskal {

	static int T, V, E;
	static long sum;
	static int[] parent;
	static Edge[] edges;
	// visit 없음 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(br.readLine());

			// 초기화
			sum = 0;
			parent = new int[V + 1]; // 0 dummy
			edges = new Edge[E];

			// 간선 입력
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				edges[i] = new Edge(v1, v2, c);
			}

			// 크루스칼 시작
			// 간선 정렬
			Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);

			makeSet();
			int cnt = 0; // 간선의 수 ( V-1개 선택이 되면 종료 )
			for (int i = 0; i < E; i++) {
				Edge edge = edges[i]; // 이 간선이 연결하려는 두 정점에 대해서 cycle 체크

				if (union(edge.v1, edge.v2)) { // true 이면 두 정점이 사이클이 생기지 않았고, 그래서 연결
					cnt++;
					sum += edge.c;
				}
				if (cnt == V - 1) {
					break;
				}
			}

			System.out.println("#" + t + " " + sum);
		}
	}

	// 서로소 집합 관련 메소드들
	static void makeSet() {
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}

	// 부모를 찾는 (부모 번호 == 집합)
	static int findSet(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = findSet(parent[x]);
	}

	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (px == py)
			return false;

		if (px < py)
			parent[py] = px;
		else
			parent[px] = py;

		return true;
	}

	static class Edge {
		int v1, v2, c;

		public Edge(int v1, int v2, int c) {
			this.v1 = v1;
			this.v2 = v2;
			this.c = c;
		}
	}
}
