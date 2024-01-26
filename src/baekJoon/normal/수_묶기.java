package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 수_묶기 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });
    for(int i=0; i<n; i++) {
      pq.offer(Integer.parseInt(br.readLine()));
    }

    int sum = 0;
    while(!pq.isEmpty()) {
      Integer poll = pq.poll();
      if(!pq.isEmpty()) {
        if(poll > 0 && poll != 1) {
          // 1아닌 양수의 경우 무조건 곱해서 더하는게 이득임.
          // 그런데 그 전에, 바로 다음 수가 1이나 0이 아닌지 확인해야함.
          if(pq.peek() != 0 && pq.peek() != 1 && pq.peek() > 0) sum += poll * pq.poll();
          else sum += poll;
        } else if(poll == 1) {
          // 1일 경우 곱하지 않고 그냥 더하는게 이득임.
          sum++;
        } else if(poll == 0) {
          // 0일 경우는 조금 생각을 해야함.
          // peek을 제외한 큐에 남은 수들은 다 음수라는 뜻이다.
          // 이 남은 음수의 수가 홀수라면
          if(pq.size() % 2 == 1) {
            // 0과 바로 다음의 수를 곱해서 0으로 만든 뒤, 남은 음수들은 서로 곱해서 양수로 바꾼다.
            pq.poll();
          }
          // 남은 음수의 수가 짝수라면 아무것도 하지 않고, 그냥 넘어간다.
        } else {
          // 0을 거치지 않고 바로 음수가 나온다면
          // 남은 수가 홀수일 경우, 그냥 곱해서 다 더하면 된다.
          if(pq.size() % 2 == 1) {
            sum += poll * pq.poll();
          } else{
            // 남은 수가 짝수일 경우, 자신(남아있는 수 중에 가장 피해를 적게 줄 수 있는 음수)을 그냥 합에 더하고 넘어간다.
            sum += poll;
          }
        }
      } else {
        sum += poll;
      }
    }
    System.out.println(sum);
  }
}
