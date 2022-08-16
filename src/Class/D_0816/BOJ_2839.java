// BOJ 2839번 설탕 배달 

package Class.D_0816;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2839 {

	static int N, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = 0;
		int mod;

		if (N != 0) {
			while (true) {
				cnt += 3;
			}
		}
		
//		int mod = N % 5;
//		cnt = N / 5;
//		
//		if (mod % 3 == 0) {
//			cnt += mod / 3;
//		}
		
		System.out.println(cnt);

	}

}
