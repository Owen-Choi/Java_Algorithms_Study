package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 2178번
public class Maze_Searching {
    static int N;
    static int M;
    static int [][] arr;
    static int [][] temp;
    static int Min = Integer.MAX_VALUE - 1000;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N + 1][M + 1];
            boolean[][] check = new boolean[N + 1][M + 1];
            temp = new int[N+1][M+1];
            for(int i = 0; i<N; i++){
                String line = br.readLine();
                for(int k = 0; k<M; k++){
                    arr[i][k] = Integer.parseInt(String.valueOf(line.charAt(k)));
                    temp[i][k] = Integer.MAX_VALUE - 1000;
                }
            }
            check[N-1][M-1] = true;
            temp[N-1][M-1] = 1;
            recur(N - 1, M - 1, check);
            System.out.println(Min);
        }

        static void recur(int raw, int col, boolean[][] check){
            // 일단 범위에 속해야 확인을 함

            if(raw == 0 && col == 0){
                Min = Math.min(temp[0][0], Min);
                return;
            }

            if (raw + 1 <= N) {
                if (arr[raw + 1][col] == 1 && !check[raw + 1][col]) {
                    check[raw + 1][col] = true;
                    temp[raw+1][col] = temp[raw][col] + 1;
                    recur(raw + 1, col, check);
                    check[raw + 1][col] = false;
                }
            }
            if (col + 1 <= M) {
                if (arr[raw][col + 1] == 1 && !check[raw][col + 1]) {
                    check[raw][col + 1] = true;
                    temp[raw][col + 1] = temp[raw][col]+ 1;
                    recur(raw, col + 1, check);
                    check[raw][col + 1] = false;
                }
            }
            if (raw - 1 >= 0) {
                if (arr[raw - 1][col] == 1 && !check[raw - 1][col]) {
                    check[raw - 1][col] = true;
                    temp[raw-1][col] = temp[raw][col] + 1;
                    recur(raw - 1, col, check);
                    check[raw - 1][col] = false;
                }
            }
            if (col - 1 >= 0) {
                if (arr[raw][col - 1] == 1 && !check[raw][col - 1]) {
                    check[raw][col - 1] = true;
                    temp[raw][col-1] = temp[raw][col] + 1;
                    recur(raw, col - 1, check);
                    check[raw][col - 1] = false;
                }
            }
        }
}
