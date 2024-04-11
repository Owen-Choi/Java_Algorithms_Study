package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 미로_탐색 {

  static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n, m;
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    int[][] arr = new int[n][m];
    for(int i=0; i<n; i++) {
      String input = br.readLine();
      for(int k=0; k<m; k++) {
        arr[i][k] = input.charAt(k) - '0';
      }
    }
    // 1은 이동 가능, 0은 이동 불가능
    boolean[][] flag = new boolean[n][m];
    Queue<Node> queue = new LinkedList<>();
    flag[0][0] = true;
    queue.offer(new Node(0,0));
    while(!queue.isEmpty()) {
      Node poll = queue.poll();
      for(int i=0; i<4; i++) {
        int nextX = poll.x + move[0][i];
        int nextY = poll.y + move[1][i];
        if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
          continue;
        }
        if(!flag[nextX][nextY] && arr[nextX][nextY] != 0) {
          flag[nextX][nextY] = true;
          arr[nextX][nextY] = arr[poll.x][poll.y] + 1;
          queue.offer(new Node(nextX, nextY));
        }
      }
    }
    System.out.println(arr[n-1][m-1]);
  }

  static class Node {
    int x;
    int y;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
