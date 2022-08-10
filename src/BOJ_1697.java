
// BOJ 1697번 숨바꼭질 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {

	static int N, K, result;
	static Queue<Integer> queue;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		queue = new ArrayDeque<>();
		visited = new boolean[100000];

		result = 0;

		bfs();

		System.out.println(result);
	}

	static void bfs() {
		queue.add(N);
		visited[N] = true;

		while (!queue.isEmpty()) {
			int x = queue.poll();

			if (x + 1 == K || x - 2 == K || x * 2 == K) {
				queue.clear();
				break;
			}

			if (!visited[x + 1]) {
				visited[x + 1] = true;
				queue.add(x + 1);
			}

			if (!visited[x - 1]) {
				visited[x - 1] = true;
				queue.add(x - 1);
			}

			if (!visited[x * 2]) {
				visited[x * 2] = true;
				queue.add(x * 2);
			}
		}

	}
}
