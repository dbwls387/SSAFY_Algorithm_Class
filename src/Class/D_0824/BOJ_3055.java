// BOJ 3055번 탈출

package Class.D_0824;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import Class.D_0824.BOJ_7576.Node;

public class BOJ_3055 {

	static int R, C, time, result;
	static char[][] map;
	static boolean[][] visited;
	static Queue<Node> waterQ = new LinkedList<>();

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int sx = 0, sy = 0;
		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					sy = i;
					sx = j;
				}

				if (map[i][j] == '*')
					waterQ.offer(new Node(i, j));
			}
		}

		visited = new boolean[R][C];
		time = 1;
		result = 0;
		bfs(sy, sx);

		if (result == 1)
			System.out.println(time);
		else
			System.out.println("KAKTUS");
	}

	static void bfs(int y, int x) {
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(y, x));
		visited[y][x] = true;

		// S 움직이기
		while (!que.isEmpty()) {
			// 물 퍼져나가기
			int size = waterQ.size();
			for (int i = 0; i < size; i++) {
				Node water = waterQ.poll();

				for (int d = 0; d < 4; d++) {
					int ny = water.y + dy[d];
					int nx = water.x + dx[d];

					if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == 'X' || map[ny][nx] == '*'
							|| map[ny][nx] == 'D')
						continue;

					map[ny][nx] = '*';
					waterQ.offer(new Node(ny, nx));
				}
			}

			Node node = que.poll();

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= R || nx >= C || visited[ny][nx])
					continue;

				if (map[ny][nx] == 'D') {
					result = 1;
					return;
				}

				if (map[ny][nx] == '.') {
					time++;
					map[ny][nx] = 'S';

					que.offer(new Node(ny, nx));
					visited[ny][nx] = true;

				}
			}

			System.out.println("-------------------------");
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
