package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 13549번, 숨바꼭질3, 골드5
public class Hide_N_Seek_3 {

    static int N, K;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[2 * K];

        int sec = 0;
//        while(true) {
//            if(2*N <= K) {
//                dp[2*N] = sec;
//            } else {
//                // 2를 곱했을때 K 보다 크다면
//                // 일단 곱해서 빼는 과정까지 고려해준다.
//            }
//        }
        // 2중 for문

    }
}
