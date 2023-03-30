package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Most_far_node {
    static class Node implements Comparable<Node> {
        int dest;
        int value;
        public Node(int dest, int value) {
            this.dest = dest;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
    public static void main(String[] args) {
        int[][]  input = {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}};
        System.out.println(solution(6, input));
    }

    static final int INF = Integer.MAX_VALUE;
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        for(int i=0; i<n; i++)
            list.add(new ArrayList<>());
        for(int i=0; i< edge.length; i++) {
            list.get(edge[i][0] - 1).add(new Node(edge[i][1] - 1, 1));
            list.get(edge[i][1] - 1).add(new Node(edge[i][0] - 1, 1));
        }
        dist[0] = 0;
        // dijkstra 시작
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0, 0));
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            for(int i=0; i<list.get(poll.dest).size(); i++) {
                Node node = list.get(poll.dest).get(i);
                int destination = node.dest;
                int distValue = node.value + poll.value;
                if(dist[destination] > distValue) {
                    dist[destination] = distValue;
                    queue.offer(new Node(destination, distValue));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            max = Math.max(max, dist[i]);
        }
        for(int i=0; i<n; i++) {
            if(dist[i] == max)
                answer++;
        }
        return answer;
    }
}
