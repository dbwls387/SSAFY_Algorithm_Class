// BOJ 9205번 맥주 마시면서 걸어가기 - 교수님 풀이

package HW.D_1006;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9205__Pro {

	static int T, N, V;
	static final int BIG = 101 * 23767 * 2;
	static int[][] input;
	static int[][] matrix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			V = N + 2;

			input = new int[V][N];
			matrix = new int[V][V];

			for (int i = 0; i < V; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				input[i][0] = Integer.parseInt(st.nextToken()); // x
				input[i][1] = Integer.parseInt(st.nextToken()); // y
			}

			// 입력 => 인접행렬
			for (int i = 0; i < V; i++) {
				// 현재 따지는 i 정점의 좌표
				int vy = input[i][0];
				int vx = input[i][1];

				for (int j = 0; j < V; j++) {
					if (i == j)
						continue;
					int ty = input[j][0];
					int tx = input[j][1];
					int dis = Math.abs(ty - vy) + Math.abs(tx - vx); // 맨하튼 거리

					// 중요 !
					// 만약 dis > 50*20 = 1000 => 연결 X / 갈 수 없다. <= BIG
//					if (dis > 1000) {
//						matrix[i][j] = BIG;
//					} else {
//						matrix[i][j] = dis;
//					}

					matrix[i][j] = dis > 1000 ? BIG : dis;
				}
			}

			// 플로이드 워셜 적용
			for (int k = 0; k < V; k++) { // 경유지
				for (int i = 0; i < V; i++) { // 출발지
					if (k == i)
						continue;
					for (int j = 0; j < V; j++) { // 도착지
						if (i == j || j == k)
							continue;

						// 최소값 선택 : i -> j 비용 vs i -> k 비용 + k -> j 비용의 합
						matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
					}
				}
			}

			// 모든 정점에서 다른 정점으로 가는 최소 비용이 matrix 인접행렬에 계산되었음
			// 인접 행렬에는 갈 수 없는 구간은 BIG

			// 집 --> 공연장
			// 집[0] --> 공연장 [V-1]

			System.out.println(matrix[0][V - 1] != 0 && matrix[0][V - 1] < BIG ? "happy" : "sad");
		}
	}

}
