package programmers.level3;

import java.util.Arrays;

public class Way_to_school {

    public static void main(String[] args) {
        int[][] puddles = {{3,2}, {2,4}};
//        int[][] puddles = new int[0][0];
//        System.out.println(solution(4, 3, puddles));
        System.out.println(solution(100, 100, puddles));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        int div = 1000000007;
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], 1);
        }

        for(int i=0; i<n; i++) {
            for(int k=0; k<m; k++) {
                int flag = check(i, k, puddles);
                if(flag == 0) {
                    // 이 블럭에 들어온 코드는 주변에 물 웅덩이가 없는 것이다.
                    if(i == 0 && k == 0)
                        continue;
                    if (i == 0) {
                        // 위쪽에서 접근하지 못하는 경우를 체크
                        // 왼쪽에서 들어오는 경우만 더해줌
                        dp[i][k] = dp[i][k - 1];
                    } else if(k == 0) {
                        // 왼쪽에서 접근하지 못하는 경우를 체크
                        // 위쪽에서 들어오는 경우만 더해줌
                        dp[i][k] = dp[i-1][k];
                    } else {
                        dp[i][k] = (dp[i-1][k]) + (dp[i][k - 1]);
                    }
                } else {
                    // 주변에 물 웅덩이가 있는 경우
                    if(flag == 1) {
                        // 웅덩이가 위에 있는 경우
                        dp[i][k] = dp[i][k - 1];
                    } else if(flag == 2) {
                        // 웅덩이가 옆에 있는 경우
                        dp[i][k] = dp[i-1][k];
                    }
                }
            }
        }

        return dp[n - 1][m - 1] % div;
    }

    public static int check(int x, int y, int[][] puddles) {
            for(int k=0; k<puddles.length; k++) {
                if(((x-1) == puddles[k][0] - 1 && (y) == puddles[k][1] - 1) || (x == puddles[k][0] - 1 && (y - 1) == puddles[k][1] - 1)) {
                    if((x-1) == puddles[k][0] - 1 && (y) == puddles[k][1] - 1) {
                        // 웅덩이가 위에 있는 경우 1 반환
                        return 1;
                    } else {
                        // 웅덩이가 옆에 있는 경우 2 반환
                        return 2;
                    }
                }
            }
        return 0;
    }
}
