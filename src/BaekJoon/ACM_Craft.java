package BaekJoon;

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
        int result = 0;
        for(int i=1; i<=buildingNum; i++) {
            if(indegree[i] == 0)
                queue.offer(i);
        }
        int temp = 0, poped, maxIndex = 0, maxValue;
        for(int i=1; i<=buildingNum; i++) {
            if(queue.isEmpty()) {
                System.out.println("Cycles exist");
                return;
            }
            poped = queue.poll();
            result += buildings[poped];
            if(poped == target) {
                sb.append(result).append('\n');
                return;
            }
            maxValue = -1;
            for(int k=0; k<list[poped].size(); k++) {
                // 진입점이 0이면서 가장 가치가 큰 점을 고른다. 그렇게 하는 이유는
                // 모든 점이 다 건설완료되어야 다음 건물을 지을 수 있는데,
                // 가장 건설이 오래 걸리는 건물을 기준으로 잡으면 다른 건물들은 자동으로
                // 건설이 완료되기 때문.
                int y = list[poped].get(k);
                if(buildings[y] > maxValue) {
                    maxValue = buildings[y];
                    maxIndex = y;
                }
            }
            queue.offer(maxIndex);
        }
        sb.append(result).append('\n');
    }
}
