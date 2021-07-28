package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 2193번
public class Pinary_Number {
    static int Input;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        dp = new Integer[Input + 1];
        dp[0] = 0;
        dp[1] = 1;
        if(Input > 1)
            dp[2] = 1;
        if(Input > 2)
            dp[3] = 2;
        System.out.println(recur(Input));
    }
    static int recur(int Index) {
        if(dp[Index] == null){
            dp[Index] = recur(Index - 1) + (Index-2);
        }
        return dp[Index];
    }
}
