package baekJoon.normal;

import java.io.*;
import java.util.*;
public class 더하기_123_3 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    long[] dp = new long[1_000_001];
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for(int i=4; i<=1_000_000; i++) {
      dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1_000_000_009;;
    }
    StringBuilder sb = new StringBuilder();
    while(tc --> 0) {
      sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
    }
    System.out.println(sb.toString());
  }
}
