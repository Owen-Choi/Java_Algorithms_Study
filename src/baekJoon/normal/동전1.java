package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 동전1 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n, j;
    n = Integer.parseInt(st.nextToken());
    j = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    int[] dp = new int[j+1];
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    dp[0] = 1;

    for(int i=0; i<n; i++) {
      for(int k=arr[i]; k<=j; k++) {
        // 처음에는 dp[k] = dp[arr[i]] + dp[k - arr[i]] 로 점화식을 세웠었다.
        // 그러다 오답을 맞았다. 결과적으로는 아래의 점화식이 정답인데, 여기서 dp[k]에다 dp[k-arr[i]]를 더해주는게 이해가 안됐다.
        // 이유는 다음과 같다. dp[k]는 이전의 동전으로만 얻을 수 있었던 경우의 수이고, 여기에 새로운 동전을 활용해서 얻을 수 있는 경우의 수
        // dp[k - arr[i]]를 더해주는 것이다.
        dp[k] = dp[k] + dp[k - arr[i]];
      }
    }
    System.out.println(dp[j]);
    }
  }
