package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 야구 {

  static int[][] arr;
  static List<Integer> list = new ArrayList<>();
  static int result = 0, n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n][9];
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int k = 0; k < 9; k++) {
        arr[i][k] = Integer.parseInt(st.nextToken());
      }
    }
    // 이닝 수가 50개면 브루트 포스로 풀 수 있나?
    // 8명의 선수를 전부 순열로 조합 구하는 소요시간?
    // 8! ==> 한번 당 4만번 정도?, 일단 이닝이 50개라면 대충 200만 정도 걸린다.
    // 얻은 조합으로 1차원 반복문을 돌리면?
    boolean[] flag = new boolean[9];
    permutation(0, flag);
    // 각 이닝에서 최적의 결과를 더하면 최종 결과는 최적의 결과가 나온다.
    System.out.println(result);
  }

  static void permutation(int depth, boolean[] flag) {
    if (depth == 9) {
      determine();
      return;
    }

    if (depth == 3) {
      list.add(0);
      permutation(depth + 1, flag);
      list.remove(list.size() - 1);
    } else {
      for (int i = 1; i < 9; i++) {
        if (!flag[i]) {
          flag[i] = true;
          list.add(i);
          permutation(depth + 1, flag);
          list.remove(list.size() - 1);
          flag[i] = false;
        }
      }
    }
  }

  static void determine() {
    // 얻은 순열로 점수 합산
    int outCount = 0, score = 0, iterator = 0;
    boolean[] base = new boolean[3];
    int innings = 0, inningResult = 0;
    while(innings < n) {
      while (outCount < 3) {
        int currentPlayer = arr[innings][list.get(iterator++)];
        iterator = iterator >= 9 ? 0 : iterator;
        if (currentPlayer == 0) {
          outCount++;
        } else if (currentPlayer == 1) {
          if (base[2]) {
            score++;
            base[2] = false;
          }
          if (base[1]) {
            base[1] = false;
            base[2] = true;
          }
          if (base[0]) {
            base[1] = true;
          }
          base[0] = true;
        } else if (currentPlayer == 2) {
          if (base[2]) {
            score++;
            base[2] = false;
          }
          if (base[1]) {
            score++;
            base[1] = false;
          }
          if (base[0]) {
            base[0] = false;
            base[2] = true;
          }
          base[1] = true;
        } else if (currentPlayer == 3) {
          if (base[2]) {
            score++;
            base[2] = false;
          }
          if (base[1]) {
            score++;
            base[1] = false;
          }
          if (base[0]) {
            score++;
            base[0] = false;
          }
          base[2] = true;
        } else {
          // 홈런
          for (int k = 0; k < 3; k++) {
            if (base[k]) {
              base[k] = false;
              score++;
            }
          }
          score++;
        }
      }
      inningResult += score;
      score = outCount = 0;
      base[0] = base[1] = base[2] = false;
      innings++;
    }
    result = Math.max(result, inningResult);
  }

}
