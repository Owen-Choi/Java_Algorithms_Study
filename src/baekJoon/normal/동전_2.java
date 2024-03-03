package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전_2 {
    public static void main(String[] args) throws IOException {

        int n, k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int[] dp = new int[100001];
        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            dp[coins[i]] = 1;
        }

        for(int i=1; i<=k; i++) {
            if(dp[i] == 0) continue;
            for(int j=0; j<n; j++) {
                if(i + coins[j] <= k)
                    dp[i + coins[j]] = dp[i+coins[j]] == 0 ? dp[i] + 1 : Math.min(dp[i+coins[j]], dp[i] + 1);
            }
        }
        System.out.println(dp[k] == 0 ? -1 : dp[k]);
    }
}
