// BOJ 1541번 잃어버린 괄호 

package Class.D_0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1541__Pro__2 {

	static int sum;

	// 2-34+56+78-9-10+11
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stMinus = new StringTokenizer(br.readLine(), "-");

//		while(stMinus.hasMoreToken()) {
//			
//		}

		int sizeMinus = stMinus.countTokens(); // 현재 시점에 남아 있는 토큰 수
		for (int i = 0; i < sizeMinus; i++) {
			String token = stMinus.nextToken();

			int num = 0;
			StringTokenizer stPlus = new StringTokenizer(token, "+");
			int sizePlus = stPlus.countTokens();

			for (int j = 0; j < sizePlus; j++) {
				num += Integer.parseInt(stPlus.nextToken());
			}

			if (i == 0) // 맨 앞 숫자
				sum = num;
			else
				sum -= num;
		}
		
		System.out.println(sum);
	}

}
