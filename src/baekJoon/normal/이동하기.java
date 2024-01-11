package baekJoon.normal;

import java.io.*;
import java.util.*;
public class 이동하기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n, m;
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    int[][] dp = new int[n][m];
    int[][] arr = new int[n][m];
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int k=0; k<m; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
      }
    }
    // 현재 위치 (x, y) 에서 가장 큰 값을 배열에 저장
    // 어차피 가장 첫번째 행과 열의 정답은 정해져있다. 채우고 시작하겠다.
    dp[0][0] = arr[0][0];
    for(int k=1; k<m; k++) {
      dp[0][k] = dp[0][k-1] + arr[0][k];
    }
    for(int i=1; i<n; i++) {
      dp[i][0] = dp[i-1][0] + arr[i][0];
    }

    for(int i=1; i<n; i++) {
      for(int k=1; k<m; k++) {
        dp[i][k] = Math.max(dp[i][k], dp[i-1][k] + arr[i][k]);
        dp[i][k] = Math.max(dp[i][k], dp[i][k-1] + arr[i][k]);
        dp[i][k] = Math.max(dp[i][k], dp[i-1][k-1] + arr[i][k]);
      }
    }
    System.out.println(dp[n-1][m-1]);
  }

}
