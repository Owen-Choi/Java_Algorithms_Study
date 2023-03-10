package programmers.level3;

import java.util.Arrays;

public class Way_to_school {

    public static void main(String[] args) {
//        int[][] puddles = {{3,2}, {2,4}};
        int[][] puddles = {{2,2}};
        System.out.println(solution(4, 3, puddles));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        int div = 1000000007;

        // 접근할 수 없는 물웅덩이 부분은 -99로 초기화해준다.
        for(int i=0; i< puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -99;
        }
        dp[1][1] = 1;

        for(int i=1; i<= n; i++) {
            for(int k=1; k<= m; k++) {
                if(dp[i][k] != -99) {
                    if(dp[i - 1][k] > 0) {
                        dp[i][k] += dp[i-1][k] % div;
                    }
                    if(dp[i][k - 1] > 0) {
                        dp[i][k] += dp[i][k - 1] % div;
                    }
                }
            }
        }
        return dp[n][m] % div;
    }

}
