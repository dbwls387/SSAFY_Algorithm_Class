package Class.D_0801;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1290__3 {

	// Scanner -> BufferedReader
	// local 변수 중 주요 변수들을 -> static
	// int[] -> char[]
	// String toCharArray()
	
	static int T, count;
	static char[] input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			count = 0; // 변경 건수

			input = br.readLine().toCharArray();	// 배열을 새로 생성해서 return 
			
			// 현재 문자 
			char current = '0';

			int cnt = input.length;

			// 현재의 값과 input[i]를 비교해서 다르면 변경횟수가 증가하는 시점 
			for (int i = 0; i < cnt; i++) {
				if(input[i] != current) {
					count++;
				}
				
				current = input[i];
			}

			System.out.println("#" + t + " " + count);
		}

	}

}
