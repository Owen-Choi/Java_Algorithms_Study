package woj;

import java.util.*;
import java.io.*;
public class 방_배정하기 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a, b, c, n;
    StringTokenizer st =  new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    // 플로이드 워셜 알고리즘
    // a명, b명, c명 들어갈 수 있는 방
    for(int i=0; i<=n/a; i++) {
      for(int k=0; k<=n/b; k++) {
        for(int j=0; j<=n/c; j++) {
          if((a * i) + (b * k) + (c * j) == n) {
            System.out.println(1);
            return;
          }
        }
      }
    }
    System.out.println(0);
  }
}
