package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 가르침 {

  static String[] input;
  static int[] arr;
  static int result = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n, k;
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    arr = new int[26];
    // a,n,t,i,c 5개 단어는 반드시 배워야 한다.
    // 이걸 못배우면 읽을 수 있는 단어가 없음
    if(k < 5) {
      System.out.println(0);
      return;
    } else if(k == 26) {
      System.out.println(n);
      return;
    }
    arr['a' - 97] = arr['n' - 97] = arr['t' - 97] = arr['i' - 97] = arr['c' - 97] = 1;
    k -= 5;
    input = new String[n];
    for(int i=0; i<n; i++) {
      input[i] = br.readLine();
      for(int j=4; j<input[i].length() - 3; j++) {
        char c = input[i].charAt(j);
        if(c != 'a' && c != 'n' && c != 't' && c != 'i' && c != 'c') {
          arr[c - 97] = 1;
        }
      }
    }

    combination(0, new boolean[26], 0, k);
    System.out.println(result);
  }


  static void combination(int start, boolean[] flag, int depth, int k) {
    flag[0] = flag[2] = flag[8] = flag[13] = flag[19] = true;
    // depth가 k만큼 안나오는 경우도 있다. 이럴 때는 어떻게 해야하지?
    if(depth == k) {
      boolean b;
      int tempResult = 0;
      for(int i=0; i<input.length; i++) {
        b = false;
        for(int j=4; j<input[i].length() - 3; j++) {
          if(!flag[input[i].charAt(j) - 97]) {
            b = true;
            break;
          }
        }
        if(!b)
          tempResult++;
      }
      result = Math.max(tempResult, result);
      return;
    }
    // TODO 이렇게 하면 depth가 반드시 k랑 같아진다는 보장이 없어서 원하는 결과가 안나온다.
    // TODO 그냥 모든 단어에 대해서 조합을 확인하는게 맞는 풀이다. 26의 길이를 가진 문자열을 재귀로 다 탐색하는건 1초라는 시간 안에 가능한가보다.
    for(int i=start; i<26; i++) {
      if(i == 0 || i == 2 || i == 8 || i == 13 || i == 19)
        continue;
      if(arr[i] == 1 && !flag[i]) {
        flag[i] = true;
        combination(i, flag, depth+1, k);
        flag[i] = false;
      }
    }
  }
}
