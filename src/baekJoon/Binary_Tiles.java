package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 1904번
public class Binary_Tiles {
    static int N;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 2];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        System.out.println(recur(N));
    }
    static int recur(int num) {
        if(dp[num] == null){
            dp[num] = (recur(num - 1) + recur(num - 2)) % 15746;
        }
        return dp[num];
    }
}
