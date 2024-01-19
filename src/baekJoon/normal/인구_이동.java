package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 인구_이동 {

  static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
  // BFS 과정에서 방문했냐 안했냐를 나타내기 위한 변수
  static boolean[][] visit;

  static int result = 0;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n,l,r;
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    l = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    // BFS에 사용될 큐.
    Queue<Node> queue = new LinkedList<>();
    // BFS가 한번 끝난 뒤 연합으로 묶인 나라들을 저장해뒀다가 값을 바꿔주기 위함.
    Queue<Node> unions = new LinkedList<>();
    // l이상 r이하
    // DFS? BFS?로 일단 국경을 열 곳을 모두 파악한 뒤, 연합을 만들어 인구를 업데이트한다.
    // 일단 국경을 열 나라를 BFS로 찾고, 찾음과 동시에 합을 더해둔다.
    // 더 이상 국경을 열 수 있는 나라가 없으면, 카운트값과 합을 이용해 평균값을 구한다.
    // 이후 BFS 반복, 국경이 열리지 않을 때까지 반복한다.
    int[][] arr = new int[n][n];
    visit = new boolean[n][n];
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int k=0; k<n; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
      }
    }

    boolean isUpdate = true;
    while(isUpdate) {
      isUpdate = false;
      int count = 0, sum = 0, startX = 0, startY = 0;
      for(int i=0; i<n; i++) {
        for(int k=0; k<n; k++) {
          if(!visit[i][k]) {
            // 여기서 BFS 돌리기
            startX = i;
            startY = k;
            visit[i][k] = true;
            queue.offer(new Node(i,k));
            while(!queue.isEmpty()) {
              Node poll = queue.poll();
              for(int j=0; j<4; j++) {
                int nextX = poll.x + move[0][j];
                int nextY = poll.y + move[1][j];
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                  continue;
                }
                int gap = Math.abs(arr[poll.x][poll.y] - arr[nextX][nextY]);
                if(!visit[nextX][nextY] && gap >= l && gap <= r) {
                  // 가장 처음 노드는 어떡하지?
                  // 처음 인덱스를 저장해뒀다가, unions의 크기가 1 이상이라면 큐에 마지막에 넣어주면 되겠다.
                  Node next = new Node(nextX, nextY);
                  unions.offer(next);
                  visit[nextX][nextY] = true;
                  queue.offer(next);
                  count++;
                  sum += arr[nextX][nextY];
                }
              }
            }
            // BFS 끝
            // unions의 크기를 보고, 1 이상이라면 시작 지점의 좌표와 값, 카운트를 모두 더해주고 인구를 업데이트한다.
            if(!unions.isEmpty()) {
              isUpdate = true;
              count++;
              sum += arr[startX][startY];
              unions.add(new Node(startX, startY));
              int population = sum / count;
              while(!unions.isEmpty()) {
                Node poll = unions.poll();
                arr[poll.x][poll.y] = population;
              }
            }
            // 이렇게가 한사이클.
            count = sum = 0;
          }
        }
      }
      if(!isUpdate)
        break;
      // 반드시 BFS가 모두 끝난 후 인구 업데이트를 시작해야함. 안그럼 꼬인다.
      // 그런데 이러면 연합이 2개 이상 생기면 곤란해짐. 그래서 그냥 BFS 돌면서 큐에 노드 넣어두고,
      // BFS 끝나면 큐에서 하나씩 빼면서 업데이트 해주는 걸로 하겠음.
      // 방문 체크 배열들 모두 초기화
      for(int i=0; i<n; i++) {
        Arrays.fill(visit[i], false);
      }
      result++;
    }
    System.out.println(result);
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
