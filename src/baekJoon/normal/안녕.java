package baekJoon.normal;

import java.util.*;
import java.io.*;

// 이 문제는 테스트 케이스가 작고 시간도 넉넉해서 dfs로 풀어도 됨
public class 안녕 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][2];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            // 체력
            arr[i][0] = Integer.parseInt(st1.nextToken());
            // 기쁨
            arr[i][1] = Integer.parseInt(st2.nextToken());
        }
        // dp[i][k] : i번째 사람과 인사했고, 체력이 k가 남았을 때
        int[][] dp = new int[n+1][100];
        // TODO DP는 최대한 값을 인덱스로 활용하는 방향으로 설계해야 한다.
        for(int i=1; i<=n; i++) {
            for(int k=0; k<100; k++) {
                // 0부터 99까지만 고려하니까 같아도 허용하는 건가?
                if(k >= arr[i][0]) {
                    // 왜 dp[i-1] 이지?
                    dp[i][k] = Math.max(dp[i - 1][k], dp[i-1][k - arr[i][0]] + arr[i][1]);
                } else {
                    dp[i][k] = dp[i-1][k];
                }
            }
        }

        System.out.println(dp[n][99]);
    }
}
