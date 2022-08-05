// BOJ 2493번 탑 

package Class.D_0805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {

	static int N;
	static Stack<Integer> stack = new Stack<>();
	static Stack<Integer> tmp = new Stack<>();
	static Stack<Integer> ans = new Stack<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			stack.push(Integer.parseInt(st.nextToken()));
		}

		int last, i = 1;
		while (stack.size() > 0) {
			last = stack.pop();
			while (i <= N) {
				if (i == N) {
					ans.push(0);
					break;
				}
				if (stack.peek() > last) {
					ans.push(N - i);
					tmpque();
					break;
				} else {
					tmp.push(stack.pop());
					i++;
				}
				i++;
			}
		}
		ans.push(0);
		while (ans.size() != 0) {
			System.out.print(ans.pop() + " ");
		}
	}

	static void tmpque() {
		while (tmp.size() > 0) {
			stack.push(tmp.pop());
		}
		tmp.clear();
		return;
	}
}
