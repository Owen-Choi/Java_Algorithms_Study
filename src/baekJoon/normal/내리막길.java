package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 내리막길 {

  static int n,m;
  static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    int[][] arr = new int[n][m];
    int[][] dp = new int[n][m];

    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      Arrays.fill(dp[i], -1);
      for(int k=0; k<m; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, 0, arr, dp);
    System.out.println(dfs(0,0,arr,dp));

  }

  static int dfs(int x, int y, int[][] arr, int[][] dp) {
    if(x == n-1 &&  y == m-1) {
      return 1;
    }

    if(dp[x][y] != -1 ) {
      return dp[x][y];
    }

    dp[x][y] = 0;
    for(int i=0; i<4; i++) {
      int nextX = x + move[0][i];
      int nextY = y + move[1][i];

      if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
        continue;
      }

      if(arr[x][y] > arr[nextX][nextY]) {
        dp[x][y] += dfs(nextX, nextY, arr, dp);
      }
    }
    return dp[x][y];
  }


}
