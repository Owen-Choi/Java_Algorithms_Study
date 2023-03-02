package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Musical_Program {

    // 2623번, 음악 프로그램, 골드3, 위상정렬
    static int N, M;
    static List<Integer>[] list;
    static int[] indegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N];
        list = new ArrayList[N];
        for(int i=0; i<N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int count = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken()) - 1;
            for(int k=0; k<count - 1; k++) {
                int second = Integer.parseInt(st.nextToken()) - 1;
                list[first].add(second);
                indegree[second]++;

                first = second;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i< indegree.length; i++) {
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

        // 문제 핵심 사이클 체크 부분.
        if(result.size() != N) {
            System.out.println(0);
            System.exit(0);
        }

        for (Integer element : result) {
            sb.append(element + 1).append("\n");
        }
        System.out.println(sb.substring(0, sb.length() - 1));

    }
}
