package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1149번
public class RGB_Street {
    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;
    static int houseNum;
    static Integer[][] dp;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        houseNum = Integer.parseInt(br.readLine());
        dp = new Integer[houseNum][3];
        arr = new int[houseNum][houseNum];
        for (int i = 0; i < houseNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int k = 0; k < 3; k++)
                arr[i][k] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for(int i=1; i < houseNum; i++){
            for(int k = 0; k<3; k++){
                if(dp[i][k] == null){
                    if(k == RED)
                        dp[i][k] = Math.min(dp[i-1][BLUE], dp[i-1][GREEN]) + arr[i][k];
                    if(k == GREEN)
                        dp[i][k] = Math.min(dp[i-1][RED], dp[i-1][BLUE]) + arr[i][k];
                    if(k == BLUE)
                        dp[i][k] = Math.min(dp[i-1][RED], dp[i-1][GREEN]) + arr[i][k];
                }
            }
        }
        System.out.println(Math.min(dp[houseNum - 1][RED], Math.min(dp[houseNum - 1][GREEN], dp[houseNum - 1][BLUE])));
    }
}
