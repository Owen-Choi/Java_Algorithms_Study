package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 9461번
public class Padovan_Sequence {
    static int TestCase;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TestCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < TestCase; i++) {
            int Input = Integer.parseInt(br.readLine());
            long[] dp = new long[Input + 10];
            if (CheckInput(Input, dp) == 0)
                continue;
            else {
                for (int k = 11; k <= Input; k++) {
                    dp[k] = dp[k-1] + dp[k - 5];
                }
                System.out.println(dp[Input]);
            }
        }
    }

    static int CheckInput(int Input, long[] dp) {

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = 3;
        dp[7] = 4;
        dp[8] = 5;
        dp[9] = 7;
        dp[10] = 9;
        if (Input <= 10) {
            System.out.println(dp[Input]);
            return 0;
        } else return 1;
    }
}
