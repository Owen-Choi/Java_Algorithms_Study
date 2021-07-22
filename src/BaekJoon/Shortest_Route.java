package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1753번
public class Shortest_Route {
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;
    static int Start;
    static ArrayList[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        list = new ArrayList[V+1];
        dist = new int[V];
        Start = Integer.parseInt(br.readLine());
        Arrays.fill(dist, INF);
        dist[Start] = 0;
        int SP,FP,W;
        for(int i=1; i<=V; i++)
            list[i] = new ArrayList<>();
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            SP = Integer.parseInt(st.nextToken());
            FP = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            list[SP].add(new Node(FP,W));
        }
        dijkstra();
        for(int i=0; i<V; i++){
            if(dist[i] == INF)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }
    private static void dijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>();  // Default : 숫자가 낮은 순으로 우선순위 부여
        queue.offer(new Node(Start, 0));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int Vertex = node.vertex;
            int Weight = node.weight;
            if(dist[Vertex] < Weight)
                continue;
            else{
                for(int i=0; i<list[Vertex].size(); i++){
                    Node TempNode = (Node)list[Vertex].get(i);
                    int TempVertex = TempNode.vertex;
                    int TempWeight = TempNode.weight + Weight;
                    if(dist[Vertex] > TempWeight) {
                        dist[Vertex] = TempWeight;
                        queue.add(new Node(TempVertex, TempWeight));
                    }
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o){
            return weight - o.weight;
        }
    }
}
