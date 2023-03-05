package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Making_to_1_2 {

    static int N;
    static int[] dp;
    static int[] routeDp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        routeDp = new int[N + 1];

        for(int i=2; i<=N; i++) {
            dp[i] = dp[i - 1] + 1;
            routeDp[i] = i - 1;
            if(i % 3 == 0) {
                if(dp[i/3] + 1 < dp[i])
                    routeDp[i] = i / 3;
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if(i % 2 == 0) {
                if(dp[i/2] + 1 < dp[i])
                    routeDp[i] = i / 2;
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }

        System.out.println(dp[N]);
        StringBuilder sb = new StringBuilder();
        while(N > 0) {
            sb.append(N).append(" ");
            N = routeDp[N];
        }
        System.out.println(sb.toString());
    }
}
