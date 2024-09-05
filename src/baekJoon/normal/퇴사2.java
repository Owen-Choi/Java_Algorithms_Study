package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 퇴사2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+2][2];    // [0] : 상담에 소요되는 일 수, [1] : 상담이 완료되면 얻을 수 있는 이득
        StringTokenizer st;
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        // dp[i] : i일까지 상담을 진행했을 때 얻을 수 있는 최대 이익.
        int[] dp = new int[n + 2];
        n++;
        for(int i=1; i<=n; i++) {
            // 디폴트로는 이전 dp의 값과 자신의 값 중 더 큰 값을 취해야 한다. 마지막 테스트케이스가 아니었으면 절대 몰랐을 듯.
            dp[i] = Math.max(dp[i], dp[i - 1]);
            if(i + arr[i][0] <= n)
                dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], dp[i] + arr[i][1]);
        }
//        if(arr[n-1][0] == 1) dp[n] += arr[n-1][1];
        System.out.println(Math.max(dp[n], dp[n-1]));
    }
}
