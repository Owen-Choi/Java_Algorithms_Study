package baekJoon.normal;

import java.io.IOException;
import java.util.Scanner;

public class 암호코드 {
    static final int dividend = 0xf4240;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        // dp[i] = i번째 자릿수까지 해석할 수 있는 경우의 수
        int n = input.length();
        long[] dp = new long[n+1];
        int[] arr = new int[n+1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            arr[i] = input.charAt(i-1) - '0';
        }
        if (arr[1] == 0) {
            System.out.println(0);
            return;
        }
        dp[0] = dp[1] = 1;
        for (int i=2; i <= n; i++) {
            if (arr[i] == 0) {
                // 현재 값이 0일때 이전 값이 3 이상이라면 그 암호는 해독이 불가능하다.
                if (arr[i - 1] == 1 || arr[i - 1] == 2) {
                    dp[i] = dp[i - 2] % dividend;
                } else {
                    System.out.println(0);
                    return;
                }
            } else {
                // 현재 값이 0이 아닐때는 불가능한 경우는 없으며, 이전 값에 따라 더할 값이 달라지게 된다.
                int previous = arr[i - 1] * 10 + arr[i];
                if (previous >= 10 && previous <= 26) {
                    // 그렇지 않다면 dp[i-1] + dp[i-2]를 더해준다.
                    dp[i] = (dp[i - 1] + dp[i - 2]) % dividend;
                } else {
                    // 두 자릿수를 합쳤을 때 27이 넘어간다면 dp[i-1]만 해준다.
                    dp[i] = dp[i - 1] % dividend;
                }
            }
        }
        System.out.println(dp[n]);
    }
}
