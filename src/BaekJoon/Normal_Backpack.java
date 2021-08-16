package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 12865번
public class Normal_Backpack {
    static int N, K;
    static int[][] arr;
    static Integer[][] dp;
    static final int W = 0;
    static final int V = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1][K];
        dp = new Integer[N+1][K];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][W] = Integer.parseInt(st.nextToken());
            arr[i][V] = Integer.parseInt(st.nextToken());
        }
        System.out.println(recur(N-1, K-1));
    }
    static int recur(int index, int weight){
        if(index < 0 || weight < 0)
            return 0;
        if(dp[index][weight] == null){
            if(arr[index][weight] > weight)
                dp[index][weight] = recur(index-1, weight);
            else
                dp[index][weight] = Math.max(recur(index-1, weight), recur(index-1, weight - arr[index][W]) + arr[index][V]);
        }
        return dp[index][weight];
    }
}
