package woj;

import java.util.*;
import java.io.*;
public class 홀수_마방진 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];
    int counter = 1;
    arr[0][n/2] = counter++;
    int currentRow = 0;
    int currentCol = n/2;
    while(counter <= n*n) {
      if((counter-1) % n == 0) {
        currentRow++;
        currentRow = currentRow >= n ? currentRow - n : currentRow;
      } else {
        currentRow--;
        currentCol++;
        currentRow = currentRow < 0 ? currentRow + n : currentRow >= n ? currentRow - n : currentRow;
        currentCol = currentCol >= n ? currentCol - n : currentCol;
      }
      if(arr[currentRow][currentCol] == 0)
        arr[currentRow][currentCol] = counter++;
    }

    StringBuilder sb = new StringBuilder();
    for(int i=0; i<n; i++) {
      for(int k=0; k<n; k++) {
        sb.append(arr[i][k]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb.toString());
  }
}
