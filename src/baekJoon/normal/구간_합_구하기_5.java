package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 구간_합_구하기_5 {
//  public static void main(String[] args) throws IOException{
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());
//    int n, m;
//    n = Integer.parseInt(st.nextToken());
//    m = Integer.parseInt(st.nextToken());
//    int[][] sum = new int[n][n];
//    for(int i=0; i<n; i++) {
//      st = new StringTokenizer(br.readLine());
//      for(int k=0; k<n; k++) {
//        if(i == 0 && k == 0) {
//          sum[i][k] = Integer.parseInt(st.nextToken());
//        } else if(k == 0) {
//          sum[i][k] = sum[i-1][n-1] + Integer.parseInt(st.nextToken());
//        } else {
//          sum[i][k] = sum[i][k-1] + Integer.parseInt(st.nextToken());
//        }
//      }
//    }
//    System.out.println();
//    for(int i=0; i<n; i++) {
//      for(int k=0; k<n; k++) {
//        System.out.print(sum[i][k] + " ");
//      }
//      System.out.println();
//    }
//    int x1,y1,x2,y2;
//    int min, max;
//    StringBuilder sb = new StringBuilder();
//    for(int i=0; i<m; i++) {
//      st = new StringTokenizer(br.readLine());
//      x1 = Integer.parseInt(st.nextToken()) - 1;
//      y1 = Integer.parseInt(st.nextToken()) - 1;
//      x2 = Integer.parseInt(st.nextToken()) - 1;
//      y2 = Integer.parseInt(st.nextToken()) - 1;
//      // 네모가 내가 생각한 범위와 많이 다르다.
//      // 행이 바뀌면 열이 처음부터 시작되는 것이 아니라 시작 지점의 열을 기준으로 더 큰 열만 더한다.
//      min = Math.min(y1, y2);
//      max = Math.max(y1, y2);
//
//    }
//    System.out.println(sb.toString());
//  }
}
