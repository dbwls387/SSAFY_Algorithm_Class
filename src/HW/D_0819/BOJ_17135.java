// BOJ 17135번 캐슬 디펜스

package HW.D_0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17135 {

	static int N, M, D, max;
	static ArrayList<Node> enemy = new ArrayList<>();
	static int[] src, tgt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		src = new int[M];
		tgt = new int[3];
		for (int i = 0; i < M; i++) {
			src[i] = i;
		}

		int e;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				e = Integer.parseInt(st.nextToken());
				if (e == 1)
					enemy.add(new Node(j, i));
			}
		}

		max = 0;
		Comb(0, 0);

		System.out.println(max);
	}

	static void game(int[] Archer) {
		int row = N;
		int cnt = 0;
		boolean[] state = new boolean[enemy.size()]; // 적의 상태
		Arrays.fill(state, true); // 적이 모두 살아있는 걸로 초기화

		while (row > 0) { // 한 루프 : 적이 한 칸씩 내려오는 거
			// 같은 적을 죽일 수 있다는 조건 때문에 적을 그때 그때 처리하면 오류 발생
			// -> 이렇게 저장해두고 한꺼번에 처리해야 함
			Node[] kill = new Node[3]; // 죽일 적들을 담을 배열

			for (int i = 0; i < 3; i++) { // 궁수 수 만큼
				int min = D;

				Node archer = new Node(Archer[i], row); // 궁수의 좌표
				kill[i] = new Node(M, row); // 젤 오른쪽 값으로 우선 초기화

				for (int j = 0; j < state.length; j++) {
					if (!state[j]) // 이미 죽은 적
						continue;

					Node e = enemy.get(j);
					int dis = distance(archer, e);	// 궁수와 적의 거리 

					if ((dis == min && e.x < kill[i].x) || (dis < min)) {
						// 거리가 같으면서 왼쪽에 있거나, 거리가 더 작으면 -> min, 좌표 갱신
						min = dis;
						kill[i] = e;
					}
				}
			}

			row--; // 앞으로 이동
			for (int i = 0; i < state.length; i++) {
				for (int j = 0; j < kill.length; j++) {
					if ((kill[j].x == enemy.get(i).x) && (kill[j].y == enemy.get(i).y) && state[i]) {
						// 동시에 같은 적을 죽일 경우를 대비
						// kill 배열에 있는 적이 이미 해치운 적인지 확인하며 cnt++
						cnt++;
						state[i] = false;
					}
				}
				if (enemy.get(i).y == row) { // 성에 도착한 적 제외
					state[i] = false;
				}
			}
		}

		max = Math.max(max, cnt);
	}

	static int distance(Node a, Node b) {
		return Math.abs(b.x - a.x) + Math.abs(b.y - a.y);
	}

	static void Comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == 3) {
			game(tgt);

			return;
		}

		for (int i = srcIdx; i < M; i++) {
			tgt[tgtIdx] = src[i];
			Comb(i + 1, tgtIdx + 1);
		}
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
