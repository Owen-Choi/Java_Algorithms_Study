package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 2178번
public class Maze_Searching {
    static int N;
    static int M;
    static int [][] arr;
    static int [] Change_CoX = {-1,0,1,0};
    static int [] Change_CoY = {0,-1,0,1};
    static boolean [][] check;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N + 1][M + 1];
            check = new boolean[N + 1][M + 1];
            for(int i = 0; i<N; i++){
                String line = br.readLine();
                for(int k = 0; k<M; k++){
                    arr[i][k] = Integer.parseInt(String.valueOf(line.charAt(k)));
                }
            }
            check[0][0] = true;
            BFS(0,0);
            System.out.println(arr[N-1][M-1]);
        }
    static void BFS(int X, int Y) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(X,Y));
        while(!queue.isEmpty()) {
            Coordinate Temp = queue.poll();
            for(int i=0; i<4; i++) {
               int next_X = Temp.x + Change_CoX[i];
               int next_Y = Temp.y + Change_CoY[i];

               if(next_X >= N || next_X < 0 || next_Y >= M || next_Y < 0){
                   continue;
               }
               if(check[next_X][next_Y] || arr[next_X][next_Y] == 0) {
                   continue;
               }
               queue.add(new Coordinate(next_X, next_Y));
               arr[next_X][next_Y] = arr[Temp.x][Temp.y] + 1;
               check[Temp.x][Temp.y] = true;
            }
        }
    }
    private static class Coordinate{
            int x;
            int y;
            public Coordinate(int x, int y) {
                this.x = x;
                this.y = y;
            }
    }
}
