package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 배열_돌리기_4 {

  static int[][] arr;
  static int[][] rotate;
  static int result = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    int n,m,k;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    arr = new int[n][m];
    rotate = new int[k][3];
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for(int i=0; i<k; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<3; j++) {
        rotate[i][j] = Integer.parseInt(st.nextToken()) - 1;
      }
      rotate[i][2]++;
    }

    permutation(0, k, new boolean[k], new ArrayList<>());
    System.out.println(result);
  }

  static void permutation(int depth, int size, boolean[] flag, List<Integer> list) {
    if(depth == size) {
      rotateAndCalculate(list);
      return;
    }

    for(int i=0; i<size; i++) {
      if(!flag[i]) {
        flag[i] = true;
        list.add(i);
        permutation(depth+1, size, flag, list);
        list.remove(list.size() - 1);
        flag[i] = false;
      }
    }
  }

  static void rotateAndCalculate(List<Integer> list) {
    int[][] tmp = new int[arr.length][arr[0].length];
    for(int i=0; i<arr.length; i++) {
      tmp[i] = arr[i].clone();
    }

    for(int i=0; i<list.size(); i++) {
      int r = rotate[list.get(i)][0];
      int c = rotate[list.get(i)][1];
      int S = rotate[list.get(i)][2];

      for(int s=1; s<=S; s++) {
        //위
        int upTmp = tmp[r-s][c+s];
        for(int y = c+s; y > c-s; y--) {
          tmp[r-s][y] = tmp[r-s][y-1];
        }
        //오른쪽
        int rightTmp = tmp[r+s][c+s];
        for(int x = r+s; x > r-s; x--) {
          tmp[x][c+s] = tmp[x-1][c+s];
        }
        tmp[r-s+1][c+s] = upTmp;
        //아래
        int leftTmp = tmp[r+s][c-s];
        for(int y = c-s; y < c+s; y++) {
          tmp[r+s][y] = tmp[r+s][y+1];
        }
        tmp[r+s][c+s-1] = rightTmp;
        //왼쪽
        for(int x = r-s; x < r+s; x++) {
          tmp[x][c-s] = tmp[x+1][c-s];
        }
        tmp[r+s-1][c-s] = leftTmp;
      }
    }

    // 회전은 완료했고, 연산만 수행하면 된다.
    int tempResult = Integer.MAX_VALUE;
    for(int i=0; i<tmp.length; i++) {
      int sum = 0;
      for(int j=0; j<tmp[0].length; j++) {
        sum += tmp[i][j];
      }
      tempResult = Math.min(tempResult, sum);
    }
    result = Math.min(result, tempResult);
  }
}
