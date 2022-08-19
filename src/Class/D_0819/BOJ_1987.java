// BOJ 1987번 알파벳

package Class.D_0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1987 {

	static int R, C, cnt;
	static char[][] board;
	static boolean[] visited = new boolean[26];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}

		cnt = 1;

		visited[board[0][0] - 'A'] = true;
		dfs(0, 0);

		System.out.println(Arrays.toString(visited));
		System.out.println(cnt);
	}

	static void dfs(int x, int y) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visited[board[i][j] - 'A']) {
					continue;
				}
				visited[board[i][j] - 'A'] = true;
				
				cnt++;
				dfs(i, j);
			}
		}
//		visited[board[x][y] - 'A'] = false;
	}

}
