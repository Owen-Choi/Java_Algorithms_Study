package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Climbing_Stairs_Again {
    static int[] arr;
    static Integer[] dp;
    static int stairNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stairNum = Integer.parseInt(br.readLine());
        arr = new int[stairNum + 1];
        dp = new Integer[stairNum + 1];
        for(int i=1; i<stairNum + 1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = arr[0] = 0;
        dp[1] = arr[1];
        if(stairNum >= 2) {
            dp[2] = arr[1] + arr[2];
        }
        if(stairNum >=3) {
            dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
        }
        System.out.println(recur(stairNum));
    }
    static int recur(int index){
        if(dp[index] == null){
            dp[index] = Math.max(recur(index-2), recur(index-3) + arr[index-1]) + arr[index];
        }
            return dp[index];
    }
}
