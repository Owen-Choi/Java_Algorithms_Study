package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1912번
public class Sum_Of_Continuous_Num {
    static int Input;
    static int [] arr;
    static int[] dp;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        arr = new int[Input];
        dp = new int[Input];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<Input; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=Input-1; i>=0; i--){
            dp[i] = arr[i];
            recur(i - 1);
        }
        System.out.println(max);
    }
    static void recur(int index) {
        if(index > 0 && index < Input){
            dp[index] = dp[index+1] + arr[index];
            if(max < dp[index])
                max = dp[index];
            recur(index-1);
        }
    }
}
