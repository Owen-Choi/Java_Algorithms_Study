package BaekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
// 9370번 ::
public class Unidentified_Destination {
    static int testCase, Vertex, Edge, Target, Start, Passed1, Passed2;
    static ArrayList<Node>[] list;
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
            for(int k=0; k<=Vertex; k++)
                list[k] = new ArrayList<>();
            for(int i = 0; i<Edge; i++) {
                st = new StringTokenizer(br.readLine()," ");
                Current = Integer.parseInt(st.nextToken());
                Destination = Integer.parseInt(st.nextToken());
                Weight = Integer.parseInt(st.nextToken());
                list[Current].add(new Node(Destination, Weight));
                list[Destination].add(new Node(Current, Weight));
            }
            for(int i=0; i<Target; i++) {
                Candidate[i] = Integer.parseInt(br.readLine());
            }
            // Input End ::
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
    static void Solve() {
        int[] tempArr = new int[Vertex + 1];
        Arrays.fill(tempArr, Integer.MAX_VALUE);
        int iter = 0;
        for (Node node : list[Passed1]) {
            for(int i=0; i<Target; i++) {
                if(node.Dest == Candidate[i]) {
                    tempArr[iter++] = node.Dest;
                }
            }
        }
        for (Node node : list[Passed2]) {
            for(int i=0; i<Target; i++) {
                if(node.Dest == Candidate[i]) {
                    tempArr[iter++] = node.Dest;
                }
            }
        }
        Arrays.sort(tempArr);
        for (int i : tempArr) {
            if(i != Integer.MAX_VALUE)
                sb.append(i).append(" ");
            else
                break;
        }
        sb.append('\n');
    }
}
