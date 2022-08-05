// BOJ 2164번 카드2

package Class.D_0805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_2164 {

	static Queue<Integer> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		while (queue.size() > 1) {
			queue.poll();
			int card = queue.poll();
			queue.offer(card);
		}
		
		System.out.println(queue.peek());
	}
}
