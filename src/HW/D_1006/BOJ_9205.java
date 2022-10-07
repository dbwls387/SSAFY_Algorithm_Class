// BOJ 9205번 맥주 마시면서 걸어가기 

package HW.D_1006;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9205 {

	static int T, n;
	static List<Node> list;
	static int[][] matrix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());

			list = new ArrayList<>();
			matrix = new int[n + 2][n + 2];

			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				list.add(new Node(x, y));
			}

			for (int i = 0; i < n + 2; i++) {
				for (int j = i + 1; j < n + 2; j++) {
					int dis = Math.abs(list.get(i).x - list.get(j).x) + Math.abs(list.get(i).y - list.get(j).y);

					if (dis <= 1000)
						matrix[i][j] = dis;
					else {	// 거리가 1000보다 크면 
						matrix[i][j] = -1;
						matrix[j][i] = -1;
					}
				}
			}

			for (int k = 0; k < n + 2; k++) {
				for (int i = 0; i < n + 2; i++) {
					if (k == i)
						continue;
					for (int j = 0; j < n + 2; j++) {
						if (i == j || j == k)
							continue;

						if (matrix[i][k] == -1 || matrix[k][j] == -1)
							continue;

						matrix[i][j] = 1;
					}
				}
			}
			
			if (matrix[0][n + 1] == -1)
				System.out.println("sad");
			else
				System.out.println("happy");
		}

	}

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
