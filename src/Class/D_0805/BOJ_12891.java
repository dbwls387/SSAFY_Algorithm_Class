// BOJ 12891번 DNA 비밀번호

package Class.D_0805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12891 {

	static int S, P, cnt;
	static char[] dna, tgt;
	static int[] dna_cnt, check_cnt;
	
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		select = new boolean[S];
		tgt = new char[P];
		
		dna = br.readLine().toCharArray();

		dna_cnt = new int[4];
		check_cnt = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			dna_cnt[i] = Integer.parseInt(st.nextToken());
		}
		
		if (check() == 1) {
			make();
		} else {
			cnt = 0;
		}
		
//		perm(0, 0);
		
		System.out.println(cnt);
	}

	static void make() {
		for (int i = 0; i < S; i++) {
			
		}
	}
	
	static int check() {
		for (int i = 0; i < S; i++) {
			if (dna[i] == 'A') check_cnt[0]++;
			else if(dna[i] == 'C') check_cnt[1]++;
			else if(dna[i] == 'G') check_cnt[2]++;
			else if(dna[i] == 'T') check_cnt[3]++;
		}
		
		if (dna_cnt[0] <= check_cnt[0]) 
			if (dna_cnt[1] <= check_cnt[1]) 
				if (dna_cnt[2] <= check_cnt[2]) 
					if (dna_cnt[3] <= check_cnt[3]) {
						return 1;
					}
		
		return 0;
	}

//	static int check(char[] tgt) {
//		for (int i = 0; i < tgt.length; i++) {
//			System.out.print(tgt[i]+" ");
//			if (tgt[i] == 'A') check_cnt[0]++;
//			else if(tgt[i] == 'C') check_cnt[1]++;
//			else if(tgt[i] == 'G') check_cnt[2]++;
//			else if(tgt[i] == 'T') check_cnt[3]++;
//		}
//		System.out.println();
//		System.out.println(Arrays.toString(check_cnt));
//		System.out.println();
//		
//		
//		if (dna_cnt[0] >= check_cnt[0]) 
//			if (dna_cnt[1] >= check_cnt[1]) 
//				if (dna_cnt[2] >= check_cnt[2]) 
//					if (dna_cnt[3] >= check_cnt[3]) {
//						cnt++;
//						return 1;
//					}
//		
//		return 0;
//	}

//	static void perm(int srcIdx, int tgtIdx) {
//		// 기저조건
//		if (tgtIdx == tgt.length) {
//			check(tgt);
//			for (int i = 0; i < 4; i++)
//				check_cnt[i] = 0;
//
//			return;
//		}
//
//		if (srcIdx == S) {
//			return;
//		}
//
//		tgt[tgtIdx] = dna[srcIdx];
//
//		perm(srcIdx + 1, tgtIdx + 1);
//		perm(srcIdx + 1, tgtIdx);
//	}
}
