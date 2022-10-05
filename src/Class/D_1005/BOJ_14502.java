// BOJ 14502번 연구소 

package Class.D_1005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {

	static int N, M, ans;
	static int[][] map, copy;
	static Queue<Node> que = new ArrayDeque<>();
	static boolean[][] visit;

	static int[] src;
	static int[] tgt = new int[3];
	static boolean[] select;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		copy = new int[N][M];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				copy[i][j] = n;
				if (n == 2)
					que.offer(new Node(i, j)); // 바이러스
			}
		}

		// 벽을 둘 세곳 조합으로 구하기 
		select = new boolean[N * M];
		src = new int[N * M];
		for (int i = 0; i < N * M; i++) {
			src[i] = i;
		}

		visit = new boolean[N][M];
		comb(0, 0);

		System.out.println(ans);
	}

	static void bfs() {
		// 바이러스 부분 que 채워주기 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 2)
					que.offer(new Node(i, j));
			}
		}
		
		while (!que.isEmpty()) {
			Node node = que.poll();
			visit[node.y][node.x] = true;

			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];

				if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 1 || map[ny][nx] == 2 || visit[ny][nx])
					continue;

				que.offer(new Node(ny, nx));
				map[ny][nx] = 2;
			}
		}

		// 안전 영역 개수 세기 (0) 
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					cnt++;
			}
		}

		ans = Math.max(ans, cnt);

		// visit 초기화 
		for (int i = 0; i < N; i++) {
			Arrays.fill(visit[i], false);
		}
	}

	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == 3) {

			// 맵 초기화
			copyMap();

			// 조합으로 얻은 벽을 둘 3곳 
			for (int i = 0; i < 3; i++) {
				int n = tgt[i];
				int y = n / M;
				int x = n % M;

				if (map[y][x] == 0)	// 벽 부분 1로 채워주기 
					map[y][x] = 1;
				else {	// 만약 거기가 빈 곳이 아니라면 다시 초기화 하고 return 
					copyMap();
					return;
				}
			}

			bfs();

			return;
		}

		for (int i = srcIdx; i < src.length; i++) {
			tgt[tgtIdx] = src[i];
			comb(i + 1, tgtIdx + 1);
		}
	}

	static void copyMap() {	// map 초기화 함수 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = copy[i][j];
				if(map[i][j] == 2)
					que.offer(new Node(i, j));
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
