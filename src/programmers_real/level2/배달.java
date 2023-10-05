package programmers_real.level2;

import java.util.*;
public class 배달 {
    public static void main(String[] args) {
        int n = 5, k = 3;
        int[][] road = {{1,2,1}, {2,3,3}, {5,2,2}, {1,4,2}, {5,3,1}, {5,4,2}};
        System.out.println(new DeliverySolution().solution(n, road, k));
    }
}

class DeliverySolution{
    public int solution(int N, int[][] road, int K) {
        int answer = 0, INF = Integer.MAX_VALUE;
        int[] dist = new int[N];
        ArrayList<Node>[] list = new ArrayList[N];
        for(int i=0; i<N; i++) {
            list[i] = new ArrayList<>();
            dist[i] = INF;
        }
        dist[0] = 0;
        for(int i=0; i<road.length; i++) {
            int source = road[i][0] - 1;
            int dest = road[i][1] - 1;
            int value = road[i][2];
            // 양방향으로 연결해준다.
            list[source].add(new Node(dest, value));
            list[dest].add(new Node(source, value));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0, 0));
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            for(int i=0; i<list[poll.dest].size(); i++) {
                int tempDest = list[poll.dest].get(i).dest;
                int tempDist = list[poll.dest].get(i).value + poll.value;
                if(tempDist < dist[tempDest]) {
                    dist[tempDest] = tempDist;
                    queue.offer(new Node(tempDest, dist[tempDest]));
                }
            }
        }
        for(int i=0; i<N; i++) {
            if(dist[i] <= K) answer++;
        }
        return answer;
    }

    class Node implements Comparable<Node>{
        int dest;
        int value;

        public Node(int d, int v) {
            this.dest = d;
            this.value = v;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
