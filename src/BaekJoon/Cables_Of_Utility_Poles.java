package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cables_Of_Utility_Poles {
    static int N;
    static int[] A, B;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[500];
        B = new int[500];
        dp = new Integer[N+1];
        StringTokenizer st;
        int First, Last;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            First = Integer.parseInt(st.nextToken());
            Last = Integer.parseInt(st.nextToken());
            A[First] = Last;
            B[Last] = First;
        }
        dp[1] = 1;
        System.out.println(N - recur(N));
    }
    static int recur(int index){
        if(dp[index] == null){
            for(int i=index; i>=1; i--){
                if(A[index] < A[i]) {
                    if(A[index] == 0)
                        dp[index] = recur(index - 1);
                    else
                        dp[index] = Math.max(recur(index - 1) + 1, recur(i));
                }
            }
            if(dp[index] == null)
                dp[index] = recur(index - 1) + 1;
        }
        System.out.println(A[index] + " : " + dp[index]);
        return dp[index];
    }
}
