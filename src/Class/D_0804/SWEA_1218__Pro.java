// 1218. [S/W 문제해결 기본] 4일차 - 괄호 짝짓기	- 교수님 코드 

package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// )))
// (((
// 유효성 판단의 근거는 stack이 비워져야 한다. 

public class SWEA_1218__Pro {

	static int N, ans;
	// static Stack<Character> stack = new Stack<>();
	static Deque<Character> stack = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			// 초기화
			stack.clear();
			ans = 0;

			N = Integer.parseInt(br.readLine());
			String str = br.readLine();

			for (int i = 0; i < N; i++) {
				char token = str.charAt(i);

				// 시작 문자 < { ..
				if (token == '<' || token == '{' || token == '(' || token == '[') {
					stack.push(token);
				} else { // 닫는 문자
					// 처음 닫는 문자가 온 경우, stack empty() => 유효하지 않다.
					if (stack.isEmpty()) {
						stack.push(token);
						break;
					}

					char prev = stack.peek();

					if (token == '>' && prev != '<')
						break;
					else if (token == '}' && prev != '{')
						break;
					else if (token == ')' && prev != '(')
						break;
					else if (token == ']' && prev != '[')
						break;
					else
						stack.pop();
				}
			}
			// 최종적인 유효성 판단은 stack empty 해야 한다.
			if (stack.isEmpty())
				ans = 1;
			System.out.println("#" + t + " " + ans);
		}
	}
}
