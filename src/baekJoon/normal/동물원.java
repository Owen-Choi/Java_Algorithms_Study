package baekJoon.normal;


import java.io.*;
import java.util.*;

public class 동물원 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] dp = new int[n+1][3];
    // dp[i][0]은 i번째 칸에 아무런 동물도 두지 않는 경우를 의미한다.
    // dp[i][1]은 i번째 칸의 0번째 열(왼쪽)에 동물을 두는 경우이다.
    // dp[i][2]은 i번째 칸의 1번째 열(오른쪽)에 동물을 두는 경우이다.
    dp[1][0] = dp[1][1] = dp[1][2] = 1;
    for(int i=2; i<=n; i++) {
      dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
      dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
      dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
    }

    System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % 9901);
  }
}
