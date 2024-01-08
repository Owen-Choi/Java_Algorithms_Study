package baekJoon.normal;

import java.util.*;
import java.io.*;
public class 치킨_배달 {

  static int n, m;
  static int result = Integer.MAX_VALUE;
  static List<Node> list = new ArrayList<>();
  static List<Node> home = new ArrayList<>();
  static boolean[] flag;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    int[][] arr = new int[n][n];
    // 일단 현재 존재하는 치킨집을 모두 리스트에 넣겠다.
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int k=0; k<n; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
        if(arr[i][k] == 2) {
          list.add(new Node(i, k));
        } else if(arr[i][k] == 1) {
          home.add(new Node(i,k));
        }
      }
    }
    flag = new boolean[list.size()];
    // 완성된 리스트로 DFS를 수행하겠다.
    recur(0, 0);
    System.out.println(result);
  }

  static void recur(int index, int depth) {
    if(depth == m) {
      result = Math.min(result, getChickenDistance());
      return;
    }
    if(index < list.size()) {
      flag[index] = true;
      recur(index+1, depth+1);
      flag[index] = false;
      recur(index+1, depth);
    }
  }

  static int getChickenDistance() {
    int tempMin, tempSum = 0;
    for (Node homeNode : home) {
      tempMin = Integer.MAX_VALUE;
      for(int i=0; i<list.size(); i++) {
        if(flag[i]) {
          Node chicken = list.get(i);
          tempMin = Math.min(tempMin, Math.abs(homeNode.x - chicken.x) + Math.abs(homeNode.y - chicken.y));
        }
      }
      tempSum += tempMin;
    }
    return tempSum;
  }


  static class Node {
    int x;
    int y;
    Node (int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
