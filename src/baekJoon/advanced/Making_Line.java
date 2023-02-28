package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 2252번, 줄 세우기, 골드3, Topological Sort
public class Making_Line {
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
            list[i] = new ArrayList<>();
        }

        // 위상정렬
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int firstMan = Integer.parseInt(st.nextToken()) - 1;
            int secondMan = Integer.parseInt(st.nextToken()) - 1;
            list[firstMan].add(secondMan);
            indegree[secondMan]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for(int i=0; i< indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        // 위상정렬 로직 시작
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

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (Integer integer : result) {
            sb.append(integer + 1).append(" ");
        }
        System.out.println(sb.toString());
    }
}
