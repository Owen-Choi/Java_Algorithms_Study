package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
    static Integer[][] dp;
    static char[] sen1;
    static char[] sen2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sen1 = br.readLine().toCharArray();
        sen2 = br.readLine().toCharArray();
        dp = new Integer[sen1.length][sen2.length];
        recur(sen1.length - 1, sen2.length - 1);
        System.out.println(dp[sen1.length-1][sen2.length-1]);
    }
    static int recur(int raw, int col){
        if(raw < 0 || col < 0)
            return 0;

        if(dp[raw][col] == null){
            dp[raw][col] = 0;
            if(sen1[raw] == sen2[col])
                dp[raw][col] = recur(raw-1, col - 1) + 1;
            else
                dp[raw][col] = Math.max(recur(raw-1, col), recur(raw, col-1));
        }
        return dp[raw][col];
    }
}