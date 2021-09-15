package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Specific_Shortest_Route {
    static int Vertex, Edge, EsenVer1, EsenVer2;
    static ArrayList<Node>[] list;
    static PriorityQueue<Node> queue;
    static final int INF = Integer.MAX_VALUE;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Vertex = Integer.parseInt(st.nextToken());
        Edge = Integer.parseInt(st.nextToken());
        list = new ArrayList[Vertex];
        for(int i=0; i<Vertex; i++)
            list[i] = new ArrayList<>();
        for(int i=0; i<Edge; i++) {
            st = new StringTokenizer(br.readLine()," ");
            list[i].add(new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1));
        }
        st = new StringTokenizer(br.readLine()," ");
        EsenVer1 = Integer.parseInt(st.nextToken());
        EsenVer2 = Integer.parseInt(st.nextToken());
        // Input ends
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

    static void Solve() {
        queue = new PriorityQueue<>();
        queue.add(new Node(EsenVer1-1, 0));
        Node tempNode;
        int tempDest, tempDistance;
        while(!queue.isEmpty()) {
            tempNode = queue.poll();
            if(distance[tempNode.Destination] < tempNode.Distance)  continue;
            for(int i=0; i<list[tempNode.Destination].size(); i++) {
                tempDest = list[tempNode.Destination].get(i).Destination;
                tempDistance = list[tempNode.Destination].get(i).Distance + tempNode.Distance;
                if(distance[tempNode.Destination] > tempDistance) {
                    distance[tempNode.Destination] = tempDistance;
                    queue.offer(new Node(tempDest, tempDistance))
                }
            }
        }

    }
}
