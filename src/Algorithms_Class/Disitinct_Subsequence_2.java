package Algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Disitinct_Subsequence_2 {
    static int testCase;
    static String X,Z;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase --> 0) {
            X = br.readLine();
            Z = br.readLine();
            dp = new int[Z.length() + 1][X.length() + 1];
            Arrays.fill(dp[0], 1);
            sb.append(dynamic()).append('\n');
        }
        System.out.println(sb);
    }
    static int dynamic() {
        for(int i=1; i<=Z.length(); i++) {
            for(int k=1; k<=X.length(); k++) {
                if(Z.charAt(i-1) == X.charAt(k-1)) {
                    dp[i][k] = dp[i][k-1] + dp[i-1][k-1];
                }
                else
                    dp[i][k] = Math.max(dp[i][k], dp[i][k-1]);
            }
        }
        return dp[Z.length()][X.length()];
    }
}
