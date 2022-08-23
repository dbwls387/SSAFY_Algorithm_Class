// SWEA 7465번 창용 마을 무리의 개수 

package HW.D_0823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SWEA_7465 {

	static int T, N, M;
	static int[] parent, A, B;
	static TreeSet<Integer> ts;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			parent = new int[N + 1];
			makeSet();

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				union(a, b);
			}
			ts = new TreeSet<Integer>();
            for (int i = 1; i <= N; i++) {
                ts.add(findSet(i));
            }

			sb.append("#").append(t).append(" ").append(ts.size()).append("\n");
		}
		System.out.println(sb);
	}

	static void makeSet() {
		for (int i = 1; i <= N; i++) {
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
