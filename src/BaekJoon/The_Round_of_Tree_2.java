package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class The_Round_of_Tree_2 {
    static int NodeNum;
    static ArrayList<Node>[] list;
    static int[] branch;
    static boolean[] flag;
    static int Max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NodeNum = Integer.parseInt(br.readLine());
        list = new ArrayList[NodeNum + 1];
        for(int i=0; i<=NodeNum; i++)
            list[i] = new ArrayList<>();
        branch = new int[NodeNum + 1];
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
            branch[tempS]++;
        }
        //Input Ends
        for(int i=1; i<=NodeNum; i++) {
            if(branch[i] == 2) {
                flag = new boolean[NodeNum + 1];
                recur(i, 0);
            }
        }
        System.out.println(Max);
    }
    static int recur(int index, int value) {
        flag[index] = true;
        if(branch[index] == 2) {
            Node first, second;
            int result1 = 0, result2 = 0;
            first = list[index].get(0);
            second = list[index].get(1);
            if(!flag[first.Dest]) {
                result1 = recur(first.Dest, first.Weight + value);
                flag[first.Dest] = true;
            }
            if(!flag[second.Dest]) {
                result2 = recur(second.Dest, value + second.Weight);
                flag[second.Dest] = true;
            }
            Max = Math.max(Max, result1 + result2);
            value = Math.max(result1, result2);
        }
        else {
            if(!flag[list[index].get(0).Dest])
            value = recur(list[index].get(0).Dest, value + list[index].get(0).Weight);
            flag[list[index].get(0).Dest] = true;
        }
        return value;
    }
    static class Node {
        int Dest,Weight;
        public Node(int d, int w) {
            Dest = d;
            Weight = w;
        }
    }
}
