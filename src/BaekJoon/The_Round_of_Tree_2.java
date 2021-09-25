package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class The_Round_of_Tree_2 {
    static int NodeNum;
    static ArrayList<Node>[] list;
    static boolean[] flag;
    static int Max = -1;
    static int tempNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NodeNum = Integer.parseInt(br.readLine());
        list = new ArrayList[NodeNum + 1];
        for(int i=0; i<=NodeNum; i++)
            list[i] = new ArrayList<>();
        StringTokenizer st;
        int tempS, tempD, tempW;
        for(int i=1; i<NodeNum; i++) {
            st = new StringTokenizer(br.readLine()," ");
            tempS = Integer.parseInt(st.nextToken());
            tempD = Integer.parseInt(st.nextToken());
            tempW = Integer.parseInt(st.nextToken());
            list[tempS].add(new Node(tempD, tempW));
            list[tempD].add(new Node(tempS, tempW));
            // Update branch array to check if node has two childs
        }
        //Input Ends
        flag = new boolean[NodeNum + 1];
        recur(1, 0);
        flag = new boolean[NodeNum + 1];
        recur(tempNode, 0);
        System.out.println(Max);
    }
    static void recur(int index, int value) {
        if(value > Max) {
            Max = value;
            tempNode = index;
        }
        flag[index] = true;
        for (Node node : list[index]) {
            if(!flag[node.Dest]) {
                recur(node.Dest, value + node.Weight);
                flag[node.Dest] = true;
            }
        }
    }
    static class Node {
        int Dest,Weight;
        public Node(int d, int w) {
            Dest = d;
            Weight = w;
        }
    }
}