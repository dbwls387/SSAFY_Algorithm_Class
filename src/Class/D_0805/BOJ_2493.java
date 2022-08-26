// BOJ 2493번 탑 

package Class.D_0805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2493 {

	static int N;
	static Deque<int[]> stack = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int height = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty()) {
				if (stack.peek()[1] >= height) {
					sb.append(stack.peek()[0]).append(' ');
					break;
				}
				stack.pop();
			}

			if (stack.isEmpty()) {
				sb.append("0 ");
			}

			stack.push(new int[] { i, height });
		}

		System.out.println(sb);
	}

}
