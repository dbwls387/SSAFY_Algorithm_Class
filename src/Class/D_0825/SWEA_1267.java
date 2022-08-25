// SWEA 1267번 [S/W 문제해결 응용] 10일차 - 작업순서

package Class.D_0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1267 {

	static int V, E;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();;
	static Queue<Integer> que = new ArrayDeque<>();
	static HashSet<Integer> hash = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int t = 1; t <= 1; t++) {
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= V; i++) {
				list.add(new ArrayList<>());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());

				list.get(v1).add(v2);
				hash.add(v1);
				hash.add(v2);
			}

			System.out.println(hash);
			System.out.println((list));
			
			for (int i = 0; i < hash.size(); i++) {
				
					
				
			}

		}

	}

}
