package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 뿌요뿌요 {

  static final int row = 12, col = 6;
  static char[][] arr = new char[row][col];
  static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for(int i=0; i<row; i++) {
      String temp = br.readLine();
      for(int k=0; k<col; k++) {
        arr[i][k] = temp.charAt(k);
      }
    }
    bfs();
  }

  static void bfs() {
    Queue<Node> queue = new LinkedList<>();
    boolean isChange = false;
    int result = 0;
    while(true) {
      for(int i=0; i<row; i++) {
        for(int k=0; k<col; k++) {
          if(arr[i][k] != '.' && arr[i][k] != '+') {
            boolean[][] flag = new boolean[row][col];
            // 탐색을 실시한다. 한번이라도 팝이 일어났다면, isChange를 변경해준 뒤 rebuild를 수행해준다.
            LinkedList<Node> list = new LinkedList<>();
            char primitive = arr[i][k];
            queue.offer(new Node(i, k));
            list.add(new Node(i,k));
            flag[i][k] = true;
            while(!queue.isEmpty()) {
              Node poll = queue.poll();
              for(int j=0; j<4; j++) {
                int nextX = poll.x + move[0][j];
                int nextY = poll.y + move[1][j];
                if(nextX < 0 || nextX>=row || nextY < 0 || nextY >= col) {
                  continue;
                }
                if(!flag[nextX][nextY] && arr[nextX][nextY] == primitive ) {
                  Node next = new Node(nextX, nextY);
                  flag[nextX][nextY] = true;
                  queue.offer(next);
                  list.add(next);
                }
              }
            }
            // 큐가 끝난 뒤, 리스트의 크기가 4 이상이라면 pop을 수행해준다.
            if(list.size() >= 4) {
              isChange = true;
              pop(list);
            }
          }
        }
      }
      // 반복문이 끝났음에도 isChange가 변하지 않았다면, 더 이상의 변화는 없다는 것을 의미하므로 루프를 나간다.
      if(!isChange) {
        break;
      }
      isChange = false;
      rebuild();
      result++;
    }
    System.out.println(result);
  }

//  static void rebuild() {
//    for(int k=0; k<col; k++) {
//      int i = 0;
//      // 위에서부터 '+'를 찾으며, 순차적으로 내려준다.
//      while(i < row) {
//        while(i < row && arr[i][k] != '+') {
//          i++;
//        }
//        // i가 row가 아닌데 while문이 종료됐다는 것은 '+'를 만났다는 것이다.
//        int startX = i, iterator = i, plusCounter = 0;
//        while(iterator < row && arr[iterator][k] == '+') {
//          plusCounter++; iterator++;
//        }
//        // 이제 시작지점보다 위에 위치하는 블럭들을 아래로 내려준다.
//        while(startX > 0) {
//          arr[--startX + plusCounter][k] = arr[startX][k];
//        }
//      }
//      // i == row 라면 바닥에 도달할 때 까지 '+'를 만나지 못했다는 것이다.
//    }
//  }

  static void rebuild() {
    // 오늘도 배워갑니다...
    Queue<Character> queue = new LinkedList<>();
    for(int k=0; k<col; k++) {
      for(int i=row - 1; i>=0; i--) {
        if(arr[i][k] != '.' && arr[i][k] != '+') {
          queue.offer(arr[i][k]);
          arr[i][k] = '.';
        }
      }

      int counter = row - 1;
      while(!queue.isEmpty()) {
        arr[counter--][k] = queue.poll();
      }
    }
  }

  static void pop(List<Node> list) {
    // pop과 rebuild를 동시에 수행하면 안된다.
    // 여러 개의 pop이 발생할 때 예외가 발생하기 때문.
    for (Node node : list) {
      arr[node.x][node.y] = '+';
    }
  }

  static class Node {
    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
