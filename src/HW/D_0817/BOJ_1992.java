// BOJ 1992번 쿼드트리 

package HW.D_0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1992 {

	static int N;
	static String result = "";
	static int[][] arr;

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

		quad(0, 0);
	}

	static void quad(int y, int x) {
		if (N == 1)
			return;

		System.out.print("(");
		N /= 2;

		for (int i = y; i < y + N; i++) {
			for (int j = x; j < x + N; j++) {
				if (arr[i][j] == 1) {
					
				}
			}
		}
	}

}
