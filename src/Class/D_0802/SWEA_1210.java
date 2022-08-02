// SWEA 1210번 [S/W 문제해결 기본] 2일차 - Ladder1

package Class.D_0802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210 {

	// 좌-우
	static int[] dx = { -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 1; t++) {
			int num = Integer.parseInt(br.readLine());

			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int finish = 0;
			for (int i = 0; i < 100; i++) {
				if (arr[99][i] == 2) {
					finish = i;
				}
			}
			
			for (int j = 98; j >= 0; j--) {
				for (int d = 0; d < 2; d++) {
					int nx = finish + dx[d];

					if (nx < 0 || nx > 99) {
						continue;
					}
					if (arr[j][finish - 1] == 1) {
						while (arr[j][finish - 1] == 1) {
							nx = finish + dx[d];

							if (nx < 0 || nx > 99) {
								continue;
							}
							finish -= 1;
						}
					} else if (arr[j][finish + 1] == 1) {
						while (arr[j][finish + 1] == 1) {
							nx = finish + dx[d];

							if (nx < 0 || nx > 99) {
								continue;
							}
							finish += 1;
						}
					}
				}
			}

			System.out.println("#" + num + " " + finish);


		}
	}

}
