// BOJ 16236번 아기 상어 

package Class.D_0824;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {

	static int N, min;
	static int[][] map;
	static PriorityQueue<Node> fishQ = new PriorityQueue<>((e1, e2) -> e2.y - e1.y);
	static Queue<Node> sharkQ = new ArrayDeque<>();

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;

				if (n == 9) {
					sharkQ.offer(new Node(i, j, 2, 0));
				}
			}
		}

		min = Integer.MAX_VALUE;
		bfs();

	}

	static void bfs() {

		int cnt = 0;

		int qSize = sharkQ.size();
		for (int q = 0; q < qSize; q++) {
			Node shark = sharkQ.poll();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (0 < map[i][j] && map[i][j] < shark.size) {
						fishQ.offer(new Node(i, j, map[i][j], 0));
					}
				}
			}

			int fishSize = fishQ.size();
			for (int f = 0; f < fishSize; f++) {
				Node fish = fishQ.poll();

				for (int d = 0; d < 4; d++) {
					int ny = shark.y + dy[d];
					int nx = shark.x + dx[d];

					if (ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] > shark.size)
						continue;

					if (fish.y == ny && fish.x == nx) {
						cnt++;
						min = Math.min(min, shark.d + 1);
						map[ny][nx] = 9;
						sharkQ.offer(new Node(ny, nx, shark.size, 0));

						System.out.println(min);
						return;
					}

					if (0 < map[ny][nx] && map[ny][nx] < shark.size) {
						sharkQ.offer(new Node(ny, nx, shark.size, shark.d + 1));
					}

					if (cnt == shark.size) {
						sharkQ.offer(new Node(ny, nx, shark.size + 1, shark.d));
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}

		}
	}

	static class Node {
		int y, x, size, d;

		public Node(int y, int x, int size, int d) {
			this.y = y;
			this.x = x;
			this.size = size;
			this.d = d;
		}
	}

}
