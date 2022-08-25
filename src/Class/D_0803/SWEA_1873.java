// SWEA 1873번 상호의 배틀필드 

package Class.D_0803;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873 {

	static int H, W, N;
	static char[][] map;
	static char[] input;

	// 상-하-좌-우
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];

			int sx = 0, sy = 0;
			for (int i = 0; i < H; i++) {
				char[] tmp = br.readLine().toCharArray();	
				for (int j = 0; j < W; j++) {
					map[i][j] = tmp[j];
					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						sx = i;
						sy = j;
					}
				}
			}

			System.out.println(sx + " " + sy);

			N = Integer.parseInt(br.readLine());
			input = br.readLine().toCharArray();

			for (int i = 0; i < N; i++) {
				for (int x = 0; x < H; x++) {
					for (int y = 0; y < W; y++) {
						int nx = x;
						int ny = y;
						if (input[i] == 'U') {
							ny = ny + dy[0];
							nx = nx + dx[0];
							if (ny < 0 || ny >= H) {
								break;
							}
							if (map[ny][nx] == '.') {

							}
						} else if (input[i] == 'D') {
							ny = ny + dy[1];
							nx = nx + dx[1];
							if (ny < 0 || ny >= H) {
								break;
							}
							if (map[ny][nx] == '.') {

							}
						} else if (input[i] == 'L') {
							ny = ny + dy[2];
							nx = nx + dx[2];
							if (ny < 0 || ny >= H) {
								break;
							}
							if (map[ny][nx] == '.') {

							}
						} else if (input[i] == 'R') {
							ny = ny + dy[3];
							nx = nx + dx[3];
							if (ny < 0 || ny >= H) {
								break;
							}
							if (map[ny][nx] == '.') {

							}
						} else if(input[i] == 'S') {
							
						}
						
						
					}
				}
			}

		}
	}

}
