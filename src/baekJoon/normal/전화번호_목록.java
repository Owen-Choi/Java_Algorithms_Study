package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 전화번호_목록 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    while (tc --> 0) {
      int n = Integer.parseInt(br.readLine());
      String[] arr = new String[n];
      for (int i = 0; i < n; i++) {
        arr[i] = br.readLine();
      }
      boolean flag = false;
      Arrays.sort(arr);
      for(int i=1; i<n; i++) {
        if(arr[i].startsWith(arr[i-1])) {
          flag = true;
          break;
        }
      }
      if(!flag) {
        sb.append("YES");
      } else {
        sb.append("NO");
      }
      sb.append("\n");
    }
    System.out.println(sb.toString());
  }
}
