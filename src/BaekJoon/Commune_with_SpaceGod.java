package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
// 1774 ::
public class Commune_with_SpaceGod {
    static int PointNum, Linked;
    static Node[] arr;
    static double[][] dist;
    static int[] parent;
    static double Result = 0.0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        PointNum = Integer.parseInt(st.nextToken());
        Linked = Integer.parseInt(st.nextToken());
        arr = new Node[PointNum + 1];
        dist = new double[PointNum + 1][2];
        parent = new int[PointNum + 1];
        for (int i = 1; i <= PointNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
            parent[i] = i;
        }
        for(int i=0; i<Linked; i++) {
            st = new StringTokenizer(br.readLine()," ");
            MergeParent(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        // now we have to store every node-distance value
        double tempWeight;
        for(int i=1; i<=PointNum; i++) {
            for(int k=i+1; k<=PointNum; k++) {
                tempWeight = CalcDist(arr[i], arr[k]);
                dist[i][0] = k;                              //도착지
                dist[i][1] = tempWeight;                    //가중치
                dist[k][0] = i;
                dist[k][1] = tempWeight;
            }
        }
        Arrays.sort(dist, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(o1[1] < o2[1])
                    return -1;
                else if(o1[1] == o2[1])
                    return 0;
                else
                    return 1;
            }
        });
        for(int i=1; i<=PointNum; i++) {
            if(!CycleCheck(i, (int)dist[i][0])) {

            }
        }
    }
    static class Node {
        int X, Y, index;

        public Node(int x, int y, int index) {
            X = x;
            Y = y;
            this.index = index;
        }
    }
    static double CalcDist(Node node1, Node node2) {
        return Math.sqrt(Math.pow((node1.X - node2.X),2) + Math.pow((node1.Y) - node2.Y,2));
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
