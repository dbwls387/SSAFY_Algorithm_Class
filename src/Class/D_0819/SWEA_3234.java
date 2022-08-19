// SWEA 3234번 준환이의 양팔저울 

package Class.D_0819;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3234 {

	static int T, N, cnt;
	static int[] src, tgt;
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			src = new int[N];
			select = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				src[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= N; i++) {
				tgt = new int[i];
				perm(0);
			}

			System.out.println("#" + t + " " + cnt);
		}
	}

	static void perm(int tgtIdx) {
		if (tgtIdx == tgt.length) {
			int left = 0;
			int right = 0;

//			System.out.println(Arrays.toString(tgt));

			for (int i = 0; i < src.length; i++) {
				for (int j = 0; j < tgt.length;) {
					if (right > left)
						return;

					if (src[i] == tgt[j]) {
						left += src[i];
						break;
					} else {
						right += src[i];
						break;
					}
				}
			}

			System.out.println("====");
			System.out.println(left + " " + right);

			if (right <= left)
				cnt++;

			return;
		}

		for (int i = 0; i < src.length; i++) {
			if (select[i])
				continue;

			tgt[tgtIdx] = src[i];
			select[i] = true;

			perm(tgtIdx + 1);
			select[i] = false;
		}
	}

}