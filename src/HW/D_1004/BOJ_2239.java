// BOJ 2239번 스도쿠 

package HW.D_1004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2239 {

	static int[][] map = new int[9][9];
	static ArrayList<Node> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				map[i][j] = tmp[j] - '0';
				if (map[i][j] == 0)
					list.add(new Node(i, j));
			}
		}

		func(0);
	}

	static void func(int depth) {
		if (list.size() == depth) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

			System.exit(0);
		}

		int y = list.get(depth).y;
		int x = list.get(depth).x;

		boolean[] check = new boolean[10];

		for (int i = 0; i < 9; i++) {
			if (map[y][i] != 0)
				check[map[y][i]] = true;
		}

		for (int i = 0; i < 9; i++) {
			if (map[i][x] != 0)
				check[map[i][x]] = true;
		}

		int sy = (y / 3) * 3;
		int sx = (x / 3) * 3;
		for (int i = sy; i < sy + 3; i++) {
			for (int j = sx; j < sx + 3; j++) {
				if (map[i][j] != 0) {
					check[map[i][j]] = true;
				}
			}
		}

		for (int i = 1; i <= 9; i++) {
			if (!check[i]) {
				map[y][x] = i;
				func(depth + 1);
				map[y][x] = 0;
			}
		}
	}

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
