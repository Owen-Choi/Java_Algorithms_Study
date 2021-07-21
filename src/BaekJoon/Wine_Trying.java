package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 2156번
public class Wine_Trying {
    static int Input;
    static int[] arr;
    static Integer[] dp;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        arr = new int[Input + 1];
        dp = new Integer[Input + 1];
        for(int i=1; i<=Input; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = arr[1];
        if(Input > 1)
            dp[2] = arr[1] + arr[2];
        System.out.println(recur(Input));
    }
    static int recur(int index) {
        if(dp[index] == null){
            dp[index] = Math.max(Math.max(recur(index-2), recur(index-3) + arr[index-1]) + arr[index], recur(index-1));
        }
        return dp[index];
    }
}
