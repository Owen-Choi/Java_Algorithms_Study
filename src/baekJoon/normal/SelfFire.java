package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SelfFire {

    static int N;
    static int[][] data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        data = new int[N + 1][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N + 1000];

        int maxCurrent = 0;
        for(int k=0; k<=N; k++) {
            dp[k] = Math.max(maxCurrent, dp[k]);
            dp[k + data[k][0]] = Math.max(dp[k] + data[k][1], dp[k + data[k][0]]);
            maxCurrent = Math.max(maxCurrent, dp[k]);
        }
        System.out.println(maxCurrent);
    }
}
