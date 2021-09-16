package Algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        //Solve(Row, Col, Row, Col);
        Solve();
        FindIndex(Row, Col);
        System.out.println(dp[Row][Col]);
    }
    // Bottom-up approach ::
    // to find Cheapest way ::
    static void Solve() {
        int tempUpper, tempDown, tempLeft;
        int Min;
        for(int k=1; k<=Row; k++)
            dp[k][1] = Input[k][1];
        for(int k=2; k<=Col; k++) {
            for(int i=1; i<=Row; i++) {
                if(i == 1 || i == Row) {
                    if(i == 1) {
                        tempUpper = dp[Row][k - 1];
                        tempDown = dp[i + 1][k - 1];
                    }
                    else {
                        tempUpper = dp[Row - 1][k - 1];
                        tempDown = dp[1][k - 1];
                    }
                }
                else{
                    tempUpper = dp[i-1][k-1];
                    tempDown = dp[i+1][k-1];
                }
                tempLeft = dp[i][k-1];
                Min = Math.min(tempUpper, tempDown);
                Min = Math.min(Min, tempLeft);
                dp[i][k] = Min + Input[i][k];
            }
        }
    }
    // Trace Index Value in Completed-dp array ::
    static void FindIndex(int ChangedRow, int ChangedCol) {
        int[] IndexArr = new int[Col];
        int tempUpper, tempDown, tempLeft, Min, iter = 0;
        while(ChangedRow > 0 && ChangedCol > 0) {
            if(ChangedCol == 1) {
                IndexArr[iter++] = dp[ChangedRow][ChangedCol];
                break;
            }
            if(ChangedRow == Row || ChangedRow == 1) {
                if(ChangedRow == 1) {
                    tempUpper = dp[Row][ChangedCol - 1];
                    tempDown = dp[2][ChangedCol - 1];
                }
                else {
                    tempUpper  = dp[ChangedRow - 1][ChangedCol - 1];
                    tempDown = dp[1][ChangedCol - 1];
                }
            }
            else {
                tempUpper = dp[ChangedRow - 1][ChangedCol - 1];
                tempDown = dp[ChangedRow + 1][ChangedCol - 1];
            }
            tempLeft = dp[ChangedRow][ChangedCol - 1];
            Min = Math.min(tempUpper, tempDown);
            Min = Math.min(Min, tempLeft);
            IndexArr[iter++] = dp[ChangedRow][ChangedCol]  - Min;
            if(Min == tempUpper) {
                if(ChangedRow == 1 || ChangedRow == Row) {
                    if(ChangedRow == 1) {
                        ChangedRow = Row;
                        ChangedCol--;
                    }
                    else{
                        ChangedRow = Row-1;
                        ChangedCol--;
                    }
                }
                else{
                    ChangedRow--;
                    ChangedCol--;
                }
            }
            else if(Min == tempDown) {
                if(ChangedRow == 1 || ChangedRow == Row) {
                    if(ChangedRow == 1) {
                        ChangedRow = 2;
                        ChangedCol--;
                    }
                    else{
                        ChangedRow = 1;
                        ChangedCol--;
                    }
                }
                else{
                    ChangedRow++;
                    ChangedCol--;
                }
            }
            else{
                ChangedCol--;
            }
        }
        for(int i=IndexArr.length - 1; i>=0; i--)
            System.out.print(IndexArr[i] + " ");
        System.out.println();
    }
    // 재귀로 구현 :: 실패
    // 이건 굳이 재귀로 안해도 되겠는데?
    /*static int Solve(int row, int col, int prevRow, int prevCol) {
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
    }*/
}

