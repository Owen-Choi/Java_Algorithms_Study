package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 2193번
public class Pinary_Number {
    static int Input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        Long[][] dp = new Long[Input + 1][2];
        dp[1][0] = 0l;
        dp[1][1] = 1l;
        for(int i=2; i<=Input; i++){
            for(int j=0; j<2; j++){
                if(j == 0)
                    dp[i][j] = dp[i-1][0] + dp[i-1][1];
                else
                    dp[i][j] = dp[i-1][0];
            }
        }
        long result = dp[Input][0] + dp[Input][1];
        System.out.println(result);
    }
}
