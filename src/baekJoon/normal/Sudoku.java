package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2580번
public class Sudoku {
    static int[][] arr = new int[10][10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0,0);
    }
    // 행, 열, 3x3 네모 확인용 함수
    static boolean Check(int row, int col, int value){

        for(int i=0; i<9; i++){
            if(arr[i][col] == value)
                return false;
        }

        for(int j=0; j<9; j++) {
            if(arr[row][j] == value)
                return false;
        }

        int Temprow = ((row)/3)*3;
        int Tempcol = ((col)/3)*3;

        for(int i=Temprow; i<Temprow+3; i++){
            for(int j=Tempcol; j<Tempcol+3; j++){
                if(arr[i][j] == value)
                    return false;
            }
        }
        return true;
    }

    static void recur(int row, int col){
        if(col == 9){
            recur(row+1, 0);
        }
        if(row == 9){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        if(arr[row][col] == 0){
            for(int i=1; i<=9; i++){
                if(Check(row, col, i)){
                    arr[row][col] = i;      //맞을 수도 있지만 아닐 수도 있다. 여기서 재귀를 보내고 다시 0으로 풀어줘야 함.
                    recur(row, col+1);
                }
            }
            arr[row][col] = 0;
            return;
        }
        recur(row, col +1);
    }
}
