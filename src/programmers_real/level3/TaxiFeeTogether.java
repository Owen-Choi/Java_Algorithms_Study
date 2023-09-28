package programmers_real.level3;

import java.util.*;
public class TaxiFeeTogether {
    public static void main(String[] args) {
        int n = 6, s = 4, a = 5, b = 6;
//        int [][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        int [][] fares = {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}};
        System.out.println(new TaxiFeeTogetherSolution().solution(n,s,a,b,fares));
    }
}

class TaxiFeeTogetherSolution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        ArrayList<Node>[] list = new ArrayList[n];
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n];
        int[] aDist = new int[n];
        int[] bDist = new int[n];
        boolean[] flag = new boolean[n];
        for(int i=0; i<n; i++) {
            list[i] = new ArrayList<>();
            dist[i] = INF;
            aDist[i] = INF;
            bDist[i] = INF;
        }
        dist[s-1] = 0;
        aDist[a-1] = 0;
        bDist[b-1] = 0;
        for(int i=0; i< fares.length; i++) {
            // 양방향
            list[fares[i][0] - 1].add(new Node(fares[i][1] - 1, fares[i][2]));
            list[fares[i][1] - 1].add(new Node(fares[i][0] - 1, fares[i][2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s-1, 0));
        while(!pq.isEmpty()) {
            Node poll = pq.poll();
            flag[poll.dest] = true;
            for(int i=0; i<list[poll.dest].size(); i++) {
                Node tempNode = list[poll.dest].get(i);
                int tempDist = tempNode.value + poll.value;
                if(!flag[tempNode.dest] && tempDist < dist[tempNode.dest]) {
                    dist[tempNode.dest] = tempDist;
//                    pq.offer(tempNode);
                    pq.offer(new Node(tempNode.dest, tempDist));
                }
            }
        }

        pq = new PriorityQueue<>();
        pq.offer(new Node(a-1, 0));
        Arrays.fill(flag, false);
        while(!pq.isEmpty()) {
            Node poll = pq.poll();
            flag[poll.dest] = true;
            for(int i=0; i<list[poll.dest].size(); i++) {
                Node tempNode = list[poll.dest].get(i);
                int tempDist = tempNode.value + poll.value;
                if(!flag[tempNode.dest] && tempDist < aDist[tempNode.dest]) {
                    aDist[tempNode.dest] = tempDist;
//                    pq.offer(tempNode);
                    pq.offer(new Node(tempNode.dest, tempDist));
                }
            }
        }

        pq = new PriorityQueue<>();
        pq.offer(new Node(b-1, 0));
        Arrays.fill(flag, false);
        while(!pq.isEmpty()) {
            Node poll = pq.poll();
            flag[poll.dest] = true;
            for(int i=0; i<list[poll.dest].size(); i++) {
                Node tempNode = list[poll.dest].get(i);
                int tempDist = tempNode.value + poll.value;
                if(!flag[tempNode.dest] && tempDist < bDist[tempNode.dest]) {
                    bDist[tempNode.dest] = tempDist;
                    // 실수한 부분. tempNode를 바로 넣어버리면 안되고, tempDist를 넣은 새로운 노드를 만들어 넣어야 한다.
//                    pq.offer(tempNode);
                    pq.offer(new Node(tempNode.dest, tempDist));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int tempResult = 0;
        for(int i=0; i<n; i++) {
            tempResult = dist[i] + aDist[i] + bDist[i];
            min = Math.min(min, tempResult);
        }
        return Math.min(min, aDist[s-1] + bDist[s-1]);
    }

    class Node implements Comparable<Node>{
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
}
