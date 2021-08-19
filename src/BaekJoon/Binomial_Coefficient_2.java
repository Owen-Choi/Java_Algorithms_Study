package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 11051번
public class Binomial_Coefficient_2 {
    static int N, K;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N+1][K+1];
        System.out.println(recur(N,K));
    }
    static int recur(int a, int b) {
        if(a == b || b == 0)
            return dp[a][b] = 1;
        if(dp[a][b] > 0)
            return dp[a][b];

        return dp[a][b] = (recur(a-1,b-1) + recur(a-1, b)) % 10007;

    }
}
