// BOJ 13023번 ABCDE 

package Class.D_0823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13023 {

	static int N, M;
	static ArrayList<Integer>[] list;
	static boolean[] visited, lineVisited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			list[A].add(B);
			list[B].add(A);
		}

		System.out.println(Arrays.toString(list));

		visited = new boolean[N];
		lineVisited = new boolean[N];
		dfs(list[0].get(0));

		System.out.println(Arrays.toString(lineVisited));
	}

	static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");

		for (int i = 0; i < list[v].size(); i++) {
			int x = list[v].get(i);
			lineVisited[v] = true;
			if (!visited[x])
				dfs(x);
		}
	}

}
