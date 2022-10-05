// BOJ 17143번 낚시왕 

package Class.D_1005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17143 {

	static int R, C, M, ans;

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

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			shark.add(new Node(r, c, s, d, z, i));
		}

		for (int i = 1; i <= C; i++) {
			fishing(i);
		}

		System.out.println(ans);
	}

	static void fishing(int px) { // px 는 사람이 서있는 열

		System.out.println("----------------------");
		for (int i = 0; i < shark.size(); i++) {
			Node n = shark.get(i);
			System.out.println(n.y + ", " + n.x + " / i: " + n.i + " / 방향: " + n.d + " / 속력: " + n.s);
		}

		List<Node> list = new ArrayList<>();

		for (int i = 0; i < shark.size(); i++) {
			Node node = shark.get(i);

			if (node.x == px) {
				list.add(node);
			}
		}

		if (list.size() > 0) {
			int kill = list.get(0).y;
			int killIdx = 0;
			for (int i = 1; i < list.size(); i++) {
				if (kill > list.get(i).y) {
					kill = list.get(i).y;
					killIdx = i;
				}
			}
			Node sn = list.get(killIdx);
			ans += sn.z; // 잡은 상어 크기
			shark.remove(sn); // 가장 가까운 상어 잡기
		}

		bfs();
	}

	static void bfs() { // 상어 움직이기
		for (int i = shark.size() - 1; i >= 0; i--) {
			Node node = shark.get(i);

			int d = node.d;
			int ny = node.y;
			int nx = node.x;

			for (int j = 0; j < node.s; j++) {
				ny += dy[d];
				nx += dx[d];

				if (ny <= 1 || nx <= 1 || ny >= R || nx >= C) {
					if (d == 1)
						d = 2;
					else if (d == 2)
						d = 1;
					else if (d == 3)
						d = 4;
					else if (d == 4)
						d = 3;

					continue;
				}
			}

			node.y = ny;
			node.x = nx;
			node.d = d;
			
//			shark.remove(i);
//			shark.add(new Node(ny, nx, node.s, d, node.z, node.i));
		}

		// 같은 칸에 상어가 두마리 이상 있을 경우 ( 큰 상어가 나머지 상어를 잡아 먹음 )
		int size = shark.size();
		List<Node> samePlace = new ArrayList<>();

		int idx = 0;
		while (idx > size) {
			for (int j = idx + 1; j < size; j++) {
				Node A = shark.get(idx);
				Node B = shark.get(j);

				if (A.y == B.y && A.x == B.x) { // 상어가 같은 칸에 있을 때
					samePlace.add(A);
					samePlace.add(B);
				}
			}

			if (samePlace.size() > 0) {
				int max = samePlace.get(0).s;

				for (int j = 1; j < samePlace.size(); j++) {
					if (samePlace.get(j).s > max) {
						max = samePlace.get(j).s;
						shark.remove(samePlace.get(j - 1));
						size--;
					}
				}
			}

			idx++;
		}

	}

	static class Node {
		int y, x, s, d, z, i; // s: 속력, d: 이동 방향, z: 크기, i: shark 리스트에서의 idx

		public Node(int y, int x, int s, int d, int z, int i) {
			this.y = y;
			this.x = x;
			this.s = s;
			this.d = d;
			this.z = z;
			this.i = i;
		}
	}

}
