package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 카드_구매하기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n + 1];
        for(int i=1; i<=n; i++) {
            dp[i] = arr[i];
        }
        // dp[i] = i개의 카드를 구매할 수 있는 최소 비용
        for(int i=1; i<=n; i++) {
            for(int k=1; k<=i; k++) {
                if(i + k <= n) {
                    dp[i + k] = Math.min(dp[i+k], dp[i] + arr[k]);
                }
            }
        }
        System.out.println(dp[n]);
    }
}
