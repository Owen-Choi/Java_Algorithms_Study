package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 욕심쟁이_판다 {

  static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
  static int n;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    StringTokenizer st;
    int[][] arr = new int[n][n];
    int[][] dp = new int[n][n];
    for(int i=0; i<n; i++) {
      Arrays.fill(dp[i], -1);
      st = new StringTokenizer(br.readLine());
      for(int k=0; k<n; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
      }
    }

    // dp[x][y] = z :: x,y의 판다가 z 칸을 이동함.

    for(int i=0; i<n; i++) {
      for(int k=0; k<n; k++) {
        recur(i,k, dp, arr);
      }
    }

    int result = 1;
    for(int i=0; i<n; i++) {
      for(int k=0; k<n; k++) {
        result = Math.max(result, dp[i][k]);
      }
    }
    System.out.println(result);
  }

  static int recur(int x, int y, int[][] dp, int[][] arr) {
    if(dp[x][y] != -1) {
      return dp[x][y];
    }
    dp[x][y] = 1;

    for(int i=0; i<4; i++) {
      int nextX = x + move[0][i];
      int nextY = y + move[1][i];

      if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
        continue;
      }

      if(arr[nextX][nextY] > arr[x][y]) {
        dp[x][y] = Math.max(dp[x][y], recur(nextX, nextY, dp, arr) + 1);
      }
    }
    return dp[x][y];
  }
}
