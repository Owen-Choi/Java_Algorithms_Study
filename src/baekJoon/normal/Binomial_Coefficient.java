package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11050번
public class Binomial_Coefficient {
    static int N, K;
    static int[][] dp;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N+1][K+1];
        System.out.println(recur(N, K));
    }
    static int recur(int X, int Y) {
            if(Y == 0 || X == Y)
                return dp[X][Y] = 1;
            if(dp[X][Y] > 0)
                return dp[X][Y];

            return dp[X][Y] = recur(X-1,Y-1) + recur(X-1, Y);
    }
}
