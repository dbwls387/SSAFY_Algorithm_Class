package HW.D_0801;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switch_cnt = Integer.parseInt(br.readLine());

		// 스위치 입력
		int[] arr = new int[switch_cnt + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= switch_cnt; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int student_cnt = Integer.parseInt(br.readLine()); // 학생 수
		for (int i = 1; i <= student_cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			if (gender == 1) { // 남학생이면
				for (int j = 1; j <= switch_cnt; j++) {
					if (j % n == 0) { // 스위치 번호가 자기가 받은 수의 배수이면
						arr[j] = (arr[j] == 1) ? 0 : 1;
					}
				}
			} else { // 여학생이면
				int first = n;
				int last = n;
				for (int j = 1; j < (switch_cnt) / 2; j++) {
					if (n - j < 1 || n + j > switch_cnt) {
						break;
					}
					if (arr[n - j] == arr[n + j]) {
						first = n - j;
						last = n + j;
					} else {
						break;
					}
				}
				for (int j = first; j <= last; j++) {
					arr[j] = (arr[j] == 1) ? 0 : 1;
				}
			}

		}

		for (int i = 1; i <= switch_cnt; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}

	}

}
