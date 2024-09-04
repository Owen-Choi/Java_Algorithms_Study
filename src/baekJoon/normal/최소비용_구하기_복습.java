package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 최소비용_구하기_복습 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine());
        // 원래는 리스트의 배열로 했었는데, 그렇게 짰을때 통과하지 못했던 문제를 아래와 같이 리스트의 리스트로 구현했을 때는 통과했다.
        // 배열과 리스트의 장단점이 있다.
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        StringTokenizer st;
        int source, destination, value;
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            source = Integer.parseInt(st.nextToken()) - 1;
            destination = Integer.parseInt(st.nextToken()) - 1;
            value = Integer.parseInt(st.nextToken());
            list.get(source).add(new Node(destination, value));
        }

        st = new StringTokenizer(br.readLine());
        int targetSource = Integer.parseInt(st.nextToken()) - 1;
        int targetDestination = Integer.parseInt(st.nextToken()) - 1;

        long[] dist = new long[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(targetSource, 0));

        // dijkstra 시작
        while(!pq.isEmpty()) {
            Node poll = pq.poll();
            // 원래 있던 검증은 안해줘도 될 것 같다. => 해야겠다. 안하니까 시간초과 발생함.
            if(dist[poll.d] < poll.v) {
                continue;
            }
            for(int i=0; i<list.get(poll.d).size(); i++) {
                Node next = list.get(poll.d).get(i);
                long tempDist = poll.v + next.v;
                if(dist[next.d] > tempDist) {
                    dist[next.d] = tempDist;
                    pq.offer(new Node(next.d, tempDist));
                }
            }
        }

        System.out.println(dist[targetDestination]);
    }

    // 우선순위 큐를 구현할 예정이기 때문에 comparable 구현해준다.
    static class Node implements Comparable<Node>{
        int d;
        long v;

        Node(int d, long v) {
            this.d = d;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            // 거리가 짧은 순으로 정렬
            return this.v < o.v ? 1 : 0;
        }
    }
}
