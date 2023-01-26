package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 1260번
public class DFS_And_BFS {
    static int Vertex;
    static int Edge;
    static int StartVer;
    static ArrayList<Integer>[] list;
    static Queue<Integer> queue;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Vertex = Integer.parseInt(st.nextToken());
        Edge = Integer.parseInt(st.nextToken());
        StartVer = Integer.parseInt(st.nextToken());
        list = new ArrayList[Vertex + 1];
        for(int i=1; i<=Vertex; i++)
            list[i] = new ArrayList<>();
        for(int i=0; i<Edge; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int tempVertex = Integer.parseInt(st.nextToken());
            int tempDes = Integer.parseInt(st.nextToken());
            list[tempVertex].add(tempDes);
            list[tempDes].add(tempVertex);
        }
        queue = new LinkedList<>();
        queue.offer(StartVer);
        DFS(StartVer);
        for(int temp : queue){
            System.out.print(temp + " ");
        }
        System.out.println();
        BFS(StartVer);
        System.out.println(sb);
    }
    static void DFS(int vertex){

        list[vertex].sort(Comparator.naturalOrder());
        for(int i=0; i<list[vertex].size(); i++){
            if(!queue.contains(list[vertex].get(i))) {
                queue.add(list[vertex].get(i));
                DFS(list[vertex].get(i));
            }
        }
    }
    static void BFS(int vertex){
        Queue<Integer> Q = new LinkedList<>();
        boolean[] ForCheck = new boolean[Vertex + 1];
        ForCheck[vertex] = true;
        Q.offer(vertex);
        while(!Q.isEmpty()){
            int tempVal = Q.poll();
            sb.append(tempVal); sb.append(" ");
            for(int i=0; i<list[tempVal].size(); i++){
                if(!ForCheck[list[tempVal].get(i)]) {
                    ForCheck[list[tempVal].get(i)] = true;
                    Q.offer(list[tempVal].get(i));
                }
            }
        }
        sb.append("\n");
    }

}
