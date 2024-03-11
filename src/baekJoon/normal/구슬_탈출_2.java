package baekJoon.normal;

import java.util.*;
import java.io.*;
public class 구슬_탈출_2 {

    static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // 완전탐색. 레벨 단위 BFS로 한번 접근해보겠다.
        Queue<Node> redQueue = new LinkedList<>();
        Queue<Node> blueQueue = new LinkedList<>();
        Node red, blue, hole;
        red = blue = hole = null;
        char[][] arr = new char[n][m];
        boolean[][] redFlag = new boolean[n][m];
        boolean[][] blueFlag = new boolean[n][m];
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            for(int k=0; k<m; k++) {
                arr[i][k] = input.charAt(k);
                if(arr[i][k] == 'R') {
                    red = new Node(i, k);
                    arr[i][k] = '.';
                } else if(arr[i][k] == 'B') {
                    blue = new Node(i, k);
                    arr[i][k] = '.';
                } else if(arr[i][k] == 'O') {
                    hole = new Node(i, k);
                }
            }
        }
        // BFS 시작
        int num = 1;
        redQueue.offer(red);
        blueQueue.offer(blue);
        int size = 0;
        while(num <= 10) {
            size = redQueue.size();
            // 레벨 단위 큐.
            for(int k=0; k<size; k++) {
                // 각각의 움직임마다 지도를 새로 그려주어야 할 듯 하다.
                char[][] clone = new char[n][m];
                for(int i=0; i<n; i++) {
                    clone[i] = arr[i].clone();
                }
                // 빨간공, 파란공을 함께 움직여준다.
                Node redPoll = redQueue.poll();
                Node bluePoll = blueQueue.poll();
                for(int i=0; i<4; i++) {
                    int nextRedX = redPoll.x, nextRedY = redPoll.y;
                    int nextBlueX = bluePoll.x, nextBlueY = bluePoll.y;
                    clone[nextRedX][nextRedY] = 'R';
                    clone[nextBlueX][nextBlueY] = 'B';
                    // R . . . B . . . 상황을 생각해보자. 아래 풀이로는 풀 수 없다.
                    // 물론 방향과 x,y 좌표를 고려해서 일일이 구현해줄 순 있다. 그렇게 한번 해보겠다.
                    // i==0 -> 상, i==1 -> 하
                    // i==2 -> 좌, i==3 -> 우
                    if(i==0) {
                        if(nextRedY < nextBlueY) {
                            while (clone[nextRedX][nextRedY] == '.' || clone[nextRedX][nextRedY] == 'R') {
                                nextRedX += move[0][i];
                                nextRedY += move[1][i];
                            }
                            if(arr[nextRedX][nextRedY] == 'O' && arr[nextBlueX][nextBlueY] != 'O') {
                                System.out.println(num);
                                return;
                            }
                            nextRedX -= move[0][i];
                            nextRedY -= move[1][i];
                            clone[nextRedX][nextRedY] = 'R';
                            clone[redPoll.x][redPoll.y] = '.';
                            while (clone[nextBlueX][nextBlueY] == '.' || clone[nextBlueX][nextBlueY] == 'B') {
                                nextBlueX += move[0][i];
                                nextBlueY += move[1][i];
                            }
                            nextBlueX -= move[0][i];
                            nextBlueY -= move[1][i];
                        } else {
                            while (clone[nextBlueX][nextBlueY] == '.' || clone[nextBlueX][nextBlueY] == 'B') {
                                nextBlueX += move[0][i];
                                nextBlueY += move[1][i];
                            }
                            nextBlueX -= move[0][i];
                            nextBlueY -= move[1][i];
                            clone[nextBlueX][nextBlueY] = 'B';
                            clone[bluePoll.x][bluePoll.y] = '.';
                            while (clone[nextRedX][nextRedY] == '.' || clone[nextRedX][nextRedY] == 'R') {
                                nextRedX += move[0][i];
                                nextRedY += move[1][i];
                            }
                            if(arr[nextRedX][nextRedY] == 'O' && arr[nextBlueX][nextBlueY] != 'O') {
                                System.out.println(num);
                                return;
                            }
                            nextRedX -= move[0][i];
                            nextRedY -= move[1][i];
                        }
                    } else if(i==1){
                        if(nextRedX > nextBlueX) {
                            while (clone[nextRedX][nextRedY] == '.' || clone[nextRedX][nextRedY] == 'R') {
                                nextRedX += move[0][i];
                                nextRedY += move[1][i];
                            }
                            if(arr[nextRedX][nextRedY] == 'O' && arr[nextBlueX][nextBlueY] != 'O') {
                                System.out.println(num);
                                return;
                            }
                            nextRedX -= move[0][i];
                            nextRedY -= move[1][i];
                            clone[nextRedX][nextRedY] = 'R';
                            clone[redPoll.x][redPoll.y] = '.';
                            while (clone[nextBlueX][nextBlueY] == '.' || clone[nextBlueX][nextBlueY] == 'B') {
                                nextBlueX += move[0][i];
                                nextBlueY += move[1][i];
                            }
                            nextBlueX -= move[0][i];
                            nextBlueY -= move[1][i];
                        } else {
                            while (clone[nextBlueX][nextBlueY] == '.' || clone[nextBlueX][nextBlueY] == 'B') {
                                nextBlueX += move[0][i];
                                nextBlueY += move[1][i];
                            }
                            nextBlueX -= move[0][i];
                            nextBlueY -= move[1][i];
                            clone[nextBlueX][nextBlueY] = 'B';
                            clone[bluePoll.x][bluePoll.y] = '.';
                            while (clone[nextRedX][nextRedY] == '.' || clone[nextRedX][nextRedY] == 'R') {
                                nextRedX += move[0][i];
                                nextRedY += move[1][i];
                            }
                            if(arr[nextRedX][nextRedY] == 'O' && arr[nextBlueX][nextBlueY] != 'O') {
                                System.out.println(num);
                                return;
                            }
                            nextRedX -= move[0][i];
                            nextRedY -= move[1][i];
                        }
                    } else if(i==2) {
                        if(nextRedX < nextBlueX) {
                            while (clone[nextRedX][nextRedY] == '.' || clone[nextRedX][nextRedY] == 'R') {
                                nextRedX += move[0][i];
                                nextRedY += move[1][i];
                            }
                            if(arr[nextRedX][nextRedY] == 'O' && arr[nextBlueX][nextBlueY] != 'O') {
                                System.out.println(num);
                                return;
                            }
                            nextRedX -= move[0][i];
                            nextRedY -= move[1][i];
                            clone[nextRedX][nextRedY] = 'R';
                            clone[redPoll.x][redPoll.y] = '.';
                            while (clone[nextBlueX][nextBlueY] == '.' || clone[nextBlueX][nextBlueY] == 'B') {
                                nextBlueX += move[0][i];
                                nextBlueY += move[1][i];
                            }
                            nextBlueX -= move[0][i];
                            nextBlueY -= move[1][i];
                        } else {
                            while (clone[nextBlueX][nextBlueY] == '.' || clone[nextBlueX][nextBlueY] == 'B') {
                                nextBlueX += move[0][i];
                                nextBlueY += move[1][i];
                            }
                            nextBlueX -= move[0][i];
                            nextBlueY -= move[1][i];
                            clone[nextBlueX][nextBlueY] = 'B';
                            clone[bluePoll.x][bluePoll.y] = '.';
                            while (clone[nextRedX][nextRedY] == '.' || clone[nextRedX][nextRedY] == 'R') {
                                nextRedX += move[0][i];
                                nextRedY += move[1][i];
                            }
                            if(arr[nextRedX][nextRedY] == 'O' && arr[nextBlueX][nextBlueY] != 'O') {
                                System.out.println(num);
                                return;
                            }
                            nextRedX -= move[0][i];
                            nextRedY -= move[1][i];
                        }
                    } else {
                        if(nextRedX > nextBlueX) {
                            while (clone[nextRedX][nextRedY] == '.' || clone[nextRedX][nextRedY] == 'R') {
                                nextRedX += move[0][i];
                                nextRedY += move[1][i];
                            }
                            if(arr[nextRedX][nextRedY] == 'O' && arr[nextBlueX][nextBlueY] != 'O') {
                                System.out.println(num);
                                return;
                            }
                            nextRedX -= move[0][i];
                            nextRedY -= move[1][i];
                            clone[nextRedX][nextRedY] = 'R';
                            clone[redPoll.x][redPoll.y] = '.';
                            while (clone[nextBlueX][nextBlueY] == '.' || clone[nextBlueX][nextBlueY] == 'B') {
                                nextBlueX += move[0][i];
                                nextBlueY += move[1][i];
                            }
                            nextBlueX -= move[0][i];
                            nextBlueY -= move[1][i];
                        } else {
                            while (clone[nextBlueX][nextBlueY] == '.' || clone[nextBlueX][nextBlueY] == 'B') {
                                nextBlueX += move[0][i];
                                nextBlueY += move[1][i];
                            }
                            nextBlueX -= move[0][i];
                            nextBlueY -= move[1][i];
                            clone[nextBlueX][nextBlueY] = 'B';
                            clone[bluePoll.x][bluePoll.y] = '.';
                            while (clone[nextRedX][nextRedY] == '.' || clone[nextRedX][nextRedY] == 'R') {
                                nextRedX += move[0][i];
                                nextRedY += move[1][i];
                            }
                            if(arr[nextRedX][nextRedY] == 'O' && arr[nextBlueX][nextBlueY] != 'O') {
                                System.out.println(num);
                                return;
                            }
                            nextRedX -= move[0][i];
                            nextRedY -= move[1][i];
                        }
                    }
                    // 다시 한칸 뒤로 온다. #으로 이루어진 벽이 있기 때문에 범위를 벗어날 일은 없다.
//                    nextRedX -= move[0][i]; nextBlueX -= move[0][i];
//                    nextRedY -= move[1][i]; nextBlueY -= move[1][i];

                    if(!redFlag[nextRedX][nextRedY] && !blueFlag[nextBlueX][nextBlueY] && arr[nextBlueX][nextBlueY] != 'O') {
                        redFlag[nextRedX][nextRedY] = true;
                        blueFlag[nextBlueX][nextBlueY] = true;
                        redQueue.offer(new Node(nextRedX, nextRedY));
                        blueQueue.offer(new Node(nextBlueX, nextBlueY));
                    }
                }
            }
            num++;
        }
        System.out.println(-1);
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
