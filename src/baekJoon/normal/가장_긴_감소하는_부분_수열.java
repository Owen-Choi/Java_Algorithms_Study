package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 가장_긴_감소하는_부분_수열 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int[] dp = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    // 자기 자신은 수열에 포함되므로 1을 채워준다.
    Arrays.fill(dp, 1);
    for(int i=0; i<n; i++) {
      for(int k=0; k<=i; k++) {
        if(arr[i] < arr[k]) {
          dp[i] = Math.max(dp[i], dp[k] + 1);
        }
      }
    }
    int result = 0;
    for(int i=0; i<n; i++) {
      result = Math.max(result, dp[i]);
    }
    System.out.println(result);
  }
}
