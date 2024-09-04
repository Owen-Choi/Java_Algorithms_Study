package baekJoon.normal;

import java.util.*;
import java.io.*;

public class 사탕_게임 {
    static int answer = 0;
//    static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Character[][] arr = new Character[n][n];
        String input;
        for(int i=0; i<n; i++) {
            input = br.readLine();
            for(int k=0; k<n; k++) {
                arr[i][k] = input.charAt(k);
            }
        }
        // 좌우로 바꾸는 반복문과 상하로 바꾸는 반복문 총 2번을 거치면 되려나?
        // 1. 좌우로 바꾸는 반복문
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n - 1; k++) {
                // 만약 좌-우로 인접한 값이 다르다면
                if (arr[i][k] != arr[i][k + 1]) {
                    // 바꾸고 탐색해보기.
                    swap(i,k,i,k+1, arr);
                    bfs_variation(new Node(i,k), arr);
                    bfs_variation(new Node(i,k + 1), arr);
                    // 다시 바꾸기
                    swap(i,k,i,k+1, arr);
                } else
                    bfs_variation(new Node(i, k), arr);
            }
        }

        // 2. 상하로 바꾸는 반복문
        for(int k=0; k<n; k++) {
            for(int i=0; i<n-1; i++) {
                if(arr[i][k] != arr[i+1][k]) {
                    swap(i, k, i+1, k, arr);
                    bfs_variation(new Node(i,k), arr);
                    bfs_variation(new Node(i+1,k), arr);
                    swap(i, k, i+1, k, arr);
                }
            }
        }
        System.out.println(answer);
    }

    // bfs 변형. 상하나 좌우로만 본다.
    static void bfs_variation(Node start, Character[][] arr) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] flag = new boolean[arr.length][arr.length];
        queue.offer(start);
        flag[start.x][start.y] = true;
        int horizon_counter = 1, vertical_counter = 1;
        // 좌우 bfs
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            int leftY = poll.y - 1, rightY = poll.y + 1;
//            if(leftY < 0 || rightY >= arr.length)
//                continue;
            if(leftY >= 0) {
                if(!flag[poll.x][leftY] && arr[poll.x][leftY] == arr[poll.x][poll.y]) {
                    flag[poll.x][leftY] = true;
                    queue.offer(new Node(poll.x, leftY));
                    horizon_counter++;
                }
            }
            if(rightY < arr.length) {
                if(!flag[poll.x][rightY] && arr[poll.x][rightY] == arr[poll.x][poll.y]) {
                    flag[poll.x][rightY] = true;
                    queue.offer(new Node(poll.x, rightY));
                    horizon_counter++;
                }
            }
        }

        // 상하 bfs
        for(int i=0; i<arr.length; i++) {
            Arrays.fill(flag[i], false);
        }
        queue.offer(start);
        flag[start.x][start.y] = true;

        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            int upX = poll.x - 1, downX = poll.x + 1;
//            if(upX < 0 || downX >= arr.length)
//                continue;
            if(upX >= 0) {
                if(!flag[upX][poll.y] && arr[upX][poll.y] == arr[poll.x][poll.y]) {
                    flag[upX][poll.y] = true;
                    queue.offer(new Node(upX, poll.y));
                    vertical_counter++;
                }
            }
            if(downX < arr.length) {
                if(!flag[downX][poll.y] && arr[downX][poll.y] == arr[poll.x][poll.y]) {
                    flag[downX][poll.y] = true;
                    queue.offer(new Node(downX, poll.y));
                    vertical_counter++;
                }
            }
        }
        answer = Math.max(answer, Math.max(horizon_counter, vertical_counter));
    }

    // 후퇴. bfs 아니다. 좌우로만 보거나 상하로만 봐야 한다.
//    static void bfs(Node start, Character[][] arr) {
//        Queue<Node> queue = new LinkedList<>();
//        boolean[][] flag = new boolean[arr.length][arr.length];
//        queue.offer(start);
//        flag[start.x][start.y] = true;
//        int counter = 0;
//        while(!queue.isEmpty()) {
//            Node poll = queue.poll();
//            for(int i=0; i<4; i++) {
//                int nextX = poll.x + move[0][i];
//                int nextY = poll.y + move[1][i];
//                if(nextX < 0 || nextX >= arr.length || nextY < 0 || nextY >= arr.length) {
//                    continue;
//                }
//                if(!flag[nextX][nextY] && arr[nextX][nextY] == arr[poll.x][poll.y]) {
//                    flag[nextX][nextY] = true;
//                    queue.offer(new Node(nextX, nextY));
//                    counter++;
//                }
//            }
//        }
//
//    }

    static void swap(int x1, int y1, int x2, int y2, Character[][] arr) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
