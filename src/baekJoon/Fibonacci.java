package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1003번
public class Fibonacci {
    static Integer[][] dp = new Integer[41][2];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        int Input = Integer.parseInt(br.readLine());
        while(Input > 0) {
            Input--;
            int num = Integer.parseInt(br.readLine());
            recur(num);
            System.out.println(dp[num][0] + " " + dp[num][1]);
        }
    }
    static Integer[] recur(int index){
        if(dp[index][0] == null || dp[index][1] == null){
            dp[index][0] = recur(index-1)[0] + recur(index-2)[0];
            dp[index][1] = recur(index - 1)[1] + recur(index - 2)[1];
        }
        return dp[index];
    }
}
