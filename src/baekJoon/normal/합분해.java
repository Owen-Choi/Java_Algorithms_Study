package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        final int dividend = 1000000000;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        // dp[][] 어떻게 구성하면 좋지?
        // 0부터 n까지의 수 중에 k개를 더해서 그 합이 n이 되는 경우의 수
        // k개를 사용해서 n을 만드는 경우의 수 == dp[k][n];
        // k개를 더해서 그 합이 11이 되는 경우의 수 == 1개를 더해서 그 합이 9가 되는 경우의 수 + k-1개를 더해서 그 합이 2가 되는 경우의 수
        // dp[0][] + dp[][]
        int[][] dp = new int[k+1][n+1];

        Arrays.fill(dp[1], 1);
        for(int i=0; i<=k; i++) {
            dp[i][0] = 1;
        }

        for(int i=2; i<=k; i++) {
            for(int j=1; j<=n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] %= dividend;
            }
        }
        System.out.println(dp[k][n]);
    }
}
