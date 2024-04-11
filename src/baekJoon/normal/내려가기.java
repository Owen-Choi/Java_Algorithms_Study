package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 내려가기 {

  public static void main(String[] args) throws IOException {
    int n;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][3];
    StringTokenizer st;
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int k=0; k<3; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] dp = new int[n][3];
    dp[0][0] = arr[0][0];
    dp[0][1] = arr[0][1];
    dp[0][2] = arr[0][2];
    for(int i=1; i<n; i++) {
      dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) + arr[i][0];
      dp[i][1] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]) + arr[i][1];
      dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]) + arr[i][2];
    }
    StringBuilder sb = new StringBuilder();
    sb.append(Math.max(Math.max(dp[n-1][0], dp[n-1][1]), dp[n-1][2])).append(" ");
    for(int i=1; i<n; i++) {
      dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][0];
      dp[i][1] = Math.min(Math.min(dp[i-1][0], dp[i-1][1]), dp[i-1][2]) + arr[i][1];
      dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][2];
    }
    sb.append(Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]));
    System.out.println(sb.toString());
  }
}
