package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 동전 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(tc --> 0) {
            int n = Integer.parseInt(br.readLine()), target = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coin = new int[n];
            for(int i=0; i<n; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            target = Integer.parseInt(br.readLine());
            int[] dp = new int[target + 1];

            // dp[i] : i원을 만들 수 있는 경우의 수
//            for(int i=1; i<=target; i++) {
//                for(int k=0; k<coin.length; k++) {
//                    if(i - coin[k] > 0) {
//                        dp[i] += dp[i-coin[k]];
//                    } else if(i - coin[k] == 0) {
//                        dp[i] += 1;
//                    }
//                }
//            }
            // 하 진짜 너무 억울하다...
            for(int i=0; i<coin.length; i++) {
                for(int k=1; k<=target; k++) {
                    if(k - coin[i] > 0) {
                        dp[k] += dp[k - coin[i]];
                    } else if(k == coin[i]) {
                        dp[k] += 1;
                    }
                }
            }

            sb.append(dp[target]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
