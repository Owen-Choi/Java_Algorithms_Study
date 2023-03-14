package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Planting_Natural_Cabage {
    static int TestCase;
    static int[][] ground;
    static boolean [][] flag;
    static int RowMAX, ColMAX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TestCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int row, col, Cabage;
        while(TestCase --> 0) {
            st  = new StringTokenizer(br.readLine()," ");
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            Cabage = Integer.parseInt(st.nextToken());
            ground = new int[row][col];
            flag = new boolean[row][col];
            RowMAX = row;   ColMAX = col;
            int tempRow, tempCol;
            for(int i=0; i<Cabage; i++) {
                st = new StringTokenizer(br.readLine()," ");
                tempCol = Integer.parseInt(st.nextToken());
                tempRow = Integer.parseInt(st.nextToken());
                ground[tempRow][tempCol] = 1;
            }
            // 입력부 끝
            sb.append(CountWorms(row, col)).append('\n');
        }
        System.out.println(sb);
    }
    static int CountWorms(int row, int col) {
        int WormCount = 0;
        for(int i=0; i<row; i++){
            for(int k=0; k<col; k++) {
                if(ground[i][k] == 1 && !flag[i][k]) {
                    deep(i, k);             //연결된 1을 찾아 파고들면서 flag를 1로 바꿔줌
                    WormCount++;
                }
            }
        }
        return WormCount;
    }
    // deep은 재귀로 돌린다.
    static void deep(int row, int col) {
        // IndexOutOfBounds 방지
        if(row < 0 || col < 0 || row >= RowMAX || col >= ColMAX)
            return;
        if(ground[row][col] == 1 && !flag[row][col]) {
            flag[row][col] = true;
        } else return;

        deep(row - 1, col);
        deep(row + 1, col);
        deep(row, col + 1);
        deep(row, col - 1);
    }
}
