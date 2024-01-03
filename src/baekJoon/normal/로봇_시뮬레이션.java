package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 로봇_시뮬레이션 {

  static int[][] flag;
  static int a, b, n, m;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    flag = new int[b+1][a+1];
    Robot[] arr = new Robot[n];
    // 로봇 초기화
    int col, row, dir;
    char tempDir;
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      col = Integer.parseInt(st.nextToken());   // 5
      row = Integer.parseInt(st.nextToken());   // 4
      tempDir = st.nextToken().charAt(0);
      dir = tempDir == 'N' ? 0 : tempDir == 'E' ? 1 : tempDir == 'S' ? 2 : 3;
      arr[i] = new Robot(col, row, dir);
      flag[row][col] = i+1;
    }

    int robotIndex, value, nextDir;
    char command;
    for(int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      robotIndex = Integer.parseInt(st.nextToken()) - 1;
      command = st.nextToken().charAt(0);
      value = Integer.parseInt(st.nextToken());
      // 방향 설정
//      arr[robotIndex].direction = command;
      if(command == 'F') {
        if(!check(arr[robotIndex].direction, value, robotIndex, arr[robotIndex]))
          return;
      } else {
        // 방향 조정
        value %= 4;
        // 아래 코드가 이상하다.
        nextDir = command == 'R' ? arr[robotIndex].direction + value : arr[robotIndex].direction - value;
        if(nextDir < 0) nextDir =+ 4;
        else if(nextDir >= 4) nextDir -= 4;
        arr[robotIndex].direction = nextDir;
      }
    }

    System.out.println("OK");
  }

  // 이동경로를 확인하고 문제가 있다면 바로 리턴해버린다.
  static boolean check(int direction, int value, int myIndex, Robot robot) {
    // 각각의 방향에서 먼저 벽과 부딪히지는 않는지, 부딪히지 않는다면 다른 로봇이 이미 존재하지는 않는지 판단해야 한다.
    int moveRow = 0, moveCol = 0;
    if(direction == 3) {
      moveRow = robot.row;
      moveCol = robot.col;
      for(int i=1; i<=value; i++) {
        moveCol--;
        if(moveCol <= 0) {
          System.out.println("Robot " + (myIndex+1) + " crashes into the wall");
          return false;
        }
        if(flag[moveRow][moveCol] != 0) {
          System.out.println("Robot " + (myIndex+1) + " crashes into robot " + flag[moveRow][moveCol]);
          return false;
        }
      }
    } else if(direction == 1) {
      // 치명적인 문제점 : 지금은 벽에 부딪히는 여부를 먼저 본다. 그게 아니라 로봇을 먼저 봐야한다.
      moveRow = robot.row;
      moveCol = robot.col;
      for(int i=1; i<=value; i++) {
        moveCol++;
        if(moveCol > a) {
          System.out.println("Robot " + (myIndex+1) + " crashes into the wall");
          return false;
        }
        if(flag[moveRow][moveCol] != 0) {
          System.out.println("Robot " + (myIndex+1) + " crashes into robot " + flag[moveRow][moveCol]);
          return false;
        }
      }
    } else if(direction == 0) {
      moveCol = robot.col;
      moveRow = robot.row;
      for(int i=1; i<=value; i++) {
        moveRow++;
        if(moveRow > b) {
          System.out.println("Robot " + (myIndex+1) + " crashes into the wall");
          return false;
        }
        if(flag[moveRow][moveCol] != 0) {
          System.out.println("Robot " + (myIndex+1) + " crashes into robot " + flag[moveRow][moveCol]);
          return false;
        }
      }
    } else {
      moveCol = robot.col;
      moveRow = robot.row;
      for(int i=1; i<=value; i++) {
        moveRow--;
        if(moveRow <= 0) {
          System.out.println("Robot " + (myIndex+1) + " crashes into the wall");
          return false;
        }
        if(flag[moveRow][moveCol] != 0) {
          System.out.println("Robot " + (myIndex+1) + " crashes into robot " + flag[moveRow][moveCol]);
          return false;
        }
      }
    }
    flag[robot.row][robot.col] = 0;
    flag[moveRow][moveCol] = myIndex+1;
    robot.row = moveRow;
    robot.col = moveCol;
    return true;
  }
  static class Robot {
    int col;
    int row;
    int direction;

    Robot(int col, int row, int direction) {
      this.col = col;
      this.row = row;
      this.direction = direction;
    }
  }
}
