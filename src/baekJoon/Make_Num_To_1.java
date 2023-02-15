package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// 2023-02-15 복습, 1463, dp
public class Make_Num_To_1 {

    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        // 연산을 사용하는 횟수의 최솟값
        int subN = N;
//        while(subN != 1) {
//            if(subN % 2 == 0) {
//                dp[subN / 2] = Math.min(dp[subN / 2], dp[subN] + 1);
//            }
//            if(subN % 3 == 0) {
//                dp[subN / 3]  = Math.min(dp[subN / 3], dp[subN] + 1);
//            }
//            dp[subN]++;
//            subN--;
//        }

        for(int i=2; i<=N; i++) {
            dp[i] = dp[i - 1] + 1;
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}

// 1463번
//public class Make_Num_To_1 {
//    static int input;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        input = Integer.parseInt(br.readLine());
//        br.close();
//        System.out.println(recur(input, 0));
//    }
//    static int recur(int num, int count){
//        if(num < 2)
//            return count;
//
//        return Math.min(recur(num/2, count + 1 + num%2), recur(num/3, count + 1 + num%3));
//    }
//}
