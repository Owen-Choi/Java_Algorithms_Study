package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.lang.Comparable;

public class Specific_Shortest_Route {
    static int Vertex, Edge, EsenVer1, EsenVer2;
    static ArrayList<Node>[] list;
    static final int INF = 200000000;
    static int[] distance;
    static boolean[] flag;
    static PriorityQueue<Node> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Vertex = Integer.parseInt(st.nextToken());
        Edge = Integer.parseInt(st.nextToken());
        distance = new int[Vertex + 1];
        list = new ArrayList[Vertex + 1];
        flag = new boolean[Vertex + 1];
        for(int i=0; i<=Vertex; i++)
            list[i] = new ArrayList<>();
        int tempDest, tempDist, tempStart;
        for(int i=0; i<Edge; i++) {
            st = new StringTokenizer(br.readLine()," ");
            tempStart = Integer.parseInt(st.nextToken());
            tempDest = Integer.parseInt(st.nextToken());
            tempDist = Integer.parseInt(st.nextToken());
            list[tempStart].add(new Node(tempDest, tempDist));
            list[tempDest].add(new Node(tempStart, tempDist));
        }
        st = new StringTokenizer(br.readLine()," ");
        EsenVer1 = Integer.parseInt(st.nextToken());
        EsenVer2 = Integer.parseInt(st.nextToken());
        // Input end
        Solve();
    }
    // Priority queue requires Comparable interface "" not Comparator interface
    static class Node implements Comparable<Node>{
        int Destination, Distance;
        public Node(int dest, int dist) {
            Destination = dest;
            Distance = dist;
        }
        @Override
        public int compareTo(Node o) {
            return this.Distance - o.Distance;
        }
    }
    static int Dijkstra(int StartIndex, int FinishIndex) {
        Arrays.fill(distance, INF);
        Arrays.fill(flag, false);
        queue = new PriorityQueue<>();
        queue.add(new Node(StartIndex, 0));
        Node tempNode;
        int tempDest, tempDist;
        distance[StartIndex] = 0;
        while(!queue.isEmpty()) {
            tempNode = queue.poll();
            if(flag[tempNode.Destination]) continue;
            flag[tempNode.Destination] = true;
            for(int i=0; i<list[tempNode.Destination].size(); i++) {
                tempDest = list[tempNode.Destination].get(i).Destination;
                tempDist = list[tempNode.Destination].get(i).Distance + tempNode.Distance;
                if(!flag[tempDest] && distance[tempDest] > tempDist) {
                    distance[tempDest] = tempDist;
                    queue.add(new Node(tempDest, tempDist));
                }
            }
        }
        return distance[FinishIndex];
    }
    static void Solve() {
        int value1 = 0;
        value1 += Dijkstra(1, EsenVer1);
        value1 += Dijkstra(EsenVer1, EsenVer2);
        value1 += Dijkstra(EsenVer2, Vertex);

        int value2 = 0;
        value2 += Dijkstra(1, EsenVer2);
        value2 += Dijkstra(EsenVer2, EsenVer1);
        value2 += Dijkstra(EsenVer1, Vertex);
        int result;

        result = (value1 >= INF && value2 >= INF) ? -1 : Math.min(value1, value2);
        System.out.println(result);
    }
}
