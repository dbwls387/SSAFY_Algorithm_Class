// BOJ 1010번 다리 놓기 

package HW.D_0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010 {

	static int T;
	static double N, M, result;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			result = Comb(M, N);

			System.out.printf("%.0f\n", result);
		}
	}

	static double Comb(double n, double r) {
		double a = 1;
		double b = 1;

		for (double i = n; i > n - r; i--) {
			a *= i;
		}
		for (double i = r; i > 0; i--) {
			b *= i;
		}

		return a / b;
	}

}
