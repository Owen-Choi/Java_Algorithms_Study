package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11726번
public class TwoXN_Tiling_Retry {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Input = Integer.parseInt(br.readLine());
        dp = new int[Input + 4];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        if(Input <= 3){
            System.out.println(dp[Input]);
            return;
        }
        else {
            for (int i = 4; i <= Input; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
                dp[i] %= 10007;
            }
        }
        System.out.println(dp[Input]);
    }
}
