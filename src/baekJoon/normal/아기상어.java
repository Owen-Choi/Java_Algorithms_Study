package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {

  static Node shark;
  static Node nextFish = new Node(0, 0, 7);
  static int minDist = Integer.MAX_VALUE;
  static int[][] arr, move = {{-1, 1, 0, 0}, {0, 0, -1, 1}};

  // 뚜뚜루두뚜두
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    arr = new int[n][n];
    int time = 0;
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int k = 0; k < n; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
        if (arr[i][k] == 9) {
          shark = new Node(i, k, 2);
        }
      }
    }
    int required = 0;
    while(true) {
      for (int i = 0; i < n; i++) {
        for (int k = 0; k < n; k++) {
          if (arr[i][k] != 0 && arr[i][k] != 9) {
            check(i, k);
          }
        }
      }
      if(minDist == Integer.MAX_VALUE) {
        System.out.println(time);
        return;
      }
      time += minDist;
      minDist = Integer.MAX_VALUE;
      // 상어가 고기를 잡아먹음
      arr[nextFish.x][nextFish.y] = 0;
      // 상어의 현재 위치 옮김
      arr[shark.x][shark.y] = 0;
      shark.x = nextFish.x;
      shark.y = nextFish.y;
      arr[shark.x][shark.y] = 9;
      nextFish = new Node(0,0,7);
      // 먹을 만큼 먹었으면 상어의 크기를 하나 늘려준다.
      required++;
      if(required == shark.size) {
        shark.size++;
        required = 0;
      }
    }

  }

  static void check(int x, int y) {
    if (arr[x][y] >= shark.size) {
      return;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(shark.x, shark.y, shark.size));
    boolean[][] flag = new boolean[arr.length][arr[x].length];
    // 레벨단위 BFS 적용해야함
    int distance = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int k = 0; k < size; k++) {
        Node node = queue.poll();
        for (int i = 0; i < 4; i++) {
          int nextX = node.x + move[0][i];
          int nextY = node.y + move[1][i];
          if (nextX < 0 || nextX >= arr.length || nextY < 0 || nextY >= arr.length) {
            continue;
          }
          // 이동 가능한 경우
          if (!flag[nextX][nextY] && arr[nextX][nextY] <= shark.size) {
            flag[nextX][nextY] = true;
            // 크기가 같아서 먹을 수는 없는 경우. 그냥 지나가기만 한다.
            if (arr[nextX][nextY] == shark.size) {
              queue.offer(new Node(nextX, nextY, arr[nextX][nextY]));
            }
            // 물고기를 먹을 수 있는 경우
            else {
              if(nextX == x && nextY == y) {
                // 좌상단은 여기서 고려하겠다. 거리가 같다면 x,y좌표가 작은 순으로 먼저 잡아먹으면 된다.
                if (distance + 1 < minDist) {
                  minDist = distance + 1;
                  nextFish = new Node(x,y,arr[x][y]);
                  return;
                }
                // 만약 거리가 같다면?
                else if (distance + 1 == minDist) {
                  // 첫번째로, 가장 위에 있는 물고기, 즉 x값이 가장 작은 물고기를 확인한다.
                  if(x == nextFish.x) {
                    // 만약 같다면, 가장 왼쪽에 있는 물고기, 즉 y값이 가장 작은 물고기를 잡아먹는다.
                    if(y < nextFish.y) {
                      nextFish = new Node(x, y, arr[x][y]);
                      return;
                    }
                    // 다음 목적지가 그대로란 뜻이므로 그대로 return 한다.
                    return;
                  } else if(x < nextFish.x) {
                    nextFish = new Node(x, y, arr[x][y]);
                  }
                  return;
                }
              }
              // 물고기를 먹을 수 있는 경우지만, 우리가 목표한 물고기는 아닐 경우 그냥 지나간다.
              else {
                queue.offer(new Node(nextX, nextY, arr[nextX][nextY]));
              }
            }
          }
        }
      }
      distance++;
    }
  }

  static class Node {

    int x;
    int y;
    int size;

    Node(int x, int y, int size) {
      this.x = x;
      this.y = y;
      this.size = size;
    }
  }
}