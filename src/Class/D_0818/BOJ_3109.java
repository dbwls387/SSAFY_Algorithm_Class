// BOJ 3109번 빵집 

package Class.D_0818;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109 {

	static int R, C, cnt;
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				arr[i][j] = tmp[j];
			}
		}

		cnt = 0;
		for (int i = 0; i < R; i++) {
			if (pipe(i, 0)) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	static boolean pipe(int x, int y) {
		if (y == C - 1) {
			return true;
		}

		arr[x][y] = 'x';

		if (x - 1 >= 0 && arr[x - 1][y + 1] == '.')
			if (pipe(x - 1, y + 1))
				return true;

		if (arr[x][y + 1] == '.')
			if (pipe(x, y + 1))
				return true;

		if (x + 1 <= R - 1 && arr[x + 1][y + 1] == '.')
			if (pipe(x + 1, y + 1))
				return true;

		return false;
	}

}
