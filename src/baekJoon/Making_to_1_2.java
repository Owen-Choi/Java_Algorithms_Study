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
        dp = new int[N];
        routeDp = new int[N];

        for(int i=1; i<N; i++) {
            dp[i] = dp[i - 1] + 1;
            routeDp[i] = i - 1;
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
                routeDp[i] = i / 3;
            }
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
                routeDp[i] = i / 2;
            }
        }

        System.out.println(dp[N - 1]);
        int route = N - 1;
        StringBuilder sb = new StringBuilder();
        sb.append(N).append(" ");
        while(route > 0) {
            sb.append(route).append(" ");
            route = routeDp[route];
        }
        System.out.println(sb.toString());
    }
}
