package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS_BottomUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();
        int[][] dp = new int[input2.length() + 1][input1.length() + 1];
        for(int i=1; i<=input2.length(); i++){
            for(int k=1; k<=input1.length(); k++){
                if(input2.charAt(i-1) == input1.charAt(k-1)) {
//                    dp[i][k] = Math.max(dp[i][k-1], dp[i-1][k] + 1);
                    dp[i][k] = dp[i-1][k-1] + 1;
                } else {
                    dp[i][k] = Math.max(dp[i][k-1], dp[i-1][k]);
                }
            }
        }
        for(int i=0; i<=input2.length(); i++) {
            for(int k=0; k<=input1.length(); k++) {
                System.out.print(dp[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[input2.length()][input1.length()]);
    }
}
