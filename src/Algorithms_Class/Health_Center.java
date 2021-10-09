package Algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Health_Center {
    static int CurrentCenter, InterSectionNum;
    static int[] CurrentLocation;
    static ArrayList<Node>[] list;
    static int[][] dist;                    //HealthCenter의  수가 하나 이상일 수 있기 때문에 2차원 배열로 선언
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        CurrentCenter = Integer.parseInt(st.nextToken());
        InterSectionNum = Integer.parseInt(st.nextToken());
        CurrentLocation = new int[CurrentCenter+1];
        dist = new int[InterSectionNum+1][InterSectionNum+1];
        for(int i=0; i<CurrentCenter; i++) {
            CurrentLocation[i + 1] = Integer.parseInt(br.readLine());
        }
        list = new ArrayList[InterSectionNum + 1];
        for(int i=0; i<=InterSectionNum; i++)
            list[i] = new ArrayList<>();
        // Array list initialization ::
        int tempS, tempF, tempW;
        Node tempNode;
        for(int i=1; i<=InterSectionNum; i++) {
            st = new StringTokenizer(br.readLine()," ");
            tempS = Integer.parseInt(st.nextToken());
            tempF = Integer.parseInt(st.nextToken());
            tempW= Integer.parseInt(st.nextToken());
            tempNode = new Node(tempS, tempF, tempW);
            list[tempS].add(tempNode);
            list[tempF].add(tempNode);
            // non-directional graph ::
            // Input ends ::
        }

    }
    static class Node implements Comparable<Node>{
        int S, F, W;
        public Node(int S, int F, int W) {
            this.S = S;
            this.F = F;
            this.W = W;
        }
        @Override
        public int compareTo(Node o) {
            return this.W - o.W;
        }
    }

    static void Solve(Node InitNode) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(InitNode);
        while(!queue.isEmpty()) {

        }
    }
}
