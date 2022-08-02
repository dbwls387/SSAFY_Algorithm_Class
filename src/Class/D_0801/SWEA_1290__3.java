package Class.D_0801;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1290__3 {

	// Scanner -> BufferedReader
	// local ���� �� �ֿ� �������� -> static
	// int[] -> char[]
	// String toCharArray()
	
	static int T, count;
	static char[] input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			count = 0; // ���� �Ǽ�

			input = br.readLine().toCharArray();	// �迭�� ���� �����ؼ� return 
			
			// ���� ���� 
			char current = '0';

			int cnt = input.length;

			// ������ ���� input[i]�� ���ؼ� �ٸ��� ����Ƚ���� �����ϴ� ���� 
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
