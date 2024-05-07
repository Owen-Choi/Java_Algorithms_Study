package baekJoon.normal;

import java.util.Scanner;

public class Four_Squares {
    public static void main(String[] args) {
        // dp[i] = <dp[i] - "제곱수"> 의 결과 중에서 가장 작은 값 + 1
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            int min = Integer.MAX_VALUE;
            for(int k=1; k * k <=i; k++) {
                int temp = i - k*k;
                min = Math.min(min, dp[temp]);
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[n]);
    }
}
