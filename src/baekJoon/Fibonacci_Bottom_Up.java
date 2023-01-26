package baekJoon;

import java.io.*;

// 1003번
public class Fibonacci_Bottom_Up {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         StringBuilder sb = new StringBuilder();

         int[][] dp = new int[41][2];
         dp[0][0] = 1;
         dp[0][1] = 0;
         dp[1][0] = 0;
         dp[1][1] = 1;

         for(int i=2; i<41; i++){
             dp[i][0] = dp[i-2][0] + dp[i-1][0];
             dp[i][1] = dp[i-2][1] + dp[i-1][1];
         }
         int TestCase = Integer.parseInt(br.readLine());
         for(int i=0; i<TestCase; i++){
             int num = Integer.parseInt(br.readLine());
             sb.append(dp[num][0]).append(" ").append(dp[num][1]).append("\n");
         }
         bw.write(sb.toString());
         bw.flush();
         bw.close();
         br.close();
     }
}
