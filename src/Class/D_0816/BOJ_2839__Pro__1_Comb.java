// BOJ 2839번 설탕 배달 - 교수님 풀이 
// 완탐 -> 코드 작성은 가능하지만, 시간 초과가 남 -> 그리디로 풀기 

package Class.D_0816;

import java.util.Scanner;

public class BOJ_2839__Pro__1_Comb {

	static int N, min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		min = 5000;

		comb(0, 0);

		min = min == 5000 ? -1 : min;

		System.out.println(min);
	}

	static void comb(int five, int three) {
		int sum = five * 5 + three * 3;

		if (sum == N) { // 2종류의 봉투로 Nkg을 만들었다.
			min = Math.min(min, five + three);
			return;
		} else if (sum > N) { // N 초과
			return;
		}

		// 5kg 하나 더 쓰던가, 3kg 하나 더 쓰던가
		comb(five + 1, three);
		comb(five, three + 1);
	}
}
