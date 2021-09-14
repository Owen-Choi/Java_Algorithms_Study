package Algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Saving_Ink {
    static int DotNum;
    static double[][] dot;
    static double [][] distance;
    static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DotNum = Integer.parseInt(br.readLine());
        StringTokenizer st;
        dot = new double[DotNum][3];
        parent = new int[DotNum + 1];
        // saving values to doy array ::
        for(int i=0; i<DotNum; i++) {
            st = new StringTokenizer(br.readLine()," ");
            dot[i][0] = Double.parseDouble(st.nextToken());
            dot[i][1] = Double.parseDouble(st.nextToken());
            // this is the dot's number ::
            dot[i][2] = i;
        }
        // in this array, we can get distance value between first index and second index ::
        distance = new double[DotNum][DotNum];
        for(int i=0; i<DotNum; i++) {
            for(int k=i+1; k<DotNum; k++) {
                //now we have all distances value of two different nodes
                 distance[i][k] = Math.sqrt(Math.pow(dot[i][0] - dot[k][0], 2) + Math.pow(dot[i][1] - dot[k][1], 2));
                 distance[i][k] = Double.parseDouble(String.format("%.2f", distance[i][k]));
            }
        }
        LinkedList<Node> list = new LinkedList<>();
        for(int i=0; i<DotNum; i++) {
            for(int k=i+1; k<DotNum; k++) {
                list.add(new Node(i, k, distance[i][k]));
            }
        }
        // list sorting
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.Dist < o2.Dist)
                    return -1;
                else if(o1.Dist == o2.Dist)
                    return 0;
                else
                    return 1;
            }
        });

        for(int i=0; i<parent.length; i++)
            parent[i] = i;

        double sumValue = 0.0;
        Node tempNode;
        while(!list.isEmpty()) {
            tempNode = list.poll();
            //check for cycle and if there isn't, update sum value and make parent index same
            if(!checkForCycle(tempNode.Start, tempNode.Dest)) {
                sumValue += tempNode.Dist;
                MergeParent(tempNode.Start, tempNode.Dest);
            }
        }
        System.out.println(sumValue);
    }
    //class for nodes
    static class Node {
        int Start, Dest;
        double Dist;
        public Node(int Start, int Dest, double Dist) {
            this.Start = Start;
            this.Dest = Dest;
            this.Dist = Dist;
        }
    }
    // method that returns the parent's index
    static int getParent(int IndexForCheck) {
        if(parent[IndexForCheck] == IndexForCheck)
            return IndexForCheck;
        return parent[IndexForCheck] = getParent(parent[IndexForCheck]);
    }
    // method that returns boolean value :: if there is cycle, then return true, and we don't have to
    // :: update sum value and merge parent
    static boolean checkForCycle(int FirstIndex, int SecondIndex) {
        FirstIndex = getParent(FirstIndex);
        SecondIndex = getParent(SecondIndex);
        return FirstIndex == SecondIndex;
    }
    // make parent array's value to prevent cycle
    static void MergeParent(int FirstIndex, int SecondIndex) {
        FirstIndex = getParent(FirstIndex);
        SecondIndex = getParent(SecondIndex);
        if(FirstIndex < SecondIndex) parent[SecondIndex] = FirstIndex;
        else parent[FirstIndex] = SecondIndex;
    }
}
