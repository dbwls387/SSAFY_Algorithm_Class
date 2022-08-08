// BOJ 1158번 요세푸스 문제 - 교수님 풀이 
// Circular Array

package Class.D_0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1158__Pro__3 {

	static int N, K;
	static int[] input;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = i + 1;
		}

		// 변수들
		int count = 0; // 죽은 사람이 결정되면 하나씩 증가 => 모두 죽으면 count == N 종료
		int idx = 0; // 순회하는 index, 죽은 사람이 결정되면 그 사람 input[idx] = 0 으로
		int step = 1; // 1부터 증가, 살아있는 사람을 계산

		sb.append("<");
		while (true) {
			// 기저 조건
			if (count == N)
				break;

			int newIdx = idx % N;
			if (input[newIdx] != 0) { // 살아 있는
				if (step % K == 0) { // 살아 있는 사람 중에 K 번째
					sb.append(input[newIdx]).append(", ");
					input[newIdx] = 0;
					count++;
				}
				step++;
			}
			idx++;

			// 필요 X
//			if (idx > N)
//				idx = 1;
		}

		// 뒷부분 출력 정리
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb.toString());

	}

}
