package baekJoon;

import java.io.*;
import java.util.*;

// 9370번 ::
public class Unidentified_Destination {
    static int testCase, Vertex, Edge, Target, Start, Passed1, Passed2;
    static ArrayList<Node>[] list;
    static int[] distArr;
    static int[] Candidate;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int Current, Destination, Weight;
        while(testCase --> 0) {
            st = new StringTokenizer(br.readLine()," ");
            Vertex = Integer.parseInt(st.nextToken());
            Edge = Integer.parseInt(st.nextToken());
            Target = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            Start = Integer.parseInt(st.nextToken());
            Passed1 = Integer.parseInt(st.nextToken());
            Passed2 = Integer.parseInt(st.nextToken());
            list = new ArrayList[Vertex + 1];
            Candidate = new int[Target];
            distArr = new int[Vertex + 1];
            for(int k=0; k<=Vertex; k++)
                list[k] = new ArrayList<>();
            for(int i = 0; i<Edge; i++) {
                st = new StringTokenizer(br.readLine()," ");
                Current = Integer.parseInt(st.nextToken());
                Destination = Integer.parseInt(st.nextToken());
                Weight = Integer.parseInt(st.nextToken());
                list[Current].add(new Node(Destination, Weight * 2));
                list[Destination].add(new Node(Current, Weight * 2));
            }
            for(int i=0; i<Target; i++) {
                Candidate[i] = Integer.parseInt(br.readLine());
            }
            for(int i=0; i<list[Passed1].size(); i++) {
                if(list[Passed1].get(i).Dest == Passed2) {
                    list[Passed1].get(i).Weight--;
                    break;
                }
            }
            for(int i=0; i<list[Passed2].size(); i++) {
                if(list[Passed2].get(i).Dest == Passed1) {
                    list[Passed2].get(i).Weight--;
                    break;
                }
            }
            // Input End ::
            Dijkstra(Start);
            Solve();
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static class Node{
        int Dest, Weight;
        public Node(int d, int w) {
            Dest = d;
            Weight = w;
        }
    }
    static void Dijkstra(int index) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.Weight - o2.Weight;
            }
        });
        Node tempNode;
        int tempDest, tempWeight;
        Arrays.fill(distArr, Integer.MAX_VALUE/2 * 2);
        queue.offer(new Node(index, 0));
        while(!queue.isEmpty()) {
            tempNode = queue.poll();
            if(tempNode.Weight > distArr[tempNode.Dest])
                continue;
            for(int i = 0; i<list[tempNode.Dest].size(); i++) {
                tempDest = list[tempNode.Dest].get(i).Dest;
                tempWeight = list[tempNode.Dest].get(i).Weight + tempNode.Weight;
                if(distArr[tempDest] > tempWeight) {
                    distArr[tempDest] = tempWeight;
                    queue.offer(new Node(tempDest, tempWeight));
                }
            }
        }
    }
    static void Solve() {
        Arrays.sort(Candidate);
        for (int i : Candidate) {
            if(distArr[i] % 2 != 0) {
                sb.append(i).append(' ');
            }
        }
        sb.append('\n');
    }
}
