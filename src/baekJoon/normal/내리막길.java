package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 내리막길 {

  static int[][] dp;
  static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
  static int n,m;
  public static void main(String[] args) throws IOException {
    // n과 m을 바꿔서 입력으로 준다. 다시 바꿔서 원래 하던 형태에 맞추자.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

    dp = new int[n][m];
    for(int i=0; i<n; i++) {
      Arrays.fill(dp[i], -1);
    }

    System.out.println(recur(0,0, arr));
  }

  static int recur(int x, int y, int[][] arr) {

    // 3. 끝 지점에 다다르면 1을 반환해서 더할 수 있도록 해준다.
    if(x == n-1 && y == m-1) {
      return 1;
    }

    // 2. 이미 dp 값이 채워진 상황이라면 바로 반환한다.
    if(dp[x][y] != -1) {
      // 왜 -1로 초기화하지?
      // flag로 사용하려는 의도인 것 같다! 한번이라도 방문한 배열은 0인 것에 반해, 한번도 방문하지 않은 배열은 -1이 된다.
      return dp[x][y];
    }

    dp[x][y] = 0;
    for(int i=0; i<4; i++) {
      int nextX = x + move[0][i];
      int nextY = y + move[1][i];
      if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
        continue;
      }

      if(arr[x][y] > arr[nextX][nextY]) {
        // 1. 내리막길이면 현재 dp 값에 재귀의 반환값을 더한다.
        dp[x][y] += recur(nextX, nextY, arr);
      }
    }
    return dp[x][y];
  }


}
