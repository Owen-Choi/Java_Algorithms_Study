package baekJoon.algorithms;

import java.util.*;

public class Topological_Sort {
    static int n;
    static int e;

    public static void main(String[] args) {
        n = 7; // 정점 갯수
        e = 9; // 간선 갯수
        int[] indegree = new int[n + 1];
        List<List<Integer>> array = new ArrayList<List<Integer>>();

        for (int i = 0; i < n + 1; i++)
            array.add(new ArrayList<Integer>());

        // 간선 목록 v1 -> v2
        int[] v1 = {1, 1, 2, 4, 3, 3, 5, 2, 5};
        int[] v2 = {2, 3, 5, 6, 4, 7, 6, 4, 4};

        /**
         * 1. v1 -> v2 인접리스트 생성
         * 2. v2 를 가리키는 노드 갯수 indegree 증가
         */
        for (int i = 0; i < e; i++) {
            int c1 = v1[i];
            int c2 = v2[i];

            array.get(c1).add(c2);
            indegree[c2]++;
        }

        topologicalSort(indegree, array);
    }

    static void topologicalSort(int[] indegree, List<List<Integer>> array) {
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> result = new LinkedList<Integer>();

        // 큐에 indegree 가 0 인 노드 담기
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        /**
         * 1. 큐에서 값을 꺼내며 해당 노드가 가리키는 노드의 indegree 를 1 감소
         * 2. 만약 indegree가 0 이 된다면 큐에 넣기
         * 3. 큐가 빌때까지 반복
         */
        while (!q.isEmpty()) {
            int node = q.poll();
            result.offer(node);
            //foreach 문에서 list를 대상으로 넣으면 list의 처음부터 끝까지 값을 대입한다.
            // 여기서는 v1 -> v2로 list에 값을 하나만 넣었기 때문에 연결된 가지만 자를 수 있다.(indegree[i]--)
            for (Integer i : array.get(node)) {
                indegree[i]--;

                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        System.out.println(result);
    }
}
