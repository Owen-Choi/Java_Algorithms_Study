package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 로봇_청소기 {
  static int n, m, robotX, robotY, robotDirection;
  static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
  public static void main(String[] args) throws IOException{
    // 방향만 잘 신경쓰면 어렵지 않게 풀 수 있을 것 같은데?
    // BFS? 는 안써도 될 것 같다. 배열만 써도 될 것 같음.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    // 로봇의 초기 설정 입력받음
    robotX = Integer.parseInt(st.nextToken());
    robotY = Integer.parseInt(st.nextToken());
    robotDirection = Integer.parseInt(st.nextToken());

    // 지도 입력받음package baekJoon.normal;
    //
    //import java.util.*;
    //import java.io.*;
    //
    //public class 로봇_청소기 {
    //  static int n, m, robotX, robotY, robotDirection;
    //  static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
    //  public static void main(String[] args) throws IOException{
    //    // 방향만 잘 신경쓰면 어렵지 않게 풀 수 있을 것 같은데?
    //    // BFS? 는 안써도 될 것 같다. 배열만 써도 될 것 같음.
    //    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //    StringTokenizer st = new StringTokenizer(br.readLine());
    //    n = Integer.parseInt(st.nextToken());
    //    m = Integer.parseInt(st.nextToken());
    //    st = new StringTokenizer(br.readLine());
    //    // 로봇의 초기 설정 입력받음
    //    robotX = Integer.parseInt(st.nextToken());
    //    robotY = Integer.parseInt(st.nextToken());
    //    robotDirection = Integer.parseInt(st.nextToken());
    //
    //    // 지도 입력받음
    //    int[][] arr = new int[n][m];
    //    boolean[][] flag = new boolean[n][m];
    //    for(int i=0; i<n; i++) {
    //      st = new StringTokenizer(br.readLine());
    //      for(int k=0; k<m; k++) {
    //        arr[i][k] = Integer.parseInt(st.nextToken());
    //      }
    //    }
    //
    //    int result = 0;
    //    while(true) {
    //      // 빈칸 청소
    //      if(!flag[robotX][robotY]) {
    //        flag[robotX][robotY] = true;
    //        result++;
    //      }
    //      // 청소 후 주변 확인
    //      if(check4D(arr, flag)) {
    //        // 주변에 청소되지 않은 빈칸이 있는 경우
    //        // 반시계 방향으로 90도 회전한다.
    //        if(--robotDirection < 0)
    //          robotDirection = 3;
    //        // 회전 후 전방이 청소되지 않은 빈칸일 경우 전진한다.
    //        moveForward(arr, flag);
    //      } else {
    //        // 주변이 모두 청소된 경우
    //        // 후진한다.
    //        if(!moveBack(arr)) {
    //          // 후진에 실패했다면 동작을 멈춘다.
    //          break;
    //        }
    //      }
    //
    //    }
    //    System.out.println(result);
    //  }
    //
    //
    //  static boolean check4D(int[][] arr, boolean[][] flag) {
    //    // 주변 4칸을 확인한다.
    //    for(int i=0; i<4; i++) {
    //      int nextX = robotX + move[0][i];
    //      int nextY = robotY + move[1][i];
    //      if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m)
    //        continue;
    //      // 벽이 아니면서 청소되지 않은 곳이 주변에 하나라도 있다면 true 반환
    //      if(arr[nextX][nextY] != 1 && !flag[nextX][nextY])
    //        return true;
    //    }
    //    // 청소하지 않은 빈칸이 없음. 즉, 모두 청소 됨
    //    return false;
    //  }
    //
    //  static boolean moveBack(int[][] arr) {
    //    // 할 수 있다면 현재 방향에서 한칸 후진하고, 할 수 없다면 false를 반환한다.
    //    if(robotDirection == 0) {
    //      // 북쪽 : 남쪽을 향해 후진
    //      if(robotX < n - 1 && arr[robotX + 1][robotY] != 1) {
    //        robotX++;
    //        return true;
    //      }
    //    } else if(robotDirection == 1) {
    //      // 동쪽 : 서쪽을 향해 후진
    //      if(robotY > 0 && arr[robotX][robotY - 1] != 1) {
    //        robotY--;
    //        return true;
    //      }
    //    } else if(robotDirection == 2) {
    //      // 남쪽 : 북쪽을 향해 후진
    //      if(robotX > 0 && arr[robotX - 1][robotY] != 1) {
    //        robotX--;
    //        return true;
    //      }
    //    } else {
    //      // 서쪽 : 동쪽을 향해 후진
    //      if(robotY < m - 1 && arr[robotX][robotY + 1] != 1) {
    //        robotY++;
    //        return true;
    //      }
    //    }
    //
    //    return false;
    //  }
    //
    //  static void moveForward(int[][] arr, boolean[][] flag) {
    //    if(robotDirection == 0) {
    //      // 북쪽을 향해 전진
    //      if(robotX > 0 && arr[robotX - 1][robotY] != 1 && !flag[robotX-1][robotY]) robotX--;
    //    } else if(robotDirection == 1) {
    //      // 동쪽을 향해 전진
    //      if(robotY < m - 1 && arr[robotX][robotY + 1] != 1 && !flag[robotX][robotY + 1]) robotY++;
    //    } else if(robotDirection == 2) {
    //      // 남쪽을 향해 전진
    //      if(robotX < n - 1 && arr[robotX + 1][robotY] != 1 && !flag[robotX + 1][robotY]) robotX++;
    //    } else {
    //      // 서쪽을 향해 전진
    //      if(robotY > 0 && arr[robotX][robotY - 1] != 1 && !flag[robotX][robotY - 1]) robotY--;
    //    }
    //  }
    //}
    int[][] arr = new int[n][m];
    boolean[][] flag = new boolean[n][m];
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int k=0; k<m; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
      }
    }

    int result = 0;
    while(true) {
      // 빈칸 청소
      if(!flag[robotX][robotY]) {
        flag[robotX][robotY] = true;
        result++;
      }
      // 청소 후 주변 확인
      if(check4D(arr, flag)) {
        // 주변에 청소되지 않은 빈칸이 있는 경우
        // 반시계 방향으로 90도 회전한다.
        if(--robotDirection < 0)
          robotDirection = 3;
        // 회전 후 전방이 청소되지 않은 빈칸일 경우 전진한다.
        moveForward(arr, flag);
      } else {
        // 주변이 모두 청소된 경우
        // 후진한다.
        if(!moveBack(arr)) {
          // 후진에 실패했다면 동작을 멈춘다.
          break;
        }
      }

    }
    System.out.println(result);
  }


  static boolean check4D(int[][] arr, boolean[][] flag) {
    // 주변 4칸을 확인한다.
    for(int i=0; i<4; i++) {
      int nextX = robotX + move[0][i];
      int nextY = robotY + move[1][i];
      if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m)
        continue;
      // 벽이 아니면서 청소되지 않은 곳이 주변에 하나라도 있다면 true 반환
      if(arr[nextX][nextY] != 1 && !flag[nextX][nextY])
        return true;
    }
    // 청소하지 않은 빈칸이 없음. 즉, 모두 청소 됨
    return false;
  }

  static boolean moveBack(int[][] arr) {
    // 할 수 있다면 현재 방향에서 한칸 후진하고, 할 수 없다면 false를 반환한다.
    if(robotDirection == 0) {
      // 북쪽 : 남쪽을 향해 후진
      if(robotX < n - 1 && arr[robotX + 1][robotY] != 1) {
        robotX++;
        return true;
      }
    } else if(robotDirection == 1) {
      // 동쪽 : 서쪽을 향해 후진
      if(robotY > 0 && arr[robotX][robotY - 1] != 1) {
        robotY--;
        return true;
      }
    } else if(robotDirection == 2) {
      // 남쪽 : 북쪽을 향해 후진
      if(robotX > 0 && arr[robotX - 1][robotY] != 1) {
        robotX--;
        return true;
      }
    } else {
      // 서쪽 : 동쪽을 향해 후진
      if(robotY < m - 1 && arr[robotX][robotY + 1] != 1) {
        robotY++;
        return true;
      }
    }

    return false;
  }

  static void moveForward(int[][] arr, boolean[][] flag) {
    if(robotDirection == 0) {
      // 북쪽을 향해 전진
      if(robotX > 0 && arr[robotX - 1][robotY] != 1 && !flag[robotX-1][robotY]) robotX--;
    } else if(robotDirection == 1) {
      // 동쪽을 향해 전진
      if(robotY < m - 1 && arr[robotX][robotY + 1] != 1 && !flag[robotX][robotY + 1]) robotY++;
    } else if(robotDirection == 2) {
      // 남쪽을 향해 전진
      if(robotX < n - 1 && arr[robotX + 1][robotY] != 1 && !flag[robotX + 1][robotY]) robotX++;
    } else {
      // 서쪽을 향해 전진
      if(robotY > 0 && arr[robotX][robotY - 1] != 1 && !flag[robotX][robotY - 1]) robotY--;
    }
  }
}
