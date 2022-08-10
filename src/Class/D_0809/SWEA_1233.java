package Class.D_0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1233 {

	static int vertex, ans;

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int test_case = 1; test_case <= 10; test_case++) {
        vertex = Integer.parseInt(br.readLine());
        ans = 1;

        for (int i = 0; i < vertex; i++) {
            String[] str = br.readLine().split("\\s+");
            System.out.println(Arrays.toString(str));
            if (str.length == 2) {
                if (str[1].charAt(0) == '' || str[1].charAt(0) == '+' || str[1].charAt(0) == '-' || str[1].charAt(0) == '/') {
                    ans = 0;
                }
            } else {
                if (str[1].charAt(0) != '' && str[1].charAt(0) != '+' && str[1].charAt(0) != '-' && str[1].charAt(0) != '/') {
                    ans = 0;
                }
            }
        }

        System.out.println(ans);
    }
}
}