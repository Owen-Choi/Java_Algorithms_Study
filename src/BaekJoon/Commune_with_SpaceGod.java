package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1774 ::
public class Commune_with_SpaceGod {
    static int PointNum, Linked;
    static Point[] arr;
    static int[] parent;
    static double Result = 0.0;
    static ArrayList<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        PointNum = Integer.parseInt(st.nextToken());
        Linked = Integer.parseInt(st.nextToken());
        arr = new Point[PointNum + 1];
        parent = new int[PointNum + 1];
        for (int i = 1; i <= PointNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), i);
            parent[i] = i;
        }
        for(int i=0; i<Linked; i++) {
            st = new StringTokenizer(br.readLine()," ");
            MergeParent(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        // now we have to store every node-distance value
        list = new ArrayList<>();
        double tempWeight;
        for(int i=1; i<=PointNum; i++) {
            for(int k=i+1; k<=PointNum; k++) {
                tempWeight = CalcDist(arr[i], arr[k]);
                list.add(new Node(i, k, tempWeight));
            }
        }
        // sorting list with the ascending order of weight value
        Collections.sort(list);
        for(int i=0; i<PointNum; i++) {
            if(!CycleCheck(list.get(i).Start, list.get(i).Dest)) {
                Result += list.get(i).Weight;
                MergeParent(list.get(i).Start, list.get(i).Dest);
            }
        }
        System.out.println(String.format("%.2f", Result));
    }
    static class Point {
        double X, Y;
        int index;

        public Point(double x, double y, int index) {
            X = x;
            Y = y;
            this.index = index;
        }
    }

    static class Node implements Comparable<Node>{
        int Start, Dest;
        double Weight;
        public Node(int st, int de, double We) {
            Start = st;
            Dest = de;
            Weight = We;
        }
        @Override
        public int compareTo(Node o1) {
            if(this.Weight < o1.Weight)
                return -1;
            else if(this.Weight == o1.Weight)
                return 0;
            else
                return 1;
        }
    }

    static double CalcDist(Point node1, Point node2) {
        return Math.sqrt(Math.pow(node1.X - node2.X,2) + Math.pow(node1.Y - node2.Y,2));
    }
    static int GetParent(int index) {
        if(parent[index] == index) return index;
        return parent[index] = GetParent(parent[index]);
    }
    static void MergeParent(int index1, int index2) {
        index1 = GetParent(index1);
        index2 = GetParent(index2);
        if(index1 < index2) parent[index2] = index1;
        else parent[index1] = index2;
    }
    static boolean CycleCheck(int index1, int index2) {
        return GetParent(index1) == GetParent(index2);
    }
}
