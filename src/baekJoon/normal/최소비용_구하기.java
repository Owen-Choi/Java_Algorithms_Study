package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 최소비용_구하기 {
    public static void main(String[] args) throws IOException {
        // 음? 그냥 다익스트라 아닌가?
        // 출발지가 정해진 명백한 다익스트라
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        long[] dist = new long[n];
        ArrayList<ArrayList<Node>> lists = new ArrayList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            lists.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s,t,v;
            s = Integer.parseInt(st.nextToken()) - 1;
            t = Integer.parseInt(st.nextToken()) - 1;
            v = Integer.parseInt(st.nextToken());
            lists.get(s).add(new Node(t,v));
        }
        int start, target;
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()) - 1;
        target = Integer.parseInt(st.nextToken()) - 1;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(start, 0));

        // dijkstra 시작
        while(!pq.isEmpty()) {
            Node poll = pq.poll();
            if(dist[poll.destination] < poll.value) {
                continue;
            }
            for(Node next : lists.get(poll.destination)) {
                long tempDist = next.value + poll.value;
                if(dist[next.destination] > tempDist) {
                    dist[next.destination] = tempDist;
                    pq.offer(new Node(next.destination, tempDist));
                }
            }
        }
        System.out.println(dist[target]);
    }

    static class Node implements Comparable<Node>{
        int destination;
        long value;
        Node(int destination, long value) {
            this.destination = destination;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value < o.value ? 1 : 0;
        }
    }
}
