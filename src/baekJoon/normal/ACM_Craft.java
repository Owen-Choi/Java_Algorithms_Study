package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACM_Craft {
    static int testCase, target;
    static int rules, buildingNum;
    static int[] buildings, indegree;
    static ArrayList<Integer>[] list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(testCase --> 0) {
            st = new StringTokenizer(br.readLine()," ");
            buildingNum = Integer.parseInt(st.nextToken());
            rules = Integer.parseInt(st.nextToken());
            buildings = new int[buildingNum+1];
            indegree = new int[buildingNum+1];
            list = new ArrayList[buildingNum+1];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=1; i<=buildingNum; i++) {
                buildings[i] = Integer.parseInt(st.nextToken());
                list[i] = new ArrayList<>();
            }
            int temp1, temp2;
            for(int i=0; i<rules; i++) {
                st = new StringTokenizer(br.readLine()," ");
                temp1 = Integer.parseInt(st.nextToken());
                temp2 = Integer.parseInt(st.nextToken());
                list[temp1].add(temp2);
                indegree[temp2]++;
            }
            target = Integer.parseInt(br.readLine());
            Topology();
        }
        System.out.println(sb);
    }
    static void Topology() {
        Queue<Integer> queue = new LinkedList();
        int[] result = buildings.clone();
        for(int i=1; i<=buildingNum; i++) {
            if(indegree[i] == 0)
                queue.offer(i);
        }
        int poped;
        while(!queue.isEmpty()) {
            poped = queue.poll();
            for(int i=0; i<list[poped].size(); i++) {
                int y = list[poped].get(i);
                result[y] = Math.max(result[y], result[poped] + buildings[y]);
                if(--indegree[y] == 0)
                    queue.offer(y);
            }
        }
        sb.append(result[target]).append('\n');
    }
}
