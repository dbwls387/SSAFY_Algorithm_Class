// BOJ 12891번 DNA 비밀번호 - 교수님 풀이 
// cnt 를 배열로 푸는 방법 

package Class.D_0805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12891__Pro__2 {

	static int S, P, ans;
	static char[] dna;
	static int minA, minC, minG, minT;
	
	// A B C D E F G H I J K  L  M  N  O  P  Q  R  S  T 
	// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
	static int[] cnt = new int[20];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		dna = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine());
		minA = Integer.parseInt(st.nextToken());
		minC = Integer.parseInt(st.nextToken());
		minG = Integer.parseInt(st.nextToken());
		minT = Integer.parseInt(st.nextToken());

		solve();
		System.out.println(ans);
	}

	static void solve() {
		// 시작 P개 부분 문자열부터 확인
		for (int i = 0; i < P; i++) 
			cnt[dna[i] - 'A']++;
		
		// 시작 P 에 대해서 확인
		check();

		for (int i = P; i < S; i++) {
			// 하나는 버리고 새로 하나를 취한다. 버리는 것은 맨 앞, 취하는 건 맨 뒤 => 중간에 있는 것들은 재사용
			// dna[i-P]
			cnt[dna[i - P] - 'A']--;
			cnt[dna[i] - 'A']++;
			
			// 새로운 부분 문자열을 확인
			check();
		}
	}

	// 부분 문자열이 조건에 맞는지 확인
	static void check() {
		if (cnt[0] >= minA && cnt[2] >= minC && cnt[6] >= minG && cnt[19] >= minT) {
			ans++;
		}
	}
}
