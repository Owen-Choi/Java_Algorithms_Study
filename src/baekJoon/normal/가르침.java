package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 가르침 {

  static String[] input;
  static int result = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n, k;
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    boolean[] flag = new boolean[26];
    // a,n,t,i,c 5개 단어는 반드시 배워야 한다.
    // 이걸 못배우면 읽을 수 있는 단어가 없음
    if(k < 5) {
      System.out.println(0);
      return;
    } else if(k == 26) {
      System.out.println(n);
      return;
    }
    flag['a' - 97] = flag['n' - 97] = flag['t' - 97] = flag['i' - 97] = flag['c' - 97] = true;
    k -= 5;
    input = new String[n];

    for(int i=0; i<n; i++) {
      input[i] = br.readLine();
      input[i].replaceAll("anta", "");
      input[i].replaceAll("tica", "");
    }
    combination(0, flag, 0, k);
    System.out.println(result);
  }


  static void combination(int start, boolean[] flag, int depth, int k) {
    if(depth == k) {
      boolean b;
      int tempResult = 0;
      for(int i=0; i<input.length; i++) {
        b = false;
        for(int j=0; j<input[i].length(); j++) {
          if(!flag[input[i].charAt(j) - 97]) {
            b = true;
            break;
          }
        }
        if(!b) {
          tempResult++;
        }
      }
      result = Math.max(result, tempResult);
      return;
    }

    for(int i=start; i<26; i++) {
      if(!flag[i]) {
        flag[i] = true;
        combination(i, flag, depth+1, k);
        flag[i] = false;
      }
    }
  }
}
