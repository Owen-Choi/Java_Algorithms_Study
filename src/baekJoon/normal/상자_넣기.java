package baekJoon.normal;

import java.io.*;
import java.util.*;
public class 상자_넣기 {
  public static void main(String[] args) throws IOException{
    int n;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    for(int i=0; i<n; i++) {
      for(int k=0; k<i; k++) {
        if(arr[i] > arr[k]) {
          dp[i] = Math.max(dp[i], dp[k] + 1);
        }
      }
    }

    int max = 0;
    for(int i=0; i<n; i++) {
      max = Math.max(max, dp[i]);
    }
    System.out.println(max);
  }
}
