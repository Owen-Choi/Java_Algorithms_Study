package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
    static char[][] arr;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        arr = new char[temp.length()][2];
        dp = new Integer[temp.length()][temp.length()];
        for(int i=0; i<temp.length(); i++)
            arr[i][0] = temp.charAt(i);
        String temp1 = br.readLine();
        for(int i=0; i<temp1.length(); i++)
            arr[i][1] = temp1.charAt(i);
        recur(temp.length() - 1, temp.length() - 1);
        System.out.println(dp[temp.length() - 1][temp.length() - 1]);
    }
    static int recur(int raw, int col){
        if(raw < 0 || col < 0){
            return 0;
        }
        if(dp[raw][col] == null){
            dp[raw][col] = 0;
            for(int i=arr.length-1; i>=0; i--){
                for(int k=arr.length-1; k>=0; k--){
                    if(arr[i][0] == arr[k][1])
                        dp[raw][col] = recur(raw - 1, col - 1) + 1;
                    else
                        dp[raw][col] = Math.max(recur(raw-1, col), recur(raw, col-1));
                }
            }
        }
        return dp[raw][col];
    }
}