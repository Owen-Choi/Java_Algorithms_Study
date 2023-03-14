package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1260번
public class Dfs_and_Bfs_again {
    static int n;
    static int m;
    static int v;
    static ArrayList<Integer>[] datas;
    static ArrayList<Integer> resultDFS = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        datas = new ArrayList[n];

        for(int i=0; i<n; i++) {
            datas[i] = new ArrayList<Integer>();
        }

        // 데이터를 처음 받을때 잘 받는게 중요.
        int pre, post;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            pre = Integer.parseInt(st.nextToken());
            post = Integer.parseInt(st.nextToken());
            // 양방향
            datas[pre - 1].add(post);
            datas[post - 1].add(pre);
        }

        // 샘플 데이터를 보니 미리 오름차순으로 정렬을 해줘야할 것 같음.
        for (int k=0; k< datas.length; k++) {
            datas[k].sort(Comparator.naturalOrder());
        }

        resultDFS.add(v);
        DFS(v);
        // DFS가 종료되면 resultDFS가 완성됐을 것임. 출력해주도록 하자
        for (Integer element : resultDFS) {
            System.out.print(element + " ");
        }
        System.out.println();
        BFS(v);

    }
    static void DFS(int vertex) {
        for(int i=0; i<datas[vertex - 1].size(); i++) {
            // 재귀라서 중복이 생길 수 있으니 배제해준다.
            if(!resultDFS.contains(datas[vertex - 1].get(i))) {
                resultDFS.add(datas[vertex - 1].get(i));
                // 또한 탐색이 완료(리스트에 추가)된 시점으로 부터 완료된 지점의 하위를 다시 탐색한다.
                DFS(datas[vertex - 1].get(i));
            }
        }
    }

    static void BFS(int vertex) {
        StringBuilder sb = new StringBuilder();
        boolean[] flagList = new boolean[n];
        flagList[vertex - 1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            sb.append(poll).append(" ");
            for (Integer element : datas[poll - 1]) {
                if(!flagList[element - 1]) {
                    queue.add(element);
                    flagList[element - 1] = true;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
