package woj;

import java.util.*;
import java.io.*;
public class 지그재그_배열3 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n+1][n+1];
    int x = n;
    int y = 1;
    int counter = 1;
    arr[x][y] = counter++;
    // s가 홀수일 경우 우상향, 짝수일 경우 좌하향
    // 우상향의 경우 행은 감소하고 열은 증가한다. 우상향의 끝에 다달은 경우 행만 증가시키고 flag를 반전시킨다.
    // 좌하향의 경우 행은 증가하고 열은 감소한다. 좌하향의 끝에 다달은 경우 열만 증가시키고 flag를 반전시킨다.
    for(int s=1; s<=n-1; s++) {
      if(s % 2 == 1) {
        for(int i=0; i<n-s; i++) {
         arr[--x][++y] = counter++;
        }
        x -= 2;
        arr[x][--y] = counter++;
      } else {
        for(int i=0; i<n-s; i++) {
          arr[++x][--y] = counter++;
        }
        y += 2;
        arr[--x][y] = counter++;
      }
    }
    StringBuilder sb = new StringBuilder();
    for(int k=1; k<=n; k++){
      for(int j=1; j<=n; j++) {
        sb.append(arr[k][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb.toString());
  }

}
