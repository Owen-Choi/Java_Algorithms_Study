package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 물병 {
  public static void main(String[] args) throws IOException {
    int n, k;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
      @Override
      public int compare(Long o1, Long o2) {
        return o1.compareTo(o2);
      }
    });

    for(int i=0; i<n; i++) {
      pq.offer(1L);
    }

    int storeCount = 0;
    while(true) {
      Long poll = pq.poll();
      System.out.println(poll);
      if(pq.isEmpty()) break;
      if(poll.equals(pq.peek())) {
        pq.poll();
        pq.offer(poll * 2);
      } else {
        storeCount += pq.peek() - poll;
        pq.offer(poll * 2);
      }
    }
    System.out.println(storeCount);
  }
}
