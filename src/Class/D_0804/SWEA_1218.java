// 1218. [S/W 문제해결 기본] 4일차 - 괄호 짝짓기

package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());

			String input = br.readLine();
			Stack<Character> stack = new Stack();

			for (int i = 0; i < n; i++) {
				char iChar = input.charAt(i);

				if (iChar == ')' && stack.peek() == '(') {
					stack.pop();
				} else if (iChar == ']' && stack.peek() == '[')
					stack.pop();
				else if (iChar == '}' && stack.peek() == '{')
					stack.pop();
				else if (iChar == '>' && stack.peek() == '<')
					stack.pop();
				else {
					stack.push(iChar);
				}
			}
			int result = 0;
			if (stack.isEmpty())
				result = 1;
			else
				result = 0;
			sb.append("#" + t + " " + result).append("\n");

		}
		System.out.println(sb.toString());
	}

}
