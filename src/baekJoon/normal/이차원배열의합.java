//package baekJoon.normal;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class 이차원배열의합 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        int n,m;
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        int[][] arr = new int[n][m];
//        int[][] sum = new int[n][m];
//        for(int i=0; i<n; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            for(int k=0; k<m; k++) {
//                arr[i][k] = Integer.parseInt(st.nextToken());
//            }
//        }
//        int k = Integer.parseInt(br.readLine());
//        int cumSum = 0;
//        // 2차원 배열의 누적합
//        for(int j=0; j<m; j++) {
//            for(int i=0; i<n; i++) {
//                sum[i][j] = cumSum + arr[i][j];
//                cumSum = sum[i][j];
//            }
//        }
//        int curX, curY, nextX, nextY;
//        StringBuilder sb = new StringBuilder();
//        for(int i=0; i<k; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            curX = Integer.parseInt(st.nextToken()) - 1;
//            curY = Integer.parseInt(st.nextToken()) - 1;
//            nextX = Integer.parseInt(st.nextToken()) - 1;
//            nextY = Integer.parseInt(st.nextToken()) - 1;
//            sb.append(sum[nextX][nextY] - sum[curX][curY] + arr[curX][curY]).append("\n");
//        }
//        System.out.println(sb.toString());
//    }
//
//}

package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이차원배열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n,m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][] sum = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int k=0; k<m; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        // 2차원 배열의 누적합은 내가 생각한 것이랑 다른 부분이 있는 것 같다.
        // 각 열마다 세로로 누적합을 구하는 개념인 듯 하다.
        // 왜 그렇지?
        int cumSum;
        for(int k=0; k<m; k++) {
            cumSum = 0;
            for(int i=0; i<n; i++) {
                sum[i][k] = cumSum + arr[i][k];
                cumSum = sum[i][k];
            }
        }
        int k = Integer.parseInt(br.readLine());
        int curX, curY, nextX, nextY;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            curX = Integer.parseInt(st.nextToken()) - 1;
            curY = Integer.parseInt(st.nextToken()) - 1;
            nextX = Integer.parseInt(st.nextToken()) - 1;
            nextY = Integer.parseInt(st.nextToken()) - 1;
        }
    }
}