import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {

	static int R, C, min, sx, sy;
	static char[][] map;
	static Queue<Node> waterQ = new ArrayDeque<>();

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
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*') {
					waterQ.add(new Node(i, j, 0));
				}
				if (map[i][j] == 'S') {
					sy = i;
					sx = j;
				}
			}
		}

		min = Integer.MAX_VALUE;

		bfs();

		System.out.println(min);

	}

	static void bfs() {
		Queue<Node> que = new ArrayDeque<>();
		que.offer(new Node(sy, sx, 0));

		while (!que.isEmpty()) {
			// 물 채우기
			int waterSize = waterQ.size();
			for (int i = 0; i < waterSize; i++) {
				Node water = waterQ.poll();

				for (int d = 0; d < 4; d++) {
					int ny = water.y + dy[d];
					int nx = water.x + dx[d];

					if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == 'D' || map[ny][nx] == 'X')
						continue;

					if (map[ny][nx] == '.') {
						map[ny][nx] = '*';
						waterQ.offer(new Node(ny, nx, 0));
					}
				}
			}

			// 고슴도치
			int gSize = que.size();
			for (int i = 0; i < gSize; i++) {
				Node node = que.poll();

				for (int d = 0; d < 4; d++) {
					int ny = node.y + dy[d];
					int nx = node.x + dx[d];

					if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == '*' || map[ny][nx] == 'X')
						continue;

					if (map[ny][nx] == 'D') {
						min = Math.min(min, node.d + 1);
						return;
					}

					if (map[ny][nx] == '.') {
						map[ny][nx] = 'S';
						map[node.y][node.x] = '.';
						que.offer(new Node(ny, nx, node.d + 1));
					}
				}
			}
		}
	}

	static class Node {
		int y;
		int x;
		int d;

		public Node(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}

}
