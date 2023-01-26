package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 7576번
public class Tomato {
    static int row, col;
    static int[][] arr;
    static boolean[][] flag;
    static int result = 0;
    static int[] calcX = {-1, 0, 1, 0};
    static int[] calcY = {0, -1, 0, 1};
    static boolean isBorned;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        arr = new int[row][col];
        flag = new boolean[row][col];
        for(int i=0; i<row; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int k = 0; k < col; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        // 입력부 끝
        Queue<Seed> queue = new LinkedList<>();
        for(int i=0; i<row; i++) {
            for(int k=0; k<col; k++) {
                if(arr[i][k] == 1)
                    queue.add(new Seed(i, k, 0));
            }
        }
        GetDay(queue);
        for(int i=0; i<row; i++) {
            for(int k=0; k<col; k++) {
                if(arr[i][k] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
                result = Math.max(result, arr[i][k]);
            }
        }
        if(isBorned)
            System.out.println(result);
        else
            System.out.println(result - 1);
    }
    static class Seed{
        int row, col, day;

        public Seed(int row, int col, int day) {
            this.day = day;
            this.row = row;
            this.col = col;
        }
    }

    static void GetDay(Queue<Seed> queue) {
        Seed temp;
        int nextX, nextY;
        while(!queue.isEmpty()){
            temp = queue.poll();
            for(int i=0; i<4; i++) {
                nextX = temp.row + calcX[i];
                nextY = temp.col + calcY[i];

                if(nextX < 0 || nextY < 0 || nextX >= row || nextY >= col)
                    continue;
                else if(arr[nextX][nextY] != 0)
                    continue;
                else{
                    isBorned = true;            //한번이라도 들어갔다면 변수 체크
                    arr[nextX][nextY] = temp.day + 1;
                    queue.add(new Seed(nextX, nextY, temp.day + 1));
                }
            }
        }
    }
}
