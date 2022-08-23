// SWEA 3289번 서로소 집합 

package Class.D_0823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289 {

	static int T, n, m;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			parent = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				parent[i] = i;
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());

				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (op == 0)
					union(a, b);
				else {
					if (findSet(a) == findSet(b))
						sb.append(1);
					else
						sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int findSet(int a) {
		if (parent[a] == a)
			return a;

		return parent[a] = findSet(parent[a]);
	}

	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return;

		parent[bRoot] = aRoot;
		return;
	}

}
