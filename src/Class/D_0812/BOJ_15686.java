// BOJ 15686번 치킨 배달 

package Class.D_0812;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686 {

	static int N, M, min, result;
	static int[][] map;
	static ArrayList<int[]> chicken = new ArrayList<>();
	static ArrayList<int[]> house = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					int[] input = { i, j };
					chicken.add(input);
				}
				if (map[i][j] == 1) {
					int[] input = { i, j };
					house.add(input);
				}
			}
		}

		min = Integer.MAX_VALUE;
		for (int i = 0; i < house.size(); i++) {
			dfs(0, 0, i);

			result += min;
			min = 0;
		}

		System.out.println(result);
	}

	static void dfs(int srcIdx, int storeIdx, int houseIdx) {

		int curr_dir = Math.abs(chicken.get(storeIdx)[0] - house.get(houseIdx)[0])
				+ Math.abs(chicken.get(storeIdx)[1] - house.get(houseIdx)[1]);

		if (srcIdx == M) {
			min = Math.min(min, curr_dir);

			return;
		}

		dfs(srcIdx + 1, storeIdx, houseIdx);
		dfs(srcIdx + 1, storeIdx + 1, houseIdx);
	}

}
