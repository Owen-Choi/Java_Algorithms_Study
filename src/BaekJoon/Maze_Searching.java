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
    static boolean [][] check;
    static int Min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        check = new boolean[N][M];
        for(int i = 0; i<N; i++){
            String line = br.readLine();
            for(int k = 0; k<M; k++){
                arr[i][k] = Integer.parseInt(String.valueOf(line.charAt(k)));
            }
        }
        recur(N - 1, M - 1, 0);
        System.out.println(Min);
    }
    static void recur(int raw, int col, int Count) {
        // 일단 범위에 속해야 확인을 함
        if(raw + 1 <= N) {
            if(arr[raw + 1][col] == 1 && !check[raw + 1][col]) {
                check[raw + 1][col] = true;
                Count++;
                recur(raw + 1, col, Count);
            }
        }
        if(col + 1 <= M) {
            if(arr[raw][col + 1] == 1 && !check[raw][col + 1]) {
                check[raw][col + 1] = true;
                Count++;
                recur(raw, col + 1, Count);
            }
        }
        if(raw - 1 >= 0) {
            if(arr[raw - 1][col] == 1 && !check[raw - 1][col]) {
                check[raw - 1][col] = true;
                Count++;
                recur(raw - 1, col, Count);
            }
        }
        if(col - 1 >= 0) {
            if(arr[raw][col - 1] == 1 && !check[raw][col - 1]) {
                check[raw][col - 1] = true;
                Count++;
                recur(raw, col - 1, Count);
            }
        }
        if(col == 0 && raw == 0) {
            Min = Math.min(Min, Count);
        }
    }
}
