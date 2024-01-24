package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 카드_합체_놀이 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n, m;
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    PriorityQueue<Long> queue = new PriorityQueue<>(new Comparator<Long>() {
      @Override
      public int compare(Long o1, Long o2) {
        return o1.compareTo(o2);
      }
    });
    for(int i=0; i<n; i++) {
      queue.offer(Long.parseLong(st.nextToken()));
    }
    while(m --> 0) {
      Long  poll1 = queue.poll();
      Long poll2 = queue.poll();
      queue.offer(poll1 + poll2);
      queue.offer(poll1 + poll2);
    }
    long sum = 0;
    for (Long element : queue) {
      sum += element;
    }
    System.out.println(sum);
  }

}
