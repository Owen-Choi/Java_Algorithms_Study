package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 카드_구매하기 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=1; i<=n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int[] dp = new int[n+1];
    for(int i=1; i<=n; i++) {
      for(int k=1; k<=i; k++) {
        dp[i] = Math.max(dp[i], arr[k] + dp[i-k]);
      }
    }
    System.out.println(dp[n]);
  }

}
