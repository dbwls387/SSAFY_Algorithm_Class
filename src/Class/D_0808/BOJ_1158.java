// BOJ 1158번 요세푸스 문제 

package Class.D_0808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158 {

	static int N, K;
	static Queue<Integer> que = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			que.offer(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		while (que.size() > 1) {
			for (int i = 0; i < K - 1; i++) {
				que.offer(que.poll());
			}
			sb.append(que.poll() + ", ");
		}

		sb.append(que.poll() + ">");

		System.out.println(sb);

	}

}
