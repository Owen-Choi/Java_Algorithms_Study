package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 2667번
public class Giving_Apartment_Number {
    static int N;
    static int [][] arr;
    static boolean[][] check;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int apartNum;
    static int[] apart;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N+1][N+1];
        check = new boolean[N+1][N+1];
        apart = new int[N * N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int k=0; k<N; k++) {
                arr[i][k] = line.charAt(k) - '0';
            }
        }

        for(int i=0; i<N; i++){
            for(int k=0; k<N; k++){
                if(arr[i][k] == 1 && !check[i][k]) {
                    apartNum++;
                    DFS(i,k);
                }
            }
        }
        Arrays.sort(apart);
        System.out.println(apartNum);
        for(int i=0; i<apart.length; i++){
            if(apart[i] != 0)
                System.out.println(apart[i]);
        }
    }
    static void DFS(int x, int y) {
        check[x][y] = true;
        apart[apartNum]++;
        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                if(arr[nextX][nextY] == 1 && !check[nextX][nextY]){
                    DFS(nextX, nextY);
                }
            }
        }
    }
}
