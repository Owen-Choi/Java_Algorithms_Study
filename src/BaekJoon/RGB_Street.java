package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1149번
public class RGB_Street {
    static int houseNum;
    static Integer[][] dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        houseNum = Integer.parseInt(br.readLine());
        dp = new Integer[houseNum][3];
        arr = new int[houseNum][houseNum];
        for(int i=0; i<houseNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int k=0; k<3; k++)
                arr[i][k] = Integer.parseInt(st.nextToken());
        }
       dp[0][0] = arr[0][0];    dp[0][1] = arr[0][1];   dp[0][2] = arr[0][2];
        recur(0,1);
        int min = dp[houseNum - 1][0];
        for(int i=1; i<3; i++)
            min = Math.min(min, dp[houseNum - 1][i]);
        System.out.println(min);
    }
    static void recur(int color, int depth){
        int tempColor = -100;
        if(depth == houseNum)
            return ;

        if(dp[depth][color] == null) {
            if(color == 0) {
                if(dp[depth - 1][color] + arr[depth][color + 1] > dp[depth-1][color] + arr[depth][color+2]){
                    dp[depth][color] = dp[depth-1][color] + arr[depth][color+2];
                    tempColor = color+2;
                }
                else{
                    dp[depth][color] = dp[depth-1][color] + arr[depth][color + 1];
                    tempColor = color + 1;
                }
            }
            else if(color == 1) {
                if (dp[depth - 1][color] + arr[depth][color - 1] > dp[depth - 1][color] + arr[depth][color + 1]) {
                    dp[depth][color] = dp[depth - 1][color] + arr[depth][color + 1];
                    tempColor = color + 1;
                } else {
                    dp[depth][color] = dp[depth - 1][color] + arr[depth][color - 1];
                    tempColor = color - 1;
                }
            }
            else if(color == 2){
                if (dp[depth - 1][color] + arr[depth][color - 1] > dp[depth - 1][color] + arr[depth][color - 2]) {
                    dp[depth][color] = dp[depth - 1][color] + arr[depth][color - 2];
                    tempColor = color - 2;
                } else {
                    dp[depth][color] = dp[depth - 1][color] + arr[depth][color - 1];
                    tempColor = color - 1;
                }
            }
            recur(tempColor, ++depth);
        }
    }
}
