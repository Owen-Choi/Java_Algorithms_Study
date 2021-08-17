package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 12865번
public class Normal_Backpack {
    static int N, K;
    static int[] Weight;
    static int[] Value;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Weight = new int[N];
        Value = new int[N];
        dp = new Integer[N][K+1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Weight[i] = Integer.parseInt(st.nextToken());
            Value[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(recur(N-1, K));
    }
    static int recur(int index, int weight){
        if(index < 0)
            return 0;
        if(dp[index][weight] == null){
            if(Weight[index] > weight)
                dp[index][weight] = recur(index-1, weight);
            else
                dp[index][weight] = Math.max(recur(index-1, weight), recur(index-1, weight - Weight[index]) + Value[index]);
        }
        return dp[index][weight];
    }
}
