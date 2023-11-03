package softeer;

import java.io.*;
import java.util.*;

public class 장애물인식프로그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] move = {{-1,1,0,0}, {0,0,-1,1}};

        for(int i=0; i < n; i++) {
            String input = br.readLine();
            for(int k=0; k<input.length(); k++) {
                arr[i][k] = input.charAt(k) - '0';
            }
        }

        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        boolean[][] flag = new boolean[n][n];
        int cnt;
        for(int i=0; i<n; i++) {
            for(int k=0; k<n; k++) {
                if(!flag[i][k] && arr[i][k] != 0) {
                    // bfs 시작
                    queue.offer(new Node(i, k));
                    flag[i][k] = true;
                    cnt = 0;
                    while(!queue.isEmpty()) {
                        Node poll = queue.poll();
                        flag[poll.x][poll.y] = true;
                        cnt++;
                        for(int j=0; j<4; j++) {
                            int nextX = poll.x + move[0][j];
                            int nextY = poll.y + move[1][j];
                            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;
                            if(!flag[nextX][nextY] && arr[nextX][nextY] != 0) {
                                queue.offer(new Node(nextX, nextY));
                            }
                        }
                    }
                    list.add(cnt);
                }
            }
        }
        list.sort(new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Integer element : list) {
            sb.append(element).append('\n');
        }
        System.out.println(sb.toString());
    }

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
