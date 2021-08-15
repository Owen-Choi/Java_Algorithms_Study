package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
    static char[][] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        arr = new char[temp.length()][2];
        dp = new Integer[temp.length()];
        for(int i=0; i<temp.length(); i++)
            arr[i][0] = temp.charAt(i);
        String temp1 = br.readLine();
        for(int i=0; i<temp1.length(); i++)
            arr[i][1] = temp1.charAt(i);

        recur(arr.length-1, arr.length);
        System.out.println(dp[arr.length-1]);
    }
    static int recur(int index, int index_Of_K){
        if(index < 0)
            return 0;
        if(dp[index] == null){
            dp[index] = 0;   // 최솟값
            for(int i = index; i>=0; i--){
                for(int k=index_Of_K-1; k>=0; k--){
                    if(arr[i][0] == arr[k][1]){
                        System.out.println(arr[i][0]);
                        dp[index] = Math.max(dp[index], recur(index-1, k) + 1);
                    }
                }
            }
        }
        return dp[index];
    }
}
