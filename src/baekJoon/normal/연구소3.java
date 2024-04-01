package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 연구소3 {

//  static int n,m, result = Integer.MAX_VALUE, spaceCount = 0;
//  static int[][] arr, move = {{-1,1,0,0}, {0,0,-1,1}};
//  static List<Node> viruses = new ArrayList<>();
//  public static void main(String[] args) throws IOException{
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    StringTokenizer st = new StringTokenizer(br.readLine());
//    n = Integer.parseInt(st.nextToken());
//    m = Integer.parseInt(st.nextToken());
//    arr = new int[n][n];
//
//    for(int i=0; i<n; i++) {
//      st = new StringTokenizer(br.readLine());
//      for(int k=0; k<n; k++) {
//        arr[i][k] = Integer.parseInt(st.nextToken());
//        if(arr[i][k] == 2) {
//          viruses.add(new Node(i, k));
//        }
//        if(arr[i][k] == 0)
//          spaceCount++;
//      }
//    }
//    if(spaceCount == 0) {
//      System.out.println(0);
//      return;
//    }
//    combination(0, 0, new ArrayList<>());
//    System.out.println(result == Integer.MAX_VALUE ? -1 : result);
//  }
//
//  // m개의 위치를 골라서 조합
//  // 문제에서 m개를 바꾼다고 명시했기 때문에 비활성 바이러스가 m개보다 적은 일은 없을 것이라 가정하겠다.
//  static void combination(int start, int depth, List<Node> list) {
//    if(depth == m) {
//      // BFS 시작
//      bfs(list);
//      return;
//    }
//    for(int i=start; i<viruses.size(); i++) {
//      // 중복체크는 필요없어보인다.
//      list.add(viruses.get(i));
//      combination(i, depth+1, list);
//      list.remove(list.size() - 1);
//    }
//  }
//
//  static void bfs(List<Node> list) {
//    Queue<Node> queue = new LinkedList<>();
//    boolean[][] flag = new boolean[n][n];
//    for(int i=0; i<list.size(); i++) {
//      flag[list.get(i).x][list.get(i).y] = true;
//      queue.offer(list.get(i));
//    }
//    int second = 0, infectedSpaceCount = 0; // or 1
//    while(!queue.isEmpty()) {
//      int size = queue.size();
//      // 레벨 단위 큐
//      for(int j=0; j<size; j++) {
//        Node poll = queue.poll();
//        for(int i=0; i<4; i++) {
//          int nextX = poll.x + move[0][i];
//          int nextY = poll.y + move[1][i];
//          if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
//            continue;
//          }
//          if(!flag[nextX][nextY] && arr[nextX][nextY] != 1) {
//            flag[nextX][nextY] = true;
//            if(arr[nextX][nextY] == 0)
//              infectedSpaceCount++;
//            queue.offer(new Node(nextX, nextY));
//          }
//        }
//      }
//      second++;
//    }
//  }
//
//
//  static class Node {
//    int x;
//    int y;
//    Node(int x, int y) {
//      this.x = x;
//      this.y = y;
//    }
//  }

  static int n,m, result = Integer.MAX_VALUE, spaceCount = 0;
  static int[][] arr, move = {{-1,1,0,0}, {0,0,-1,1}};
  static List<Node> viruses = new ArrayList<>();
  static boolean[] flag;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[n][n];

    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int k=0; k<n; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
        if(arr[i][k] == 2) {
          viruses.add(new Node(i, k, 0));
        }
        if(arr[i][k] == 0)
          spaceCount++;
      }
    }
    flag = new boolean[viruses.size()];
    if(spaceCount == 0) {
      System.out.println(0);
      return;
    }
    combination(0, 0, new ArrayList<>());
    System.out.println(result == Integer.MAX_VALUE ? -1 : result);
  }

  static void combination(int start, int depth, List<Node> list) {
    if(depth == m) {
      bfs(list);
      return;
    }
    for(int i=start; i< viruses.size(); i++) {
      if(!flag[i]) {
        flag[i] = true;
        list.add(viruses.get(i));
        combination(i, depth+1, list);
        list.remove(list.size() - 1);
        flag[i] = false;
      }
    }
  }

  static void bfs(List<Node> list) {
    Queue<Node> queue = new LinkedList<>();
    boolean[][] visited = new boolean[n][n];
    for(int i=0; i<list.size(); i++) {
      queue.offer(list.get(i));
      visited[list.get(i).x][list.get(i).y] = true;
    }
    int spaceCountCopy = spaceCount;
    // 레벨단위 큐를 활용하면 시간 초과를 맞는다.
    while(!queue.isEmpty()) {
      Node poll = queue.poll();
      for(int i=0; i<4; i++) {
        int nextX = poll.x + move[0][i];
        int nextY = poll.y + move[1][i];

        if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
          continue;
        }
        if(visited[nextX][nextY] || arr[nextX][nextY] == 1) {
          continue;
        }

        if(arr[nextX][nextY] == 0) {
          spaceCountCopy--;
        }

        if(spaceCountCopy == 0) {
          result = Math.min(result, poll.time + 1);
          return;
        }

        visited[nextX][nextY] = true;
        queue.offer(new Node(nextX, nextY, poll.time + 1));
      }
    }

  }


  static class Node {
    int x;
    int y;
    int time;
    Node(int x, int y, int time) {
      this.x = x;
      this.y = y;
      this.time = time;
    }
  }
}
