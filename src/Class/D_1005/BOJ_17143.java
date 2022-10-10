// BOJ 17143번 낚시왕 

package Class.D_1005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOJ_17143 {

	static int R, C, M, ans;
	static Node[][] map;

	static List<Node> shark = new ArrayList<>();

	// dummy-상-하-우-좌
	static int[] dy = { 0, -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new Node[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			shark.add(new Node(r, c, s, d, z));
			map[r][c] = new Node(r, c, s, d, z);
		}

		for (int i = 1; i <= C; i++) {
			fishing(i); // 낚시왕이 있는 열에서 땅과 제일 가까운 상어 잡기
			bfs(); // 상어 이동
			samePlace(); // 같은 칸에 있는 상어 잡아먹기
		}

		System.out.println(ans);
	}

	static void fishing(int px) { // px는 낚시왕이 서있는 열
		for (int i = 1; i <= R; i++) {
			if (map[i][px] != null) {
				ans += map[i][px].z;
				shark.remove(map[i][px]);
				map[i][px] = null;

				return;
			}
		}
	}

	static void bfs() { // 상어 이동
		int size = shark.size();

		for (int i = 0; i < size; i++) {
			Node node = shark.get(i);

			int ny = node.y;
			int nx = node.x;

			int d = node.d; // 방향
			int s = node.s; // 속력

			for (int j = 0; j < s; j++) {
				if (ny == 1 && d == 1)
					d = 2;
				else if (ny == R && d == 2)
					d = 1;
				else if (nx == 1 && d == 4)
					d = 3;
				else if (nx == C && d == 3)
					d = 4;

				ny += dy[d];
				nx += dx[d];
			}

			node.y = ny;
			node.x = nx;
			node.d = d;
		}

	}

	static void samePlace() {
		// map 초기화
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = null;
			}
		}

		// map에 현재 상어 정보 집어넣기
		int size = shark.size();
		for (int i = size - 1; i >= 0; i--) {
			Node node = shark.get(i);

			// 겹치는 상어가 존재할 경우
			if (map[node.y][node.x] != null) {
				int curShark = map[node.y][node.x].z;
				int nextShark = node.z;

				// 현재 맵에 있는 상어보다 크면 얘로 넣어주기
				if (nextShark > curShark) {
					shark.remove(map[node.y][node.x]);
					map[node.y][node.x] = node;
				} else {
					shark.remove(node);
				}
			} else {
				map[node.y][node.x] = node;
			}
		}
	}

	static class Node {
		int y, x, s, d, z; // (r, c): 상어 위치 , s: 속력, d: 이동 방향, z: 크기

		public Node(int y, int x, int s, int d, int z) {
			this.y = y;
			this.x = x;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Node) {
				Node n = (Node) o;
				if (this.y == n.y && this.x == n.x && this.s == n.s && this.d == n.d && this.z == n.z) {
					return true;
				}
				return false;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return Objects.hash(y, x, s, d, z);
		}
	}

}
