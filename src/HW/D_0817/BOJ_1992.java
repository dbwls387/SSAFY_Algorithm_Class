// BOJ 1992번 쿼드트리 

package HW.D_0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1992 {

	static int N;
	static String result = "";
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				arr[i][j] = temp[j] - '0';
			}
		}

		quad(0, 0, N);

		System.out.println(sb.toString());
	}

	static void quad(int x, int y, int N) {
		int num = arr[x][y];

		if (N == 1) {
			sb.append(num);
			return;
		}

		for (int i = x; i < x + N; i++) {
			for (int j = y; j < y + N; j++) {
				if (arr[i][j] != num) {
					N /= 2;
					sb.append("(");
					quad(x, y, N);
					quad(x, y + N, N);
					quad(x + N, y, N);
					quad(x + N, y + N, N);
					sb.append(")");
					return;
				}
			}
		}

		sb.append(num);
		return;
	}

}
