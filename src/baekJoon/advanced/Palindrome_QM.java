package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10942번, 펠린드롬?, 골드 4
public class Palindrome_QM {

    static int N;
    static int[] num;
    static int M;
    static boolean [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        dp = new boolean[N][N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        solve();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            boolean flag = dp[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1];
            sb.append(flag ? "1" : "0").append('\n');
        }
        System.out.println(sb.toString());

    }

    public static void solve() {
        // 길이가 1일때, 항상 펠린드롬이다.
        for(int i=0; i<N; i++) {
            dp[i][i] = true;
        }

        // 길이가 2일때, 11, 22 등과 같이 서로 같아야 펠린드롬이다.
        for(int i=0; i<N - 1; i++) {
            if(num[i] == num[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

//        for(int i=0; i<N; i++) {
//            for(int k=1; k<N-i; k++) {
//                if(num[i] == num[i + k] && dp[i + 1][i + k - 1]) {
//                    dp[i][i + k] = true;
//                }
//            }
//        }

        for(int i=1; i<N; i++) {
            for(int k=0; k<N - i; k++) {
                if(num[k] == num[k + i] && dp[k + 1][k + i - 1]) {
                    dp[k][k + i] = true;
                }
            }
        }
    }

}
