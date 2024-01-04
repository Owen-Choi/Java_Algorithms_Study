package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 연구소 {

  static boolean[][] flag;
  static int[][] arr;
  static int n,m, result = 0;
  static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    flag = new boolean[n][m];
    // 3중 반복문으로 벽 3개를 세울 수 있는 모든 경우의 수를 다 조사하겠다.
    // 제한시간이 꽤 널널한 편이고, 최대 입력값도 작아 가능할 듯 하다.
    arr = new int[n][m];
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int k=0; k<m; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
      }
    }

    // 벽은 dfs로 세우고, 벽 3개가 다 세워졌을때 bfs를 돌리자.
    buildWall(0);
    System.out.println(result);
  }

  static void buildWall(int wallCount) {
    // 벽을 세우기 위한 dfs
    if(wallCount == 3) {
      bfs();
      return;
    }

    for(int i=0; i<n; i++) {
      for(int k=0; k<m; k++) {
        if(arr[i][k] == 0 && !flag[i][k]) {
          flag[i][k] = true;
          arr[i][k] = 1;
          buildWall(wallCount + 1);
          flag[i][k] = false;
          arr[i][k] = 0;
        }
      }
    }
  }

  static void bfs() {
    // 벽이 쳐져있기 때문에, 바이러스를 bfs로 퍼뜨린다.
    // flag와는 별개로 방문 여부를 나타내기 위한 visit 선언
    boolean[][] visit = new boolean[n][m];
    Queue<Node> queue = new LinkedList<>();
    int[][] map = new int[n][m];
    for(int i=0; i<n; i++) {
      map[i] = arr[i].clone();
    }

    for(int i=0; i<n; i++) {
      for(int k=0; k<m; k++) {
        if(map[i][k] == 2 && !visit[i][k]) {
          queue.offer(new Node(i,k));
          visit[i][k] = true;
          // 바이러스 전이 시작
          while(!queue.isEmpty()) {
            Node poll = queue.poll();
            for(int j=0; j<4; j++) {
              int nextX = poll.x + move[0][j];
              int nextY = poll.y + move[1][j];
              if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
              if(map[nextX][nextY] == 0) {
                map[nextX][nextY] = 2;
                visit[nextX][nextY] = true;
                queue.offer(new Node(nextX, nextY));
              }
            }
          }

        }
      }
    }
    // 바이러스가 퍼진 후 안전 영역의 수를 계산한다.
    int counter = 0;
    for(int i=0; i<n; i++) {
      for(int k=0; k<m; k++) {
        if(map[i][k] == 0) counter++;
      }
    }
    result = Math.max(result, counter);
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
