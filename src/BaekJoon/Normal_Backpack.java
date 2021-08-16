package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 12865번
public class Normal_Backpack {
    static int N, K;
    static int[][] arr;
    static Integer[] dp;
    static final int W = 0;
    static final int V = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        dp = new Integer[N];
        dp[0] = 0;
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][W] = Integer.parseInt(st.nextToken());
            arr[i][V] = Integer.parseInt(st.nextToken());
        }
        for(int i = N-1; i>=0; i--)
            recur(i, 0);
        int Max = -1;
        for(int i=0; i<N; i++)
            Max = Math.max(Max, dp[i]);
        System.out.println(Max);
    }
    static int recur(int index, int Weight){
        if(index < 0)
            return 0;
        int tempIndex = index-1;
            dp[index] = 0;
            if(arr[index][W] + Weight <= K){
                dp[index] = Math.max(recur(tempIndex, (arr[index][W] + Weight)) + arr[index][V],
                        recur(tempIndex, Weight));
            }
            else
                dp[index] = Math.max(dp[index], recur(index-1, Weight));
        return dp[index];
    }
}
