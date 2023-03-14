package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SelfFire {

    static int N;
    static int[][] data;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N][3];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            data[i][0] = Integer.parseInt(st.nextToken()) + (i + 1);
            data[i][1] = Integer.parseInt(st.nextToken());
            data[i][2] = i+1;
        }
        Arrays.sort(data, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        int result = 0;
        int[] dp = new int[N + 1000];

//        dp[i] = dp[data[i][0]] + data[i][1];
        for(int k=0; k<N; k++) {
//            for(int k=0; k<i; k++) {
////                dp[i] = Math.max(dp[data[k][0]] + data[k][1], dp[i]);
//                dp[data[k][0]] = Math.max(dp[data[k][2]] + data[k][1], dp[data[k][0]]);
//            }
            dp[data[k][0]] = Math.max(dp[data[k][2]] + data[k][1], dp[data[k][0]]);
        }
        System.out.println(Math.max(dp[N], dp[N+1]));
    }
}
