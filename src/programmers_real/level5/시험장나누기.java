package programmers_real.level5;

import java.util.*;
public class 시험장나누기 {
    public static void main(String[] args) {
        int[] num = {12, 30, 1, 8, 8, 6, 20, 7, 5, 10, 4, 1};
        int[][] links = {{-1,-1}, {-1,-1}, {-1,-1}, {-1,-1}, {8,5}, {2,10}, {3,0}, {6,1}, {11,-1}, {7,4},{-1,-1},{-1,-1}};
        System.out.println(new TestSolution().solution(3, num, links));
    }
}

class TestSolution {
    int result = -1;
    boolean[] flag;
    int[][] l;
    int[] n;
    int[] parent;
    public int solution(int k, int[] num, int[][] links) {
        int nl = num.length;
        flag = new boolean[nl];
        parent = new int[nl];
        n = num;
        l = links;
        int prevRoot;
        Queue<Integer> queue = new LinkedList<>();
        // 간단하다. 먼저 그래프 탐색으로 자식 그룹의 총합을 구하고, 둘 중에 더 큰 쪽을 자르면 된다.
        // 위 행위를 k번 반복.
        // 유니온 파인드로 루트를 찾아보자.
        for(int i=0; i<nl; i++) {
            parent[i] = i;
        }
        for(int i=0; i<links.length; i++) {
            int left = links[i][0], right = links[i][1];
            if(left != -1) parent[left] = i;
            if(right != -1) parent[right] = i;
        }
        int root = getParent(0);
        // 루트까지는 찾았으니, 이제 루트부터 k번 자식을 자르며 로직을 수행해야 한다.
        for(int i=0; i<k; k++) {
            // 만약 자식이 둘 다 없는 노드가 루트가 됐다면, queue에 저장해뒀던 값을 꺼내온다.
            if((l[root][0] == -1 && l[root][1] == -1)) {
                int poll = 0;
                while(true) {
                    poll = queue.poll();
                    if(l[poll][0] != -1 || l[poll][1] != -1) break;
                }
                root = poll;
            }
            int left = dfs(links[root][0], 0);
            int right = dfs(links[root][1], 0);
            prevRoot = root;
            // left와 right 가 같으면 어떡하지??
            if(left > right)  {
                // 루트를 바꾸기 전에, 연결을 끊었기 때문에 이를 반영해준다.
                l[root][0] = -1;
                if(left > right + n[root]) {
                    // 이 경우에만 root가 바뀌고, 그렇지 않으면 root는 유지된다.
                    queue.offer(root);
                    root = links[root][0];
                } else {
                    queue.offer(links[root][0]);
                }
                // 이 부분이 조금 미심쩍다. 답이 다르면 여기를 좀 더 깊게 생각해보자.
                int tempMax = Math.max(left, right + n[prevRoot]);
                result = Math.max(tempMax, result);
            }
            else {
                // 마찬가지로 반영해준다.
                l[root][1] = -1;
                if(right > left + n[root]) {
                    queue.offer(root);
                    root = links[root][1];
                } else {
                    queue.offer(links[root][1]);
                }
                int tempMax = Math.max(right, left + n[prevRoot]);
                result = Math.max(tempMax, result);
            }
        }
        return result;
    }

    int dfs(int node, int value) {
        // 꼬리재귀로는 풀 수 없다. 반드시 다시 원래의 호출 위치로 돌아와야 한다.
        if(node == -1)
            return value;
        return dfs(l[node][0], n[node]) + dfs(l[node][1], n[node]);
    }

    int getParent(int a) {
        if(parent[a] == a)
            return a;
        return parent[a] = getParent(parent[a]);
    }
}
