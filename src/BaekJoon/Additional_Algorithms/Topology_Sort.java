package BaekJoon.Additional_Algorithms;

// 위상정렬 알고리즘
// 백준 1005번 문제를 풀기 위한 선행 알고리즘

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Topology_Sort {
    static final int MAX = 10;
    static int n;
    static int[] indegree = new int[MAX];
    static ArrayList<Integer>[] a = new ArrayList[MAX];
    public static void main(String[] args) {
        n = 7;
        for(int i=0; i<MAX; i++) {
            a[i] = new ArrayList<>();
        }
        a[1].add(2);
        indegree[2]++;
        a[1].add(5);
        indegree[5]++;
        a[2].add(3);
        indegree[3]++;
        a[3].add(4);
        indegree[4]++;
        a[4].add(6);
        indegree[6]++;
        a[5].add(6);
        indegree[6]++;
        a[6].add(7);
        indegree[7]++;

        sort();
    }
    static void sort() {
        int[] result = new int[MAX];
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            if(indegree[i] == 0)
                q.offer(i);
        }
        // sort 시작
        int temp;
        for(int i=1; i<=n; i++) {
            if(q.isEmpty()) {
                System.out.println("there is cycle :: ");
                return;
            }
            temp = q.poll();
            //indegree[temp]--;
            result[i] = temp;
            for(int k=0; k<a[temp].size(); k++) {
                // 선택된 가지? 에서 indegree가 0인 인덱스, 즉 진입차수가 0인 값을 찾고 큐에 넣는다.
                int y = a[temp].get(k);
                // y는 기존에 temp와 연결되어있던 노드이다. 따라서 모든 y의 indegree가 하나씩 줄어야 하기 때문에
                // 일단 하나씩 줄이고 들어가는 것이다.
                if(--indegree[y] == 0)
                    q.offer(y);
            }
        }
        for(int i=1; i<=n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
