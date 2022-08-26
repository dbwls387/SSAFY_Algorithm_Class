import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1987 {

	static int R, C, max;
	static char[][] map;
	static Queue<Node> que = new ArrayDeque<>();
	static boolean[] visit = new boolean[26];

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		max = Integer.MIN_VALUE;
		bfs();

		System.out.println(max);
	}

	static void bfs() {
		que.offer(new Node(0, 0, 1));
		visit[map[0][0] - 'A'] = true;

		while (!que.isEmpty()) {
			Node node = que.poll();

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= R || nx >= C || visit[map[ny][nx] - 'A'])
					continue;

				que.offer(new Node(ny, nx, node.cnt + 1));
				visit[map[ny][nx] - 'A'] = true;

				max = Math.max(max, node.cnt + 1);
			}
		}
	}

	static class Node {
		int y;
		int x;
		int cnt;

		public Node(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
}
