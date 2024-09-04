package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 스타트링크 {
    static boolean[] flag = new boolean[1000001];
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken()),
                g = Integer.parseInt(st.nextToken()), u = Integer.parseInt(st.nextToken()),
                d = Integer.parseInt(st.nextToken());
        // f : 건물의 총 높이
        // s : 현재 층 수
        // g : 사무실의 위치
        // u : 올라가는 버튼을 누르면 올라가는 층 수
        // d : 내려가는 버튼을 누르면 내려가는 층 수

        // 방문 배열을 두고 dfs로 풀어보자.

//        dfs(s, 0, g, u, d, f);
//        System.out.println(answer == Integer.MAX_VALUE ? "use the stairs" : answer);
        // dfs로 풀이하니 시간초과를 맞았다. bfs로 풀어보자. 이것도 최단거리 구하는 문제랑 다름이 없으니까 말이다.
        // 시간초과는 해결했는데, 81%에서 틀렸다.
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        flag[s] = true;
        int counter = 0;
        // 생각해보니 레벨 단위 큐가 맞다.

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i=0; i<queueSize; i++) {
                int poll = queue.poll();
                if(poll == g) {
                    System.out.println(counter);
                    return;
                }
                if(poll + u <= f && !flag[poll + u]) {
                    flag[poll + u] = true;
                    queue.offer(poll + u);
                }
                // TODO 어머, 0층은 없다.
                if(poll - d > 0 && !flag[poll - d]) {
                    flag[poll - d] = true;
                    queue.offer(poll - d);
                }
            }
            counter++;
        }
        System.out.println("use the stairs");
    }

//    static void dfs(int currentValue, int depth, int g, int u, int d, int f) {
////        System.out.println("currentValue :  " + currentValue + " , target : " + g + " , depth : " + depth);
//        if(currentValue == g) {
//            answer = Math.min(answer, depth);
//            return;
//        }
//
//        if(currentValue < 0 || currentValue > f)
//            return;
//
//        if(currentValue + u <= f) {
//            if(!flag[currentValue + u]) {
//                flag[currentValue + u] = true;
//                dfs(currentValue + u, depth + 1, g, u, d, f);
//                flag[currentValue + u] = false;
//            }
//        }
//
//        if(currentValue - d >= 0) {
//            if(!flag[currentValue - d]) {
//                flag[currentValue - d] = true;
//                dfs(currentValue - d, depth + 1, g, u, d, f);
//                flag[currentValue - d] = false;
//            }
//        }
//    }


}
