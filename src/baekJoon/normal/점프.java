package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 점프 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];
    for(int i=0; i<n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int k=0; k<n; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
      }
    }

    long[][] dp = new long[n][n];
    dp[0][0] = 1;
    // dp[i][k] = i행 k열까지 도달할 수 있는 경우의 수
    int nextX, nextY;
    for(int i=0; i<n; i++) {
      for(int k=0; k<n; k++) {
        if(i == n-1 && k == n-1)
          break;
        if(dp[i][k] != 0) {
          nextX = i;
          nextY = k + arr[i][k];
          if(nextY >= 0 && nextY < n) {
            dp[nextX][nextY] += dp[i][k];
          }
          nextX = i + arr[i][k];
          nextY = k;
          if(nextX >= 0 && nextX < n) {
            dp[nextX][nextY] += dp[i][k];
          }
        }
      }
    }

    System.out.println(dp[n-1][n-1]);
  }

}
