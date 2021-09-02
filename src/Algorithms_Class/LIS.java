package Algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LIS {
    static int N;
    static int [] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        for(int i=1; i<N; i++) {
            for(int k=i-1; k >= 0; k--) {
                if(arr[i] > arr[k])
                dp[i] = Math.max(dp[i], dp[k] + 1);
            }
        }
        int MAX = dp[0];
        for(int i=0; i<N; i++) {
            if(MAX < dp[i])
                MAX = dp[i];
        }
        System.out.println(MAX);
    }
}
