// BOJ 1244번 스위치 켜고 끄기

package HW.D_0801;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {

	static int switch_cnt, student_cnt, gender, n;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		switch_cnt = Integer.parseInt(br.readLine());

		// 스위치 입력
		arr = new int[switch_cnt + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= switch_cnt; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		student_cnt = Integer.parseInt(br.readLine()); // 학생 수
		for (int i = 1; i <= student_cnt; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			if (gender == 1) { // 남학생이면
				male();
			} else { // 여학생이면
				female();
			}

		}

		// 결과 출력
		for (int i = 1; i <= switch_cnt; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}

	}

	static void male() {
		for (int j = n; j <= switch_cnt; j += n) {
			if (j % n == 0) { // 스위치 번호가 자기가 받은 수의 배수이면
				arr[j] = (arr[j] == 1) ? 0 : 1;
			}
		}
	}

	static void female() {
		arr[n] = arr[n] == 0 ? 1 : 0;
		int cnt = 1;
		while (n - cnt >= 1 && n + cnt <= switch_cnt) {
			if (arr[n - cnt] == arr[n + cnt]) { // 같으면
				arr[n - cnt] = arr[n - cnt] == 0 ? 1 : 0;
				arr[n + cnt] = arr[n + cnt] == 0 ? 1 : 0;
			} else {
				break;
			}
			cnt++;
		}
	}

}