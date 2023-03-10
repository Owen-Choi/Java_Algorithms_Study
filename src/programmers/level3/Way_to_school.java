package programmers.level3;

import java.util.Arrays;

public class Way_to_school {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        int[][] puddles = {{2,2}};
        solution(4, 3, puddles);
    }

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int k=0; k<m; k++) {
                if(!check(i, k, puddles)) {
                    // 이 블럭에 들어온 코드는 주변에 물 웅덩이가 없는 것이다.
                    if(i == 0 && k == 0)
                        continue;
                    if (i == 0) {
                        // 위쪽에서 접근하지 못하는 경우를 체크
                        // 왼쪽에서 들어오는 경우만 더해줌
                        dp[i][k] = dp[i][k - 1] + 1;
                    } else if(k == 0) {
                        // 왼쪽에서 접근하지 못하는 경우를 체크
                        // 위쪽에서 들어오는 경우만 더해줌
                        dp[i][k] = dp[i-1][k] + 1;
                    } else {
                        dp[i][k] = (dp[i-1][k] + 1) + (dp[i][k - 1] + 1);
                    }
                } else {
                    // 주변에 물 웅덩이가 있는 경우

                }
            }
        }
        return answer;
    }

    // 생각해보니 위와 왼쪽만 체크하면 된다.
//    public static boolean check(int x, int y, int[][] puddles) {
//        for(int i=0; i<4; i++) {
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//            for(int k=0; k<puddles.length; k++) {
//                if(nx == puddles[k][0] && ny == puddles[k][1]) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    public static boolean check(int x, int y, int[][] puddles) {
            for(int k=0; k<puddles.length; k++) {
                if(((x-1) == puddles[k][0] && (y) == puddles[k][1]) || (x == puddles[k][0] && (y - 1) == puddles[k][1])) {
                    return true;
                }
            }
        return false;
    }
}
