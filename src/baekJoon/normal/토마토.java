package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 토마토 {

    static int[][] move = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    static int[][][] arr;
    static boolean[][][] visit;
    static int result = 1, count = 0;
    static boolean flag = false, resultFlag = false;

    public static void main(String[] args) throws IOException {
        int n, m, h;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        Queue<Node> queue = new LinkedList<>();
        arr = new int[n][m][h];
        visit = new boolean[n][m][h];
        for (int j = 0; j < h; j++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][k][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][k][j] == 0) count++;
                }
            }
        }
        // 레벨 단위 BFS 시작
        for (int j = 0; j < h; j++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < m; k++) {
                    // TODO 이게 아니라 모든 1을 큐에 넣고 탐색해야 한다고 한다.
                    if (arr[i][k][j] == 1) {
                        visit[i][k][j] = true;
                        queue.offer(new Node(i, k, j));
                    }
                }
            }
        }
        bfs(queue, n,m,h);
        result--;
        LOOP : for(int j=0; j<h; j++) {
            for(int i=0; i<n; i++) {
                for(int k=0; k<m; k++) {
                    if(arr[i][k][j] == 0){
                        result = -1;
                        break LOOP;
                    }
                }
            }
        }
        System.out.println(result);
    }

    static void bfs(Queue<Node> queue, int n, int m, int h) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 레벨단위 bfs
            flag = false;
            for (int ii = 0; ii < size; ii++) {
                Node poll = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nextX = poll.x + move[0][i];
                    int nextY = poll.y + move[1][i];
                    // 이 조건문에는 애초에 들어올 수가 없다. 둘다 0인 경우가 없기 때문.
                    queueOffer(queue, n, m, h, new int[]{nextX, nextY, poll.z}, poll);
                }
                queueOffer(queue, n, m, h, new int[]{poll.x, poll.y, poll.z - 1}, poll);
                queueOffer(queue, n, m, h, new int[]{poll.x, poll.y, poll.z + 1}, poll);
            }
        }
    }

    static void queueOffer(Queue<Node> queue, int n, int m, int h, int[] nexts, Node poll) {
        if (nexts[0] < 0 || nexts[0] >= n || nexts[1] < 0 || nexts[1] >= m || nexts[2] < 0 || nexts[2] >= h) {
            return;
        }
        if(!visit[nexts[0]][nexts[1]][nexts[2]]) {
            if (arr[nexts[0]][nexts[1]][nexts[2]] == 0) {
                arr[nexts[0]][nexts[1]][nexts[2]] = arr[poll.x][poll.y][poll.z] + 1;
                result = Math.max(arr[nexts[0]][nexts[1]][nexts[2]], result);
                flag = visit[nexts[0]][nexts[1]][nexts[2]] = resultFlag = true;
                queue.offer(new Node(nexts[0], nexts[1], nexts[2]));
            }
        }
    }

    static class Node {
        int x;
        int y;
        int z;

        Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
