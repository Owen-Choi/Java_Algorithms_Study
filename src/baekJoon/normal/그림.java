package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그림 {
  static int width = 0, count = 0;
  static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n,m;
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    int[][] arr = new int[n][m];
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int k=0; k<m; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
      }
    }

    boolean[][] flag = new boolean[n][m];
    for(int i=0; i<n; i++) {
      for(int k=0; k<m; k++) {
        if(!flag[i][k] && arr[i][k] == 1) {
          bfs(flag, arr, i,k);
        }
      }
    }
    System.out.println(count);
    System.out.println(width);
  }

  static void bfs(boolean[][] flag, int[][] arr, int x, int y) {
    Queue<Node> queue = new LinkedList<>();
    int _n = flag.length, _m = flag[0].length, tempWidth = 1;
    flag[x][y] = true;
    queue.offer(new Node(x, y));
    count++;
    while(!queue.isEmpty()) {
      Node poll = queue.poll();
      for(int i=0; i<4; i++) {
        int nextX = poll.x + move[0][i];
        int nextY = poll.y + move[1][i];
        if(nextX < 0 || nextX >= _n || nextY < 0 || nextY >= _m) {
          continue;
        }
        if(!flag[nextX][nextY] && arr[nextX][nextY] == 1) {
          flag[nextX][nextY] = true;
          tempWidth++;
          queue.offer(new Node(nextX, nextY));
        }
      }
    }
    width = Math.max(width, tempWidth);
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
