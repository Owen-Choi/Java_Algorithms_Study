package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 2206
public class Crashing_Wall_and_Move {
    static int N, M;
    static char[][] arr;
    static int value = Integer.MAX_VALUE;
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        check = new boolean[N][M];
        String tempLine;
        for(int i=0; i<N; i++) {
            tempLine = br.readLine();
            arr[i] = tempLine.toCharArray();
        }
        Solve(N-1, M-1, false, 0);
        if(value == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(value);
    }
    static void Solve(int x, int y, boolean flag, int distValue) {

        if(x == 0 && y == 0) {
            value = Math.min(value, distValue + 1);
        }
        // constraints
        if(x < 0 || x > N-1 || y < 0 || y > M-1)
            return;
        else if(check[x][y])
            return;
        else if(arr[x][y] == '1' && flag)
            return;
        else if(arr[x][y] == '1' && !flag) {
            flag = true;
        }
        check[x][y] = true;
        Solve(x+1, y, flag, distValue + 1);
        Solve(x, y+1, flag, distValue + 1);
        Solve(x-1,y, flag, distValue + 1);
        Solve(x, y-1, flag, distValue + 1);
        check[x][y] = false;
    }
}
