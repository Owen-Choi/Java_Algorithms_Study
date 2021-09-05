package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 7576번
public class Tomato {
    static int row, col;
    static int[][] arr;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        arr = new int[row][col];
        for(int i=0; i<row; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int k=0; k<col; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        // 입력부 끝
        // 재귀를 돌리고, 0이 하나라도 있다면 -1 출력
        borne(row-1, col-1, 0);
        for(int i=0; i<row; i++) {
            for(int k=0; k<col; k++){
                System.out.print(arr[i][k] + " ");
                }
            System.out.println();
            }
        System.out.println(result);
    }
    private static void borne(int Srow, int Scol, int days) {
        int newDays = days;
        if(Srow < 0 || Scol < 0 || Srow >= row || Scol >= col) {
            // 범위를 벗어나면 return;
            return;
        }
        if(arr[Srow][Scol] == 0) {
            arr[Srow][Scol] = 1;
            newDays = days + 1;
        }
        if(arr[Srow][Scol] == -1)
            return;

            borne(Srow - 1, Scol, newDays);
            borne(Srow + 1, Scol, newDays);
            borne(Srow, Scol - 1, newDays);
            borne(Srow, Scol + 1, newDays);
        result = Math.max(result, newDays);
    }
}
