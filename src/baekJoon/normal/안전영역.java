package baekJoon.normal;

import java.util.*;
import java.io.*;
public class 안전영역 {

  static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
  static boolean[][] flag;
  static int[][] arr;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    arr = new int[n][n];
    // 잠긴 여부와 방문 여부를 아래 flag 배열 하나로 판단하겠다. 이렇게 해도 문제가 없을 듯 하다.
    flag = new boolean[n][n];
    StringTokenizer st;
    // 주어진 지역 중 가장 높은 지역을 찾아서 해당 지역이 잠길때까지 카운트를 증가시키며 시뮬레이션
    int max = 0;
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int k=0; k<n; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
        max = Math.max(arr[i][k], max);
      }
    }
    int rain = 1, loopResult = 0, result = 0;
    while(rain <= max) {
      // 빗물이 하나 증가했기 때문에 일단 지도에 먼저 반영을 해준다.
      flood(rain, n);
      for(int i=0; i<n; i++) {
        for(int k=0; k<n; k++) {
          if(!flag[i][k]) {
            loopResult++;
            bfs(i, k, n);
          }
        }
      }
      result = Math.max(loopResult, result);
      loopResult = 0;
      // 사용한 boolean 배열은 다음 루프를 위해 초기화해준다. - 해당 코드로 인해 메모리 초과가 발생한 것 같다.
      for(int i=0; i<n; i++) {
        Arrays.fill(flag[i], false);
      }
      rain++;
    }
    System.out.println(result == 0 ? 1 : result);
  }

  static void flood(int value, int n) {
    for(int i=0; i<n; i++) {
      for(int k=0; k<n; k++) {
        if(arr[i][k] <= value)
          flag[i][k] = true;
      }
    }
  }

  static void bfs(int x, int y, int n) {
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(x, y));
    while(!queue.isEmpty()) {
      Node poll = queue.poll();
      for(int i=0; i<4; i++) {
        int nextX = poll.x + move[0][i];
        int nextY = poll.y + move[1][i];
        if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n)
          continue;
        if(!flag[nextX][nextY]) {
          flag[nextX][nextY] = true;
          queue.offer(new Node(nextX, nextY));
        }
      }
    }
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
