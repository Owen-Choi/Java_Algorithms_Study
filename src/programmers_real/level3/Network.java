package programmers_real.level3;

import java.util.*;

public class Network {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = new int[][] {{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(new NetworkSolution().solution(n, computers));
    }
}

class NetworkSolution {
    int[] parent;
    public int solution(int n, int[][] computers) {
        // union find
        // 컴퓨터의 수 n
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        // 모든 간선을 탐색할 방법을 찾아야 함
        for(int i=0; i<computers.length; i++) {
            for(int k=0; k<computers[i].length; k++) {
                if(i != k && computers[i][k] == 1) {
                    if(!isCycle(i, k)) {
                        unionParent(i, k);
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            parent[i] = getParent(i);
        }

        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<n; i++) {
            set.add(parent[i]);
        }
        return set.size();
    }

    int getParent(int node) {
        if(parent[node] == node)
            return node;
        else return parent[node] = getParent(parent[node]);
    }

    boolean isCycle(int node1, int node2) {
        int node1P = getParent(node1);
        int node2P = getParent(node2);
        if(node1P == node2P)
            return true;
        return false;
    }

    void unionParent(int node1, int node2) {
        int node1P = getParent(node1);
        int node2P = getParent(node2);
        if(node1P > node2P)
            parent[node1P] = node2P;
        else
            parent[node2P] = node1P;
    }
}
