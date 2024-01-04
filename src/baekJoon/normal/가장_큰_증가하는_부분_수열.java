package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 가장_큰_증가하는_부분_수열 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int[] dp = new int[n];
    for(int i=0; i<arr.length; i++) {
      dp[i] = arr[i];
    }
    for(int i=0; i<n; i++) {
      for(int k=0; k<=i; k++) {
        if(arr[i] > arr[k]) {
          dp[i] = Math.max(dp[k] + arr[i], dp[i]);
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
