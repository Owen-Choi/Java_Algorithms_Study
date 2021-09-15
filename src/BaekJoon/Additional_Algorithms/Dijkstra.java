package BaekJoon.Additional_Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra {
    static int VertexNum, EdgeNum, StartVer;
    static ArrayList<Node>[] list;
    static int[] distance;
    static PriorityQueue<Node> queue;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        VertexNum = Integer.parseInt(st.nextToken());
        list = new ArrayList[VertexNum];
        EdgeNum = Integer.parseInt(st.nextToken());
        StartVer = Integer.parseInt(br.readLine());
        distance = new int[VertexNum];
        // Arraylist initialization ::
        for(int i=0; i<VertexNum; i++)
            list[i] = new ArrayList<>();

        int tempStart, tempFinish;
        for(int i=0; i<EdgeNum; i++) {
            st = new StringTokenizer(br.readLine()," ");
            tempStart = Integer.parseInt(st.nextToken());
            tempFinish = Integer.parseInt(st.nextToken());
            list[tempStart - 1].add(new Node(tempFinish - 1, Integer.parseInt(st.nextToken())));
        }
        //Input ends
        Arrays.fill(distance, INF);
        distance[StartVer-1] = 0;
        Solve();
        for(int i=0; i< distance.length; i++) {
            if(distance[i] == INF)
                System.out.println("INF");
            else
                System.out.println(distance[i]);
        }
    }
    static class Node implements Comparable<Node> {
        int Finish, Distance;
        public Node(int F, int D){
            Finish = F;
            Distance = D;
        }

        @Override
        public int compareTo(Node o) {
            return this.Distance - o.Distance;
        }
    }
    static void Solve() {
        queue = new PriorityQueue<Node>();
        queue.offer(new Node(StartVer - 1, 0));
        Node tempNode;
        int tempDist, tempFinish;
        while(!queue.isEmpty()) {
            tempNode = queue.poll();
            // 이 distance는 StartVer 기준이다. 즉 StartVer에서 i 까지의 거리를 distance[i]로 나타낸다.
            if(distance[tempNode.Finish] < tempNode.Distance) continue;
            // 현재 poll한 node와 연결된 list를 모두 탐색       //priority queue를 사용하기 때문에 선형탐색 다익스트라가 아니다.
            for(int i=0; i<list[tempNode.Finish].size(); i++) {
                tempFinish = list[tempNode.Finish].get(i).Finish;
                tempDist = list[tempNode.Finish].get(i).Distance + tempNode.Distance;
                if(distance[tempFinish] > tempDist) {
                    distance[tempFinish] = tempDist;
                    queue.offer(new Node(tempFinish, tempDist));
                }
            }
        }
    }
}
