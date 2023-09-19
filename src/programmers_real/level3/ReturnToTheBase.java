package programmers_real.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ReturnToTheBase {
    public static void main(String[] args) {
        int n = 5;
        int[][] roads = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        int[] sources = {1, 3, 5};
        int dest = 5;
        int[] solution = new ReturnToTheBaseSolution().solution(n, roads, sources, dest);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}

class ReturnToTheBaseSolution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[destination - 1] = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < roads.length; i++) {
            list[roads[i][0] - 1].add(roads[i][1] - 1);
            list[roads[i][1] - 1].add(roads[i][0] - 1);
        }
        // 다익스트라
        queue.offer(destination - 1);
        while (!queue.isEmpty()) {
            // 현재 노드를 꺼내고, 해당 노드와 연결된 다른 노드를 순회하며 최단거리 업데이트 해주기
            Integer poll = queue.poll();
            for (int k = 0; k < list[poll].size(); k++) {
                int tempDest = list[poll].get(k);
                int tempDist = dist[poll] + 1;
                if (tempDist < dist[tempDest]) {
                    dist[tempDest] = tempDist;
                    queue.offer(tempDest);
                }
            }
        }
        for(int i=0; i<sources.length; i++) {
            answer[i] = dist[sources[i] - 1] != INF ? dist[sources[i] - 1] : -1;
        }
        return answer;
    }
}