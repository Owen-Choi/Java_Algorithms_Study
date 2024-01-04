package baekJoon.normal;

import java.util.*;
import java.io.*;
public class 스티커 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    int n;
    int[][] arr;
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    while(t --> 0) {
      n = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      arr = new int[2][n+1];
      for(int i=1; i<=n; i++) {
        arr[0][i] = Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());
      for(int i=1; i<=n; i++) {
        arr[1][i] = Integer.parseInt(st.nextToken());
      }
      // 입력 끝
      sb.append(dynamic(arr, n)).append("\n");
    }
    System.out.println(sb.toString());
  }

  static int dynamic(int[][] arr, int n) {
    // n이 2 이상이라는 보장이 없다. 따라서 기존 방식은 인덱스 초과가 발생한다.
    int[][] dp = new int[2][n+1];
    dp[0][1] = arr[0][1];
    dp[1][1] = arr[1][1];
    for(int i=2; i<=n; i++) {
      dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
      dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
    }

    return Math.max(dp[0][n], dp[1][n]);
  }

}
