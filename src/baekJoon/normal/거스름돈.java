package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int coin = Integer.parseInt(br.readLine());
        // dp[i] : i원을 만드는데 필요한 동전의 수
        if(coin == 1) {
            System.out.println(-1);
            return;
        }
        // 꾸역꾸역 dp로 풀었지만, 이 문제는 그리디로 푸는게 더 맞다.
        int[] dp = new int[Math.max(coin + 1, 7)];
        dp[0] = dp[1] = dp[3] = Integer.MIN_VALUE;
        dp[2] = dp[5] = 1;
        dp[4] = 2;
        for(int i=6; i<=coin; i++) {
            // 하나만 미니멀이라면 미니멀이 아닌 값을 할당해준다.
            if((dp[i-2] == Integer.MIN_VALUE && dp[i-5] != Integer.MIN_VALUE) ||
            dp[i-2] != Integer.MIN_VALUE && dp[i-5] == Integer.MIN_VALUE)
                dp[i] = dp[i-2] == Integer.MIN_VALUE ? dp[i-5] + 1 : dp[i-2] + 1;
            else if(dp[i-2] != Integer.MIN_VALUE && dp[i-5] != Integer.MIN_VALUE)
                dp[i] = Math.min(dp[i-2] + 1, dp[i-5] + 1);
            else
                dp[i] = Integer.MIN_VALUE;
        }
        System.out.println(dp[coin] != Integer.MIN_VALUE ? dp[coin] : -1);
    }
}
