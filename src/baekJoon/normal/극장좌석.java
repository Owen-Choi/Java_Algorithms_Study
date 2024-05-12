package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 극장좌석 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int m = Integer.parseInt(br.readLine());
//        int[] vip = new int[m];
//        for(int i=0; i<m; i++) {
//            vip[i] = Integer.parseInt(br.readLine());
//        }
//        // dp[i] = dp[i-1] + dp[i -2] 이다.
//        // 직접 구해봤는데, 자리를 바꾸는 경우는 dp[i-2], 바꾸지 않는 경우는 dp[i-1]로 나타내진다.
//        // VIP 좌석의 위치를 기준으로 청크를 나눈 다음 각 청크에서 나오는 경우의 수를 모두 곱하면 정답이다.
//
//        int prev = 0;
//        int[] dp = new int[n + 1];
//        // 제일 긴 청크를 찾은 다음 해당 청크의 경우의 수를 dp로 구한다.
//        // 그럼 나머지는 만들어진 dp를 통해 O(1)의 값으로 구할 수 있음
//        // => 안된다!! m은 0일 수도 있다.
//        List<Integer> chunks = new ArrayList<>();
//        for(int i=0; i<m; i++) {
//            int chunkLength = vip[i] - prev - 1;
//            chunks.add(chunkLength);
//            prev = vip[i];
//        }
//        if(prev != n) {
//            chunks.add(n - prev);
//        }
//
//        if(n == 2) {
//            System.out.println(2);
//        } else if(n == 3) {
//            System.out.println(3);
//        } else {
//
//            // 큰 순서대로 정렬
//            chunks.sort((o1, o2) -> {
//                return o2 - o1;
//            });
//            dp[0] = 1;
//            dp[1] = 2;
//            dp[2] = 3;
//            for (int i = 3; i <= chunks.get(0); i++) {
//                dp[i] = dp[i - 1] + dp[i - 2];
//            }
//
//            int result = 1;
//            for (Integer chunk : chunks) {
//                if (chunk == 0)
//                    continue;
//                result *= dp[chunk - 1];
//            }
//            System.out.println(result);
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] vip = new int[m];
        for(int i=0; i<m; i++) {
            vip[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[41];
        // dp[0]이 1인 이유는 뒤에서 나온다.
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        int result = 1, prev = 0;
        for(int i=0; i<m; i++) {
            result *= dp[vip[i] - prev - 1];
            prev = vip[i];
        }
        result *= dp[n - prev];
        System.out.println(result);
    }


}
