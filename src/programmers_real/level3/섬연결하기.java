package programmers_real.level3;

import java.util.*;
public class 섬연결하기 {
    public static void main(String[] args) {
        int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
        int n=4;
        System.out.println(new LinkingIslandSolution().solution(n, costs));
    }
}


class LinkingIslandSolution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        // mst 시작
        // 간선을 기준으로 오름차순 정렬, 크루스칼 사용 준비
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        int result = 0;
        for(int i=0; i<costs.length; i++) {
            if(!isCycle(costs[i][0], costs[i][1])) {
                unionParent(costs[i][0], costs[i][1]);
                result += costs[i][2];
            }
        }
        return result;
    }

    int getParent(int a) {
        if(parent[a] == a)
            return a;
        return parent[a] = getParent(parent[a]);
    }

    void unionParent(int a, int b) {
        int aParent = getParent(a);
        int bParent = getParent(b);
        if(aParent > bParent) {
            parent[aParent] = bParent;
        } else {
            parent[bParent] = aParent;
        }
    }

    boolean isCycle(int a, int b) {
        int aParent = getParent(a);
        int bParent = getParent(b);
        return aParent == bParent;
    }
}