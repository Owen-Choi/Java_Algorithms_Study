package baekJoon.normal;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.lang.Comparable;
// 1753번
public class Shortest_Route {
    static ArrayList<Node>[] list;            //list의 배열, 후에 각각의 list에 생성자로 리스트를 생성해줘야함.
    static int[] dist;
    static int Start;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int Vertex = Integer.parseInt(st.nextToken());
        int Edge = Integer.parseInt(st.nextToken());
        Start = Integer.parseInt(br.readLine());
        list = new ArrayList[Vertex];
        dist = new int[Vertex];
        Arrays.fill(dist, INF);
        dist[Start - 1] = 0;
        for(int i=0; i<Vertex; i++){
            list[i] = new ArrayList<>();
        }
        int tempStart; int tempFinish;  int tempValue;
        for(int i=0; i<Edge; i++){
            st = new StringTokenizer(br.readLine()," ");        //재활용 가능한가?
            tempStart = Integer.parseInt(st.nextToken());
            tempFinish = Integer.parseInt(st.nextToken());
            tempValue = Integer.parseInt(st.nextToken());
            list[tempStart-1].add(new Node(tempFinish-1, tempValue));
        }
        dijkstra();
        for(int i=0; i<Vertex; i++){
            if(dist[i] == INF)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }
    private static void dijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>();      //PriorityQueue를 사용하려면 노드를 비교할 수단이 있어야 한다.
        queue.offer(new Node(Start-1, 0));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int vertex = node.vertex;
            int value = node.value;

            if(dist[vertex] < value)
                continue;

                for(int i=0; i<list[vertex].size(); i++){
                    Node tempNode = (Node)list[vertex].get(i);
                    int TempVertex = tempNode.vertex;
                    int TempValue = tempNode.value + value;
                    if(dist[TempVertex] > TempValue) {
                        dist[TempVertex] = TempValue;
                        queue.add(new Node(TempVertex, TempValue));
                    }
                }
            }
        }

    private static class Node implements Comparable<Node>{
        int vertex;
        int value;
        public Node(int Vertex, int Value){
            this.vertex = Vertex;
            this.value = Value;
        }
        @Override
        public int compareTo(Node o){
            return value - o.value;
        }
    }
}


