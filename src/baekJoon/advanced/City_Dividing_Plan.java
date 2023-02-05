package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 1647번, 도시 분할 계획, 골드 4
public class City_Dividing_Plan {

    static int N, M;
    static int[] parent;
    static int result = 0;
    static List<Node> list = new ArrayList<>();
    static class Node {
        int start;
        int end;
        int value;

        public Node(int s, int e, int v) {
            this.start = s;
            this.end = e;
            this.value = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        // 처음에 부모를 자기 자신으로 초기화해줌.
        for(int i=0; i<N; i++) {
            parent[i] = i;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken());
            list.add(new Node(s,e,v));
        }

        // 정렬
        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value - o2.value;
            }
        });

        int lastConnected = 0;
        for(int i=0; i<M; i++) {
//            if(checkCycle(list.get(i).start, list.get(i).end)) {
//                result += list.get(i).value;
//                mergeParent(list.get(i).start, list.get(i).end);
//            }
            int firstParentIndex = checkParent(list.get(i).start);
            int secondParentIndex = checkParent(list.get(i).end);
            if(firstParentIndex != secondParentIndex) {
                result += list.get(i).value;
                lastConnected = list.get(i).value;
                mergeParent(firstParentIndex, secondParentIndex);
            }
        }

        System.out.println(result - lastConnected);
    }

    static boolean checkCycle(int startIndex, int destinationIndex) {
        int startNodeParent = checkParent(startIndex);
        int destinationNodeParent = checkParent(startIndex);
        return startNodeParent == destinationNodeParent;
    }

    static int checkParent(int index) {
        // https://maetdori.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Kruskal-Algorithm-Union-Find-%ED%81%AC%EB%A3%A8%EC%8A%A4%EC%B9%BC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%9C%A0%EB%8B%88%EC%98%A8-%ED%8C%8C%EC%9D%B8%EB%93%9C
        if(parent[index] == index)
            return index;
        else
            return checkParent(parent[index]);
    }

    static void mergeParent(int startParentIndex, int destinationParentIndex) {
        if(startParentIndex < destinationParentIndex) {
            parent[destinationParentIndex] = startParentIndex;
        } else {
            parent[startParentIndex] = destinationParentIndex;
        }
    }
}
