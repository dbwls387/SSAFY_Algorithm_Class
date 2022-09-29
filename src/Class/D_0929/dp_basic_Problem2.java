// DP 연습문제 2

package Class.D_0929;

import java.util.Arrays;

// 1cm 짜리 파란 막대와 1cm 짜리 노란 막대 그리고 2cm 짜리 빨간 막대가 있다. 
// 이 막대들을 연결하여 길이가 n cm인 막대를 만드는 방법의 수를 f(n)이라 하자. 

// 예를 들면 2cm 막대를 만드는 방법은 
// (파란 막대, 파란 막대, 
// (파란 막대, 노란 막대), 
// (노란 막대, 파란 막대), 
// (노란 막대, 노란 막대), 
// (빨간 막대)
// 5가지 이므로 f(2)=5 이다. 

// f(6)의 값은 ? 

public class dp_basic_Problem2 {

	static int[] dp = new int[7]; // 0 dummy

	public static void main(String[] args) {
		dp[1] = 2;
		dp[2] = 5;

		// f(i) = f(i-1), f(i-2) ... 규칙 
		for (int i = 3; i <= 6; i++) {
			// i 길이를 만들기 위해서는 
			// 우리가 가진 막대 (수단/선택)은 2가지 <= 길이가 1인 막대, 길이가 2인 막대
			// => 이전 길이 현재 길이를 완성할 때 길이는 1 늘어나거나, 2 늘어나거나
			// 길이 1개짜리를 연결하는 경우의 수는 i-1 길이의 경우의 수 X 길이가 1인 막대의 수
			// 길이 2개짜리를 연결하는 경우의 수는 i-2 길이의 경우의 수 X 길이가 2인 막대의 수
			
			dp[i] = (dp[i - 1] * 2) + dp[i - 2];
		}
		
		System.out.println(Arrays.toString(dp));
	}

}