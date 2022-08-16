// BOJ 1074번 Z 

package Class.D_0816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {

	static int N, r, c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int size, visit = 0;
		while (N > 0) {
			size = (int) Math.pow(2, (--N));

			if (r < size && c < size) {
				visit += 0;
			} else if (r < size && c >= size) {
				visit += size * size;
				c -= size;
			} else if (r >= size && c < size) {
				visit += size * size * 2;
				r -= size;
			} else {
				visit += size * size * 3;
				r -= size;
				c -= size;
			}
		}

		System.out.println(visit);
	}

}
