// BOJ 16935번 배열 돌리기 3

package Class.D_0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935 {

	static int N, M, R, O;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			O = Integer.parseInt(st.nextToken());
			
			if (O == 1) {
				op1();
			} else if (O == 2) {
				op2();
			} else if (O == 3) {
				op3();
			} else if (O == 4) {
				op4();
			} else if (O == 5) {
				op5();
			} else if (O == 6) {
				op6();
			}
		}

		int n = arr.length;
		int m = arr[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void op1() { // 상하 반전
		int n = arr.length; // ARRAY : 기존 입력값 배열 static
		int m = arr[0].length;

		int[][] result = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[n - 1 - i][j] = arr[i][j];
			}
		}

		arr = result;

		return;
	}

	static void op2() { // 좌우 반전
		int n = arr.length; // ARRAY : 기존 입력값 배열 static
		int m = arr[0].length;

		int[][] result = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[i][m - 1 - j] = arr[i][j];
			}
		}

		arr = result;

		return;
	}

	static void op3() { // rot_right
		int n = arr.length; // ARRAY : 기존 입력값 배열 static
		int m = arr[0].length;

		int[][] ARRAY = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				ARRAY[i][n - 1 - j] = arr[j][i];
			}
		}

		arr = ARRAY;

		return;
	}

	static void op4() { // rot_left
		int n = arr.length;
		int m = arr[0].length;

		int[][] ARRAY = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				ARRAY[i][j] = arr[j][m - 1 - i];
			}
		}

		arr = ARRAY;

		return;
	}

	static void op5() { // 그룹 시계방향으로 이동
//		// 그룹 1, 4
//		int check = 0;
//		int idx_1 = N / 2;
//		int idx_4 = 0;
//		for (int j = 0; j < N; j++) {
//			if (check == 0) {
//				for (int i = 0; i < M / 2; i++) {
//					System.out.print(arr[idx_1][i] + " ");
//					check = 1;
//				}
//				idx_1++;
//			} else {
//				for (int i = 0; i < M / 2; i++) {
//					System.out.print(arr[idx_4][i] + " ");
//					check = 0;
//				}
//				idx_4++;
//				System.out.println();
//			}
//		}
//
//		// 그룹 2, 3
//		int idx_2 = N / 2;
//		int idx_3 = 0;
//		for (int j = 0; j < N; j++) {
//			if (check == 0) {
//				for (int i = M / 2; i < M; i++) {
//					System.out.print(arr[idx_2][i] + " ");
//					check = 1;
//				}
//				idx_2++;
//			} else {
//				for (int i = M / 2; i < M; i++) {
//					System.out.print(arr[idx_3][i] + " ");
//					check = 0;
//				}
//				idx_3++;
//				System.out.println();
//			}
//		}

		int n = arr.length;
		int m = arr[0].length;

		int[][] result = new int[n][m];

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				result[i][m / 2 + j] = arr[i][j];
			}
		}

		for (int i = 0; i < n / 2; i++) {
			for (int j = m / 2; j < m; j++) {
				result[i + n / 2][j] = arr[i][j];
			}
		}

		for (int i = n / 2; i < n; i++) {
			for (int j = m / 2; j < m; j++) {
				result[i][j - m / 2] = arr[i][j];
			}
		}

		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				result[i - n / 2][j] = arr[i][j];
			}
		}

		arr = result;
		
		return;
	}

	static void op6() { // 그룹 반시계 방향 이동
		int n = arr.length;
		int m = arr[0].length;

		int[][] ARRAY = new int[n][m];

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				ARRAY[n / 2 + i][j] = arr[i][j];
			}
		}

		for (int i = 0; i < n / 2; i++) {
			for (int j = m / 2; j < m; j++) {
				ARRAY[i][j - m / 2] = arr[i][j];
			}
		}

		for (int i = n / 2; i < n; i++) {
			for (int j = m / 2; j < m; j++) {
				ARRAY[i - n / 2][j] = arr[i][j];
			}
		}

		for (int i = n / 2; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				ARRAY[i][m / 2 + j] = arr[i][j];
			}
		}

		arr = ARRAY;

		return;
	}

}
