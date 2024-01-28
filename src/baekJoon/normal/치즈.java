package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 치즈 {

  static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n,m, hour = 0;
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    // BFS로 탐색하는데, 접촉한 치즈에는 카운트를 추가한다.
    int[][] arr = new int[n][m];
    boolean[][] flag = new boolean[n][m];
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int k=0; k<m; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
      }
    }

    // BFS를 돌리면서 1이거나(외부와 접촉 x) 2(외부와 한번만 접촉)인 치즈는 다시 1로 바꿔준다.
    // 하지만 3이상인 치즈는 0으로 없애준다.
    while(true) {
      boolean isMelted = false;
      bfs(arr, flag, n,m, 0,0);
      bfs(arr, flag, n,m, n-1,0);
      bfs(arr, flag, n,m, 0,m-1);
      bfs(arr, flag, n,m, n-1,m-1);
      // bfs가 종료된 이후, 외부와 접촉한 치즈를 녹여준다.
      for(int i=0; i<n; i++) {
        for(int k=0; k<m; k++) {
          if(arr[i][k] >= 3) {
            isMelted = true;
            arr[i][k] = 0;
          } else if(arr[i][k] == 2) {
            arr[i][k] = 1;
          }
        }
      }
      if(!isMelted) {
        break;
      }
      for(int i=0; i<n; i++) {
        Arrays.fill(flag[i], false);
      }
      hour++;
    }
    System.out.println(hour);
  }

  static void bfs(int[][] arr, boolean[][] flag, int n, int m, int x, int y) {
    if(flag[x][y]) return;
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(x, y));
    flag[x][y] = true;
    while(!queue.isEmpty()) {
      Node poll = queue.poll();
      for(int i=0; i<4; i++) {
        int nextX = poll.x + move[0][i];
        int nextY = poll.y + move[1][i];
        if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m)
          continue;
        if(arr[nextX][nextY] != 0) {
          arr[nextX][nextY]++;
        } else if(arr[nextX][nextY] == 0 && !flag[nextX][nextY]) {
          flag[nextX][nextY] = true;
          queue.offer(new Node(nextX, nextY));
        }
      }
    }
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
