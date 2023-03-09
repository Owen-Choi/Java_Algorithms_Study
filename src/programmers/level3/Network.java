package programmers.level3;

import java.util.ArrayList;
import java.util.HashSet;

public class Network {

    static int[] parent;
    public static void main(String[] args) {
        int[][] computers = {{1,1,0}, {1,1,1}, {0,1,1}};
        System.out.println(solution(3, computers));
    }

    public static int solution(int n, int[][] computers) {
        parent = new int[n];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(new ArrayList<>());
            parent[i] = i;
        }



        for(int i=0; i<computers.length; i++) {
            for(int k=0; k<computers[i].length; k++) {
                if(i != k && computers[i][k] == 1) {
                    list.get(i).add(k);
                    list.get(k).add(i);
                }
            }
        }

        // 로직 시작
        // 유니온 파인드로 같은 집합에 속하는 노드들은 모두 부모(루트)를 동일하게 만들어놓는 로직.
        for(int i=0; i<computers.length; i++) {
            for(int k=0; k<computers[i].length; k++) {
                if(i != k && computers[i][k] == 1) {
                    if(findParent(i) != findParent(k)) {
                        unionParent(i,k);
                    }
                }
            }
        }

        // 이제 같은 집합에 속하는 노드들은 부모가 모두 같을테니 중복을 제거한 부모의 값이 정답이다.
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0; i<n; i++) {
            hashSet.add(findParent(i));
        }

        return hashSet.size();
    }

    public static int findParent(int idx) {
        if(parent[idx] == idx) {
            return idx;
        }
        return parent[idx] = findParent(parent[idx]);
    }

    public static void unionParent(int first, int second) {
        int fp = findParent(first);
        int sp = findParent(second);
        if(fp > sp) {
            parent[fp] = sp;
        } else {
            parent[sp] = fp;
        }
    }
}
