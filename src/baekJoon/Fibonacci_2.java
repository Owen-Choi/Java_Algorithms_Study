package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 2748번
public class Fibonacci_2 {
    static int Input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        long[] dp;
        dp = new long[Input + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i< Input + 1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[Input]);
    }
}
