// BOJ 10971번 외판원 순회 2 - 교수님 풀이 
// NP

package HW.D_0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10971__Pro_2_NP {

	static int N, sum, min;
	static int[][] matrix;

	static int[] src;
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		matrix = new int[N][N];
		src = new int[N];
		select = new boolean[N];

		for (int i = 0; i < N; i++) {
			src[i] = i;
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		min = Integer.MAX_VALUE;

		while (true) {
			check();

			if (!np())
				break;
		}

		System.out.println(min);
	}

	static void check() {
		int sum = 0;
		for (int i = 0; i < N - 1; i++) {
			int cost = matrix[src[i]][src[i + 1]];
			if (cost == 0)
				return;
			sum += cost;
		}

		int cost = matrix[src[N - 1]][src[0]];

		if (cost == 0)
			return;
		sum += cost;

		min = Math.min(min, sum);
	}

	static boolean np() {
		int i = N - 1;
		int j = i;
		int k = i;

		while (i > 0 && src[i - 1] >= src[i])
			i--;

		if (i == 0)
			return false;

		while (src[i - 1] >= src[j])
			j--;
		swap(src, i - 1, j);

		while (i < k) {
			swap(src, i++, k--);
		}

		return true;
	}

	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
