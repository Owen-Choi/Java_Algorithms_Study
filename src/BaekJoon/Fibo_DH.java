package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibo_DH {
    static Integer dp[][] = new Integer[41][2];
    public static void main(String[] args) throws IOException {
        int testCase;
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        testCase = Integer.parseInt(br.readLine());
        int temp;
        while(testCase --> 0) {
            temp = Integer.parseInt(br.readLine());
            recur(temp);
            sb.append(dp[temp][0]).append(" ").append(dp[temp][1]).append('\n');
        }
        System.out.println(sb);
    }
    static Integer[] recur(int index) {
        if(dp[index][0] == null || dp[index][1] == null) {
            dp[index][0] = recur(index-1)[0] + recur(index-2)[0];
            dp[index][1] = recur(index-1)[1] + recur(index-2)[1];
        }
        return dp[index];
    }
}
