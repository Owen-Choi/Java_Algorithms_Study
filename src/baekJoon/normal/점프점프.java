package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 점프점프 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int[] arr = new int[n];
//        int[] dp = new int[n];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for(int i=0; i<n; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        if(arr[0] == 0) {
//            System.out.println(-1);
//        } else {
//            dp[1] = 1;
//            for(int i=0; i<n; i++) {
//                for(int k=1; k<=arr[i] && i+k < n; k++) {
//                    dp[i + k]++;
//                }
//            }
//
//            for(int i=0; i<n; i++) {
                    /* TODO 아래 k 반복문은 필요 없다.
                        점프 조건도 애초에 arr[i] 범위 내에 속하는 곳에만 할 수 있는 것이기 때문에 0부터 시작하는 것도 잘못된 것이고,
                        이 방법이 통하는 문제는 LIS 같은 문제이다.
                     */

//                for(int k=0; k<=i; k++) {
//                    for(int j=1; j<=arr[k] && k + j < n; j++) {
////                        dp[k] = Math.min(dp[k] + 1, dp[k + j]);
//                        dp[k + j] = Math.min(dp[k+j], dp[k] + 1);
//                    }
//                }
//            }
//
////            for(int i=0; i<n; i++) {
////                System.out.print(dp[i] + " ");
////            }
//            System.out.println(dp[n-1] == 0 ? -1 : dp[n-1]);
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0; i<n; i++) {
            if(dp[i] == Integer.MAX_VALUE) continue;
            for(int k=1; k<=arr[i] && i + k < n; k++) {
                dp[i+k] = Math.min(dp[i + k], dp[i] + 1);
            }
        }
        System.out.println(dp[n-1] == Integer.MAX_VALUE ? -1 : dp[n-1]);
    }
}
