package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 경쟁적_전염 {
  static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[][] arr = new int[n][n];
    int time, targetX, targetY;
    PriorityQueue<Node> pq = new PriorityQueue<>();
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<n; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        if(arr[i][j] != 0) {
          pq.offer(new Node(i,j, arr[i][j], 1));
        }
      }
    }
    st = new StringTokenizer(br.readLine());
    time = Integer.parseInt(st.nextToken());
    targetX = Integer.parseInt(st.nextToken());
    targetY = Integer.parseInt(st.nextToken());

    while(!pq.isEmpty()) {
      Node poll = pq.poll();
      if(poll.time > time) {
        break;
      }
      for(int i=0; i<4; i++) {
        int nextX = poll.x + move[0][i];
        int nextY = poll.y + move[1][i];
        if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
          continue;
        }
        if(arr[nextX][nextY] == 0) {
          arr[nextX][nextY] = poll.value;
          pq.offer(new Node(nextX, nextY, poll.value, poll.time + 1));
        }
      }
    }
    System.out.println(arr[targetX - 1][targetY - 1]);

  }

  static class Node implements Comparable<Node>{
    int x;
    int y;
    int value;
    int time;

    public Node(int x, int y, int value, int time) {
      this.x = x;
      this.y = y;
      this.value = value;
      this.time = time;
    }

    @Override
    public int compareTo(Node o) {
      if(o.time == this.time) {
        return this.value - o.value;
      }
      return this.time - o.time;
    }
  }
}
