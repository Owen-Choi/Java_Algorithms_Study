package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 스타트_택시 {
    static int[][] move = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    static int currentX, currentY, oil, m;
    static Node[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        oil = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= n; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        currentX = Integer.parseInt(st.nextToken());
        currentY = Integer.parseInt(st.nextToken());

        int counter = 2;
        // 손님은 2부터 표시하겠다. + 도착지는 따로 표시하지 않고, 별도의 배열로 보관하겠다.
        // => BFS 과정에서 도착지인지 출발지인지 알 수 없는 경우에 대비하기 위해
        int gsx, gsy, gdx, gdy;
        nodes = new Node[m + 2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            gsx = Integer.parseInt(st.nextToken());
            gsy = Integer.parseInt(st.nextToken());
            gdx = Integer.parseInt(st.nextToken());
            gdy = Integer.parseInt(st.nextToken());
            arr[gsx][gsy] = counter;
            nodes[counter++] = new Node(gdx, gdy);
        }
        while(true) {
            bfsWithoutGuest(arr, n);
        }
    }

    static void bfsWithoutGuest(int[][] arr, int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(currentX, currentY));
        boolean[][] flag = new boolean[n + 1][n + 1];
        flag[currentX][currentY] = true;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        if(arr[currentX][currentY] != 0 && arr[currentX][currentY] != 1) {
            int tempX = currentX, tempY = currentY;
            bfsWithGuest(arr, n, nodes[arr[currentX][currentY]]);
            arr[tempX][tempY] = 0;
            return;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            if(oil == 0) {
                System.out.println(-1);
                System.exit(0);
            }
            oil--;
            for (int j = 0; j < size; j++) {
                Node poll = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nextX = poll.x + move[0][i];
                    int nextY = poll.y + move[1][i];
                    if (nextX <= 0 || nextX > n || nextY <= 0 || nextY > n) {
                        continue;
                    }
                    if (arr[nextX][nextY] == 0 && !flag[nextX][nextY]) {
                        flag[nextX][nextY] = true;
                        queue.offer(new Node(nextX, nextY));
                    } else if (arr[nextX][nextY] != 1 && !flag[nextX][nextY]) {
                        // 0도 아닌 것이 1도 아니라면?
                        flag[nextX][nextY] = true;
                        pq.offer(new Node(nextX, nextY));
                    }
                }
            }
            if(!pq.isEmpty()) {
                Node temp = pq.poll();
                currentX = temp.x;
                currentY = temp.y;
                bfsWithGuest(arr, n, nodes[arr[temp.x][temp.y]]);
                // 손님을 태웠으니 빈칸으로 처리해준다.
                arr[temp.x][temp.y] = 0;
                return;
            }
        }
    }

    static void bfsWithGuest(int[][] arr, int n, Node destination) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(currentX, currentY));
        boolean[][] flag = new boolean[n + 1][n + 1];
        flag[currentX][currentY] = true;
        int moving = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            moving++;
            if(oil == 0) {
                System.out.println(-1);
                System.exit(0);
            }
            oil--;
            for (int j = 0; j < size; j++) {
                Node poll = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nextX = poll.x + move[0][i];
                    int nextY = poll.y + move[1][i];

                    if (nextX <= 0 || nextX > n || nextY <= 0 || nextY > n) {
                        continue;
                    }

                    // 목적지에 도달했다면 아래의 로직 처리
                    if(nextX == destination.x && nextY == destination.y) {
                        oil += (moving) * 2;
                        currentX = nextX;
                        currentY = nextY;
                        m--;
                        if(m == 0) {
                            System.out.println(oil);
                            System.exit(0);
                        }
                        return;
                    }

                    // 목적지에 도달하지 못했다면 아래의 로직 처리
                    if(!flag[nextX][nextY] && arr[nextX][nextY] != 1) {
                        flag[nextX][nextY] = true;
                        queue.offer(new Node(nextX, nextY));
                    }
                }
            }
        }
    }


    static class Node implements Comparable<Node>{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public int compareTo(Node o) {
            // 1. 행 번호가 제일 작은 승객
            // 2. 열 번호가 제일 작은 승객
            if(this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
}
