package baekJoon.advanced;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 1865, 웜홀, 골드 3, 벨만포드
public class WormHole {
    static int N, M, W;
    static List<Node>[] list;
    static int[] dist;
    static class Node {
        int destination;
        int value;
        public Node(int d, int v) {
            this.destination = d;
            this.value = v;
        }
    }
    public static void main(String[] args) throws IOException {
        int TC;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());
        for(int i=0; i<TC; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // N : 지점의 수
            // M : 도로의 수
            // W : 웜홀의 수
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            dist = new int[N];
            list = new ArrayList[N];
            for(int l=0; l<N; l++) {
                list[l] = new ArrayList<>();
            }

            for(int k=0; k<M; k++) {
                st = new StringTokenizer(br.readLine(), " ");
                // 도로는 양방향이므로 양쪽에 다 추가해준다.
                int start = Integer.parseInt(st.nextToken()) - 1;
                int destination = Integer.parseInt(st.nextToken()) - 1;
                int value = Integer.parseInt(st.nextToken());
                list[start].add(new Node(destination, value));
                list[destination].add(new Node(start, value));
            }
            for(int k=0; k<W; k++) {
                st = new StringTokenizer(br.readLine(), " ");
                // 웜홀은 단방향이므로 한쪽에만 추가해준다.
                int start = Integer.parseInt(st.nextToken()) - 1;
                int destination = Integer.parseInt(st.nextToken()) - 1;
                int value = Integer.parseInt(st.nextToken());
                list[start].add(new Node(destination, -value));
            }
            sb.append(bellmanFord() ? "YES\n" : "NO\n");
            clearList();
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean bellmanFord() {
        // Integer.MAX_VALUE로 채우지 않는 이유는 모든 간선을 확인하지 않고 하나의 간선만 확인을 하고도
        // 음의 사이클이 존재하는지 확인하기 위한 것이다.
        Arrays.fill(dist, 9999999);
        dist[0] = 0;
        boolean update = false;
        // 음의 사이클만 찾으면 된다.
        for(int i=0; i<N-1; i++) {
            update = false;
            for(int k=0; k<N; k++) {
                for (Node next : list[k]) {
                    if(dist[next.destination] > dist[k] + next.value) {
                        dist[next.destination] = dist[k] + next.value;
                        update = true;
                    }
                }
            }
            if(!update)
                break;
        }

        if(update) {
            for(int i=0; i<N; i++) {
                for (Node node : list[i]) {
                    if(dist[node.destination] > dist[i] + node.value) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static void clearList() {
        for(int i=0; i<N; i++) {
            list[i].clear();
        }
    }
}
