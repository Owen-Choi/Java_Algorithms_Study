package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 도서관 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n, m;
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    PriorityQueue<Integer> positive = new PriorityQueue<>(new CommonComparator());
    PriorityQueue<Integer> negative = new PriorityQueue<>(new CommonComparator());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int temptaion = Integer.parseInt(st.nextToken());
      if(temptaion < 0) {
        negative.offer(temptaion);
      } else {
        positive.offer(temptaion);
      }
    }
//    7 2
//    -37 2 -6 -39 -29 11 -28
//    6 2
//    3 4 5 6 11 -1

    // null이 들어갈 수도 있다.
//    int maxValue;
//    if(positive.isEmpty()) {
//
//    } else if(negative.isEmpty()) {
//
//    } else {
//      Math.
//    }
  }

  static class CommonComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
      return Math.abs(o2) - Math.abs(o1);
    }
  }
}
