// BOJ 2023번 신기한 소수 

package Class.D_0805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2023 {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		boolean[] isPrime = new boolean[10000];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i * i <= 9999; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= 9999; j += i) {
					isPrime[j] = false;
				}
			}
		}
		for (int i = 1000; i <= 9999; i++) {
			if (isPrime[i]) {
				System.out.println(i);
			}
		}

	}

}
