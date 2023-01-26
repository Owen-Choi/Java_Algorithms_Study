package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 2206
public class Crashing_Wall_and_Move {
    static int N, M;
    static char[][] arr;
    static final int[] upper = {-1, 0, 1, 0};
    static final int[] down = {0, -1, 0, 1};
    static int value = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        String tempLine;
        for(int i=0; i<N; i++) {
            tempLine = br.readLine();
            arr[i] = tempLine.toCharArray();
        }
        //Solve(N-1, M-1, false, 0);
        BFS();
    }
    static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0,1, false));
        boolean [][][] visit = new boolean[N][M][2];
        Point tempPoint;
        int tempX, tempY;
        while(!queue.isEmpty()) {
            tempPoint = queue.poll();
            if(tempPoint.x == N-1 && tempPoint.y == M-1) {
                System.out.println(tempPoint.dist);
                return;
            }

            for(int i=0; i<4; i++) {
                tempX = tempPoint.x + upper[i];
                tempY = tempPoint.y + down[i];

                if(tempX < 0 || tempY < 0 || tempX >= N || tempY >= M)
                    continue;
                if(arr[tempX][tempY] == '0') {
                    if(!tempPoint.brk && !visit[tempX][tempY][0]) {
                        queue.add(new Point(tempX, tempY, tempPoint.dist + 1, false));
                        visit[tempX][tempY][0] = true;
                    }
                    else if(tempPoint.brk && !visit[tempX][tempY][1]) {
                        queue.add(new Point(tempX, tempY, tempPoint.dist + 1, true));
                        visit[tempX][tempY][1] = true;
                    }
                }
                else if(arr[tempX][tempY] == '1') {
                    if(!tempPoint.brk) {
                        queue.add(new Point(tempX, tempY, tempPoint.dist + 1, true));
                        visit[tempX][tempY][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
    /*
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
    }*/
    static class Point {
        int x, y, dist;
        boolean brk;
        public Point(int x, int y, int dist, boolean brk) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.brk = brk;
        }
    }
}
