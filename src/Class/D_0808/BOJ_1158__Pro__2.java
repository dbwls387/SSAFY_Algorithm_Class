// BOJ 1158번 요세푸스 문제 - 교수님 풀이
// Queue

package Class.D_0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158__Pro__2 {

	static int N, K;
	static Queue<Integer> que = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			que.offer(i);
		}

		// 변수들
		int alive = 1; // 1부터 계속 증가, 살아 있는 번호에서만 증가
		sb.append("<");

		while (!que.isEmpty()) {
			int num = que.poll();

			// alive % K == 0
			if (alive % K == 0) { // K번째 해당
				sb.append(num).append(", ");
			} else {
				que.offer(num);
			}
			alive++;
		}

		// 뒷부분 출력 정리
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb.toString());
	}

}
