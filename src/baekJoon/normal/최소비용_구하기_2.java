package baekJoon.normal;

import java.util.*;
import java.io.*;

// TODO 너는 이따 보자.
public class 최소비용_구하기_2 {

    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        long[] dist = new long[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }
        int tempSource, tempDestination, tempValue;
        StringTokenizer st;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            tempSource = Integer.parseInt(st.nextToken()) - 1;
            tempDestination = Integer.parseInt(st.nextToken()) - 1;
            tempValue = Integer.parseInt(st.nextToken());
            list.get(tempSource).add(new Node(tempDestination, tempValue));
        }
        st = new StringTokenizer(br.readLine());
        int targetSource = Integer.parseInt(st.nextToken()) - 1, targetDestination = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(targetSource, 0));
        //dijkstra 시작
        while(!pq.isEmpty()) {
            Node poll = pq.poll();
            if(dist[poll.d] < poll.v)
                continue;
            for(Node next : list.get(poll.d)) {
                long tempDist = poll.v + next.v;
                if(dist[next.d] > tempDist) {
                    dist[next.d] = tempDist;
                    pq.offer(new Node(next.d, tempDist));
                }
            }
        }

        System.out.println(dist[targetDestination]);
    }

    static class Node implements Comparable<Node>{
        int d;
        long v;
        Node(int d, long v) {
            this.d = d;
            this.v = v;
        }
        @Override
        public int compareTo(Node o) {
            return Long.compare(o.v, this.v);
        }
    }
}
