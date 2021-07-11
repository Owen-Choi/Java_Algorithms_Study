package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2580번
public class Sudoku {
    static int[][] arr = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int k=0; k<9; k++){
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0,0);

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void recur(int i, int j){
        for(int col=i; col<9; col++){
            for(int raw = j; raw < 9; raw++){
                checkCol(raw);
                checkRaw(col);
                if(col +1 % 3 == 0 && raw + 1 % 3 == 0)
                    checkSquare(col, raw);
            }
        }
    }
    // 가로 체크
    static void checkRaw(int j){
        boolean[] exist = new boolean[9];
        int trueCount = 0;
        for(int i=0; i<9; i++){
            if(arr[i][j] != 0) {
                exist[arr[i][j]-1] = true;
                trueCount++;
            }
        }
        if(trueCount == 8){
            for(int p=0; p<9; p++){
                if(exist[p] == false)
                    arr[p][j] = p;
            }
        }
        else
            return;
    }
    // 세로 체크
    static void checkCol(int i){
        boolean[] exist = new boolean[9];
        int trueCount = 0;
        for(int j=0; j<9; j++){
            if(arr[i][j] != 0){
                exist[arr[i][j] - 1] = true;
                trueCount++;
            }
        }
        if(trueCount == 8){
            for(int k=0; k<9; k++){
                if(exist[k] == false)
                    arr[i][k] = k;
            }
        }
        else
            return;
    }
    // 사각형 체크
    static void checkSquare(int i, int j){
        int[][] exist = {{0,0,0}, {0,0,0}, {0,0,0}};

        int trueCount = 0;
        for(int TI = i; TI <= i+2; TI++){
            for(int TJ = j; TJ <= j+2; TJ++){
                if(arr[TI][TJ] != 0){
                    exist[TI][TJ] = arr[TI][TJ];
                    trueCount++;
                }
            }
        }
        if(trueCount == 8){
            for(int TI = i; TI <= i+2; TI++){
                for(int TJ = j; TJ <= j+2; TJ++){
                    if(exist[TI][TJ] != 0){
                        arr[TI][TJ] = exist[TI][TJ];
                    }
                }
            }
        }
        else
            return;
    }
}
