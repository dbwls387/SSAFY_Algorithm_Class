// JUNG-OL 1828번 냉장고 

package HW.D_0816;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JO_1828 {

	static int N, cnt;
	static int[][] tem;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = 1;

		tem = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tem[i][0] = Integer.parseInt(st.nextToken()); // 최저온도
			tem[i][1] = Integer.parseInt(st.nextToken()); // 최고온도
		}

		// 최고 온도 오름차순 정렬
		Arrays.sort(tem, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});

		int max = tem[0][1];
		for (int i = 0; i < N; i++) {
			if (tem[i][0] <= max) {
				if (tem[i][1] < max) {
					max = tem[i][1];
				}
				continue;
			} else {
				max = tem[i][1];
				cnt++;
			}
		}

		System.out.println(cnt);
	}

}
