// BOJ 11286번 절댓값 힙 

package Class.D_0812;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286__Pro {

	static int N;
	static PriorityQueue<Integer> pqueue = new PriorityQueue<>(
			(n1, n2) -> Math.abs(n1) == Math.abs(n2) ? n1 - n2 : Math.abs(n1) - Math.abs(n2)); // integer를 natural
																								// ordering 순 (작은 수부터)

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) { // 꺼내서 출력, 없으면 null 0 출력
				Integer min = pqueue.poll();
				System.out.println(min == null ? 0 : min);
			} else {
				pqueue.offer(num);
			}
		}
	}

}