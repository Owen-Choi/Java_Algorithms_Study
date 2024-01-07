package baekJoon.normal;


import java.util.*;
import java.io.*;
public class 제곱수의_합 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] dp = new int[n+1];
    for(int i=1; i<=n; i++) {
      dp[i] = i;
      for(int k=1; k*k <= i; k++) {
        if(dp[i] > dp[i - k*k] + 1) {
          dp[i] = dp[i - k*k] + 1;
        }
      }
    }
    System.out.println(dp[n]);
  }

}
