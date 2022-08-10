package Class.D_0809;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1233__Pro__1 {

    static int N, ans;
    static char[] node;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            N = Integer.parseInt(br.readLine());
            node = new char[N + 1];    // 0 dummy

            // 두번째만 처리
            for (int i = 1; i <= N; i++) {
                node[i] = br.readLine().split(" ")[1].charAt(0);
            }

            int idx = N;
            ans = 1;    // default : 성공

            while (idx != 1) {
                //    현재 idx Node 의 유효성 검사
                //    idx, idx - 1(맨 끝, 맨 끝 (왼쪽)) => 둘다 숫자
                //    위 두 Node 의 부모 => 연산자
                if (!Character.isDigit(node[idx]) || !Character.isDigit(node[idx - 1])
                        || Character.isDigit(node[idx / 2])) {
                    ans = 0;
                    break;
                }

                node[idx / 2] = '1';    // 실세 수식을 처리 X => 단순하게 유효성 검사 => 적절한 수로 대체

                idx -= 2;
            }

            System.out.println("#" + t + " " + ans);
        }
    }
}