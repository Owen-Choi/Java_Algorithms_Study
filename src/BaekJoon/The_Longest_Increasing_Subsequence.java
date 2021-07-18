package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11053번
public class The_Longest_Increasing_Subsequence {
    static int Input;
    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        arr = new int[Input];
        dp = new Integer[Input];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<Input; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<Input; i++)
            recur(i);

        int max = dp[0];
        for(int i=1; i<Input; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
    static int recur(int index){
        if(dp[index] == null){
            dp[index] = 1;
            // i가 0일 경우 반복문에 한번도 안들어가서 IndexOutOfBound 오류가 발생하지 않는구나
            for(int i=index-1; i>=0; i--){
                if(arr[i] < arr[index])
                dp[index] = Math.max(dp[index], recur(i) + 1);
            }
        }
        return dp[index];
    }
}
