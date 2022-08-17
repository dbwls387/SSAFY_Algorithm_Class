// BOJ 1541번 잃어버린 괄호 

package Class.D_0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1541 {

	static int min;
	static char[] input;
	static ArrayList<String> arr = new ArrayList<>();;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		input = new char[str.length()];
		input = str.toCharArray();

		String num = "";
		for (int i = 0; i < input.length; i++) {
			if (input[i] == '+' || input[i] == '-') {
				arr.add(num);
				arr.add(Character.toString(input[i]));
				num = "";
			} else {
				num += input[i];
			}
		}
		arr.add(num);

		min = Integer.MAX_VALUE;

		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).compareTo("+") == 0) {
				int plus = Integer.parseInt(arr.get(i - 1)) + Integer.parseInt(arr.get(i + 1));
				arr.remove(i - 1);
				arr.remove(i);
				arr.remove(i + 1);
				arr.add(i, num);
			}
		}
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).compareTo("-") == 0) {
				int plus = Integer.parseInt(arr.get(i - 1)) - Integer.parseInt(arr.get(i + 1));
				arr.remove(i - 1);
				arr.remove(i);
				arr.remove(i + 1);
				arr.add(i, num);
			}
		}
		
		System.out.println(arr.get(0));

	}

}
