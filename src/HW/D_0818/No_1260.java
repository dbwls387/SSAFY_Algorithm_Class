// BOJ 1260번 DFS와 BFS

package HW.D_0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class No_1260 {

	static int N, M, V;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}

		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			list.get(a).add(b);
			list.get(b).add(a);
		}

		for (int i = 0; i < N + 1; i++) {
			Collections.sort(list.get(i));
		}

		visited = new boolean[N + 1];
		dfs(V);
		System.out.println();

		visited = new boolean[N + 1];
		bfs(V);
	}

	static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");

		for (int i = 0; i < list.get(v).size(); i++) {
			int x = list.get(v).get(i);
			if (!visited[x])
				dfs(x);
		}
	}

	static void bfs(int v) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(v);

		visited[v] = true;

		while (!que.isEmpty()) {
			int x = que.poll();
			System.out.print(x + " ");

			for (int i = 0; i < list.get(x).size(); i++) {
				int y = list.get(x).get(i);
				if (!visited[y]) {
					que.offer(y);
					visited[y] = true;
				}
			}
		}
	}

}
