package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일학년 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[n][21];
        // dp[0][8] : 0번째 숫자까지의 조합으로 8을 만들 수 있는 경우의 수
        // dp[1][5] : 1번째 숫자까지의 조합으로 5를 만들 수 있는 경우의 수
        // 8 3 2 4 8 7 2 4 0 8 8
        dp[0][arr[0]] = 1;
        int prev;
        for(int i=1; i<n-1; i++) {
            for(int k=0; k<21; k++) {
                if(dp[i-1][k] != 0) {
                    prev = k;
                    if(prev + arr[i] <= 20 && prev + arr[i] >= 0)
                        dp[i][prev + arr[i]] += dp[i-1][prev];
                    if(prev - arr[i] >= 0 && prev - arr[i] <= 20)
                        dp[i][prev - arr[i]] += dp[i-1][prev];
                }
            }
        }
        System.out.println(dp[n-2][arr[n-1]]);
    }
}
