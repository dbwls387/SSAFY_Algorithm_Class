// SWEA 6808번 규영이와 인영이의 카드게임

package Class.D_0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808 {

	static int T;
	static int[] ky = new int[9];
	static int[] iy = new int[9];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				ky[i] = Integer.parseInt(st.nextToken());
			}

			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				int check = 0;
				for (int j = 0; j < 9; j++) {
					if (ky[j] == i) {
						check = 1;
						break;
					}
				}
				if (check == 0) {
					iy[idx++] = i;
				}
			}

			
			
		}
	}

	static void card() {

	}

}
