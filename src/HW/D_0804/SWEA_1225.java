//SWEA 1225번 [S/W 문제해결 기본] 7일차 - 암호생성기

package HW.D_0804;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225 {

 public static void main(String[] args) throws Exception {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

     for (int t = 1; t <= 10; t++) {
         br.readLine();
         Queue<Integer> que = new LinkedList<>();
         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int i = 0; i < 8; i++) {
             que.add(Integer.parseInt(st.nextToken()));
         }

         int dec = 1;
         while (true) {
             int n = que.poll() - dec;
             if (n <= 0) {
                 que.add(0);
                 break;
             } else {
                 que.add(n);
             }

              dec++;
              if (dec > 5)
                  dec = 1;
         }

         System.out.print("#" + t + " ");
         for (int i = 0; i < 8; i++) {
             System.out.print(que.poll() + " ");
         }
         System.out.println();
     }
 }
}