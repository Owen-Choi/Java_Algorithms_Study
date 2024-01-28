package baekJoon.normal;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드_정렬하기 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i=0; i<n; i++) {
      pq.offer(Integer.parseInt(br.readLine()));
    }
    long sum = 0;
    while(!pq.isEmpty()) {
      int poll = pq.poll();
      if(!pq.isEmpty()) {
        int poll2 = pq.poll();
        sum += poll + poll2;
        pq.offer(poll + poll2);
      }
    }
    System.out.println(sum);
  }

}
