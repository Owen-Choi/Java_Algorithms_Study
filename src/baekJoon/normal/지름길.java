package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 지름길 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, d;
        n = Integer.parseInt(st.nextToken());
        // 0 : 출발지, 1 : 도착지, 2 : 거리
        int[][] arr = new int[n+1][3];
        d = Integer.parseInt(st.nextToken());
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        // dp[i] = i까지 이동하는 거리
        int[] dp = new int[20002];
        for(int i=1; i<=d; i++) {
            dp[i] = dp[i] == 0 ? dp[i-1] + 1 : Math.min(dp[i], dp[i-1] + 1);
            for(int k=0; k<arr.length; k++) {
                if(i == arr[k][1]) {
                    // 만약 현재 위치가 출발지와 동일하다면
                    dp[i] = Math.min(dp[i], dp[arr[k][0]] + arr[k][2]);
                    // 디버깅
//                    System.out.println("i : " + i + " , dp[i] = " + dp[i] + " , dp[arr[k][0]] + arr[k][2] : " + (dp[arr[k][0]] + arr[k][2]));
                }
            }
        }

//        for(int i=0; i<=d; i++) {
//            System.out.print(dp[i] + " ");
//        }
        System.out.println(dp[d]);
    }
}
