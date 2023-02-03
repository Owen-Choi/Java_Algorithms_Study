package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1238번, 골드3
public class Party {
    static int N, M, X;
    static List<Node>[] list;
    static List<Node>[] reverseList;
    static int[] go_dist;
    static int[] back_dist;
    static boolean[] visited;
    static class Node {
        int dest;
        int value;
        public Node(int dest, int value) {
            this.dest = dest;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        list = new ArrayList[N];
        reverseList = new ArrayList[N];
        go_dist = new int[N];
        back_dist = new int[N];
        visited = new boolean[N];
        // 파티가 일어나는 마을을 시작점으로 가는 길만 포함된 다익스트라 한번, 오는 길만 포함된 다익스트라 한번 이렇게 2번만 돌린 뒤
        // 2개를 더한 값 중 최댓값이 정답이 된다.
        for(int i=0; i<N; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
            go_dist[i] = back_dist[i] = Integer.MAX_VALUE;
        }
        go_dist[X] = back_dist[X] = 0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) - 1;
            int destination = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());
            // 기존의 다익스트라였으면 list[destination]... 으로 양방향으로 만들어줘야 하지만,
            // 해당 문제는 양방향이 아니라 각각 단방향마다 다른 가중치를 가지므로 한번만 추가해준다.
            list[start].add(new Node(destination, value));
            reverseList[destination].add(new Node(start, value));
        }

        go_dijkstra();
        clearFlags();
        back_dijkstra();
        findMaximum();

    }

    static void go_dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>(((o1, o2) -> o1.value - o2.value));
        q.add(new Node(X, 0));
        while(!q.isEmpty()) {
            Node now = q.poll();
            if(!visited[now.dest]) {
                visited[now.dest] = true;
            }
            for (Node next : list[now.dest]) {
                if(!visited[next.dest] && go_dist[next.dest] > now.value + next.value) {
                    go_dist[next.dest] = now.value + next.value;
                    q.add(new Node(next.dest, go_dist[next.dest]));
                }
            }
        }
    }

    static void clearFlags() {
        for(int i=0; i<N; i++) {
            visited[i] = false;
        }
    }

//    static void back_dijkstra() {
//         PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
//         q.add(new Node(X, 0));
//
//         while(!q.isEmpty()) {
//             Node now = q.poll();
//
//             if(!visited[now.dest]) {
//                 visited[now.dest] = true;
//             }
//
//             for(int i=0; i<N; i++) {
//                 for(int k=0; k<list[i].size(); k++) {
//                     if(list[i].get(k).dest == now.dest) {
//                         if(!visited[i] && back_dist[i] > now.value + list[i].get(k).value) {
//                             back_dist[i] = now.value + list[i].get(k).value;
//                             q.add(new Node(list[i].get(k).dest, back_dist[i]));
//                         }
//                     }
//                 }
//             }
//         }
//    }

    static void back_dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>(((o1, o2) -> o1.value - o2.value));
        q.add(new Node(X, 0));
        while(!q.isEmpty()) {
            Node now = q.poll();
            if(!visited[now.dest]) {
                visited[now.dest] = true;
            }
            for (Node next : reverseList[now.dest]) {
                if(!visited[next.dest] && back_dist[next.dest] > now.value + next.value) {
                    back_dist[next.dest] = now.value + next.value;
                    q.add(new Node(next.dest, back_dist[next.dest]));
                }
            }
        }
    }


    static void findMaximum() {
        int result = 0;
        for(int i=0; i<N; i++) {
            if(go_dist[i] != Integer.MAX_VALUE && back_dist[i] != Integer.MAX_VALUE) {
                result = Math.max(result, go_dist[i] + back_dist[i]);
            }
        }
        System.out.println(result);
    }
}
