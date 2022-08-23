import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 12891번 DNA 문자열 

public class BOJ_12891 {

	static int S, P;
	static String str;
	static int aCnt, cCnt, gCnt, tCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		str = br.readLine();

		st = new StringTokenizer(br.readLine());
		aCnt = Integer.parseInt(st.nextToken());
		cCnt = Integer.parseInt(st.nextToken());
		gCnt = Integer.parseInt(st.nextToken());
		tCnt = Integer.parseInt(st.nextToken());
		
		
	}

}
