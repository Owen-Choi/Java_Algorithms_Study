package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class The_Round_of_Tree {
    static int NodeNum;
    static ArrayList<Node>[] list;
    static boolean [] flag;
    static int Max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NodeNum = Integer.parseInt(br.readLine());
        flag = new boolean[NodeNum + 1];
        list = new ArrayList[NodeNum + 1];
        for(int i=0; i<=NodeNum; i++)
            list[i] = new ArrayList<>();
        int HeadIndex, TargetIndex, Weight;
        for (int i = 0; i < NodeNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            HeadIndex = Integer.parseInt(st.nextToken());
            TargetIndex = Integer.parseInt(st.nextToken());
            while (TargetIndex != -1) {
                Weight = Integer.parseInt(st.nextToken());
                list[HeadIndex].add(new Node(TargetIndex, Weight));
                TargetIndex = Integer.parseInt(st.nextToken());
            }
        }
        // Input end ::
        recur(1, 0);
        System.out.println(Max);
    }
    static class Node {
        int Dest, Weight;
        public Node(int de, int we) {
            Dest = de;
            Weight = we;
        }
    }
    static void recur(int index, int value) {
        for (Node node : list[index]) {
            if(!flag[node.Dest]) {
                flag[node.Dest] = true;
                recur(node.Dest, value + node.Weight);
                recur(node.Dest, value);
            }
        }
        Max = Math.max(Max, value);
    }
}
