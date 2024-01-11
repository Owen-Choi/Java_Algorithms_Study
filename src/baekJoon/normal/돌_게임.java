package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 돌_게임 {

  public static final boolean CY = true;
  public static final boolean SK = false;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n;
    n = Integer.parseInt(br.readLine());

    boolean[] arr = new boolean[n+1];
    arr[1] = SK;
    if(n > 1) {
      arr[2] = CY;
      if(n > 2) {
        arr[2] = CY;
        arr[3] = SK;
        for(int i=4; i<=n; i++) {
          if(i % 2 == 1) {
            arr[i] = arr[i-1] == SK || arr[i-3] == CY ? SK : CY;
            continue;
          }
          arr[i] = arr[i-1] == SK || arr[i-3] == SK ? CY : SK;
        }
      }
    }
    System.out.println(arr[n] ? "CY" : "SK");
  }

}
