package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 강의실_배정 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
      @Override
      public int compare(Node o1, Node o2) {
        if(o1.start.compareTo(o2.start) == 0) {
          return o1.end.compareTo(o2.end);
        } return o1.start.compareTo(o2.start);
      }
    });
    PriorityQueue<Node> currentClass = new PriorityQueue<>();
    StringTokenizer st;
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      Node input = new Node(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
      pq.offer(input);
    }
    // 끝나는 시간이 이른 순, 끝나는 시간이 같다면 시작하는 시간이 이른 순으로 정렬이 되어있다.
    // 즉, 꺼내면서 다음 노드의 시작 시간을 보고 수업이 가능한지 가능하지 않은지로 판단하면 된다.
    currentClass.offer(pq.poll());
    while(!pq.isEmpty()) {
      Node node = pq.poll();
      // 지금 있는 강의실 중에 강의가 가능한 방이 있는지 확인
      Node peek = currentClass.peek();
      if(peek.end <= node.start) {
        currentClass.poll();
        currentClass.offer(node);
      } else {
        currentClass.offer(node);
      }
//      if(!flag) {
//        currentClass.offer(node);
//      }

    }
    System.out.println(currentClass.size());
  }

  static class Node implements Comparable<Node>{
    Long start;
    Long end;
    Node(Long start, Long end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Node o) {
      // 틀린 이유 : 원본 데이터를 담고 있는 큐와 현재 강의 중인 배열을 담고 있는 큐의 정렬 기준이 상반되는데,
      // 이 기준 하나로 통일해서 사용하고 있었기 때문에 틀림.
      // 따라서 이 정렬 기준은 현재 사용 중인 강의실을 나타내는 우선순위 큐에서 사용하도록 하고,
      // 원본 데이터를 담을 우선순위 큐는 새로 정렬기준을 만들어주도록 하겠다.
      if(this.end.compareTo(o.end) == 0) {
        return this.start.compareTo(o.start);
      }
      return this.end.compareTo(o.end);
    }
  }
}
