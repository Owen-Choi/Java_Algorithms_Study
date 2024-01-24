package baekJoon.normal;

import java.util.*;
import java.io.*;
public class 파이프_옮기기 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];
    // dp[i][k][0] : i행 k열에 파이프가 가로로 놓이는 경우
    // dp[i][k][1] : i행 k열에 파이프가 세로로 놓이는 경우
    // dp[i][k][2] : i행 k열에 파이프가 대각선으로 놓이는 경우
    int[][][] dp = new int[n][n][3];

    // 벽도 고려해야함
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int k=0; k<n; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
      }
    }

    // 초깃값 입력 : 가장 처음 파이프는 가로로 놓여있다.
    dp[0][1][0] = arr[0][1] != 1 ? 1 : 0;
    // dp 시작
    for(int i=0; i<n; i++) {
      for(int k=0; k<n; k++) {
        if(i == 0 && k == 0)
          continue;

        // 가로로 놓는 경우. 바로 옆칸이 벽이면 안된다.
        if(k < n-1 && arr[i][k+1] != 1) {
          dp[i][k+1][0] += dp[i][k][0] + dp[i][k][2];
        }
        // 세로로 놓는 경우. 바로 아랫칸이 벽이면 안된다.
        if(i < n-1 && arr[i+1][k] != 1) {
          dp[i+1][k][1] += dp[i][k][1] + dp[i][k][2];
        }
        // 대각선으로 놓는 경우. 바로 옆칸, 아랫칸, 오른쪽 대각선 아랫칸이 벽이면 안된다.
        if(i < n-1 && k < n-1 && arr[i][k+1] != 1 && arr[i+1][k] != 1 && arr[i+1][k+1] != 1) {
          dp[i+1][k+1][2] += dp[i][k][0] + dp[i][k][1] + dp[i][k][2];
        }
      }
    }
    System.out.println(dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2]);
  }

}
