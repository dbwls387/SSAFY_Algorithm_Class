// BOJ 1339번 단어 수학 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1339 {

	static int N;
	static int[] num = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
	static int[] alphabet = new int[26];
	static String[] word;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		word = new String[N];
		for (int i = 0; i < N; i++) {
			word[i] = br.readLine();
		}

		/*
		int leng = 0;
		for (int i = 0; i < word.length; i++) {
			char[] ch = word[i].toCharArray();
			leng += ch.length;
		}
		char[] ch = new char[leng];

		int num_idx = 0;
		int idx = 0;
		int n = 0;
		for (int i = 0; i < leng; i++) {
			char[] str = word[n++].toCharArray();
			if (alphabet[str[idx] - 65] == 0) {
				alphabet[str[idx++] - 65] = num[num_idx++];
			}
			if (n == N - 1) {
				n = 0;
			}
		}
		*/

		
		
		System.out.println(Arrays.toString(alphabet));
	}

}
