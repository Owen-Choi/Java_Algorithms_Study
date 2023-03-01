package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1766, 문제집, 골드2, 위상정렬 (Topological Sort)
public class Workbook {

    static int N, M;
    static List<Integer>[] list;
    static int[] indegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        indegree = new int[N];

        for(int i=0; i<N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            list[first].add(second);
            indegree[second]++;
        }

        // 위상정렬 시작
//        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<list.length; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (Integer integer : list[node]) {
                indegree[integer]--;
                if(indegree[integer] == 0) {
                    queue.add(integer);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : result) {
            sb.append(integer + 1).append(" ");
        }
        System.out.println(sb.toString());
    }
}
