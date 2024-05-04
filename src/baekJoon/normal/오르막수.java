package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 오르막수 {
    static final int dividend = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][10];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < n+1; i++) {
            for(int k=0; k<10; k++) {
                for(int j=k; j<10; j++) {
                    dp[i][k] += dp[i-1][j];
                    dp[i][k] %= dividend;
                }
            }
        }
        System.out.println(dp[n][0] % dividend);
    }

}
