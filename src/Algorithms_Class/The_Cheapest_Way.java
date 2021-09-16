package Algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class The_Cheapest_Way {
    static int Row, Col;
    static int[][] Input;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Row = Integer.parseInt(st.nextToken());
        Col = Integer.parseInt(st.nextToken());
        Input = new int[Row+1][Col+1];
        dp = new Integer[Row+1][Col+1];
        for(int i= 1; i<=Row; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int k=1; k<=Col; k++) {
                Input[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        // Input ends :: 일단 Java에서는 파일 입출력을 하지 않게끔 구현했다.
        dp[0][0] = 0;
        Solve(Row, Col, Row, Col);
        for(int i=1; i<=Row; i++) {
            for(int k=1; k<=Col; k++) {
                System.out.print(dp[i][k] + " ");
            }
            System.out.println();
        }
    }
    // 재귀로 구현
    static int Solve(int row, int col, int prevRow, int prevCol) {
        // 여기가 문제다....
        if(col == 0)
            return Input[prevRow][prevCol];

        int tempUpper, tempLeft, tempDown;
        int Min;
        if(dp[row][col] == null) {
            for (int i = row; i > 0; i--) {
                for (int k = col; k > 0; k--) {
                    if(i == 1 || i == Row) {
                        // 테이블의 끝과 끝은 원통형태로 붙어있다. 따라서 경계를 넘어가는 경우를 고려해줘야 함.
                        if(i == 1) {
                            tempUpper = Solve(Row, k - 1, i, k);// + Input[Row][k-1];
                            tempDown = Solve(i + 1, k-1, i, k);// + Input[i+1][k-1];
                        }
                        else {
                            tempUpper = Solve(i-1, k - 1, i , k);// + Input[i-1][k-1];
                            tempDown = Solve(1, k - 1, i, k);// + Input[1][k-1];
                        }
                    }
                    else {
                        tempUpper = Solve(i - 1, k - 1, i, k);// + Input[i-1][k-1];
                        tempDown = Solve(i + 1, k - 1, i, k);// + Input[i+1][k-1];
                    }
                    // 여기까지는 대각선들을 상황에 맞게 고려함.
                    tempLeft = Solve(i, k - 1, i, k);
                    Min = Math.min(tempUpper, tempDown);
                    Min = Math.min(Min, tempLeft);
                    dp[row][col] = Min + Input[row][col];
                }
            }
        }
        return dp[row][col];
    }
}

