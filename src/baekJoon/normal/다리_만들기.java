package baekJoon.normal;

import java.util.*;
import java.io.*;

// 먼저 섬을 나눠서 숫자로 구분한 다음, 각 섬에서 다른 섬으로 다시 BFS를 수행한다.
public class 다리_만들기 {
    static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input 입력부
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<n; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 구분
        // 반복문 돌면서 1을 만나고 방문하지 않은 곳이라면 BFS로 새롭게 수를 할당해준다.
        int count = 1;
        boolean[][] flag = new boolean[n][n];
        Queue<Node> queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int k=0; k<n; k++) {
                if(arr[i][k] != 0 && !flag[i][k]) {
                    flag[i][k] = true;
                    arr[i][k] = count;
                    // bfs 시작
                    queue.offer(new Node(i, k));
                    while(!queue.isEmpty()) {
                        Node poll = queue.poll();
                        for(int ii=0; ii<4; ii++) {
                            int nextX = poll.x + move[0][ii];
                            int nextY = poll.y + move[1][ii];
                            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n)
                                continue;
                            if(arr[nextX][nextY] != 0 && !flag[nextX][nextY]) {
                                arr[nextX][nextY] = count;
                                flag[nextX][nextY] = true;
                                queue.offer(new Node(nextX, nextY));
                            }
                        }
                    }
                    count++;
                }
            }
        }


        // 다리 놓기
        // 반복문을 돌며 0이 아닌 부분은 모두 bfs를 수행한다.
        int tempValue = 0;
        int[][] bridge = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int k=0; k<n; k++) {
                if(arr[i][k] != 0) {
                    tempValue = arr[i][k];
                    // 먼저 bridge 배열 초기화
                    for(int ii=0; ii<n; ii++) {
                        Arrays.fill(bridge[ii], 0);
                    }
                    bridge[i][k] = -1;
                    queue.offer(new Node(i,k));
                    while(!queue.isEmpty()) {
                        Node poll = queue.poll();
                        for(int ii=0; ii<4; ii++) {
                            int nextX = poll.x + move[0][ii];
                            int nextY = poll.y + move[1][ii];
                            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n)
                                continue;
                            // 반대편을 찾았음. 큐를 비워주고 tempAnswer를 기록해준 뒤 루프 종료
                            if(arr[nextX][nextY] != 0 && arr[nextX][nextY] != tempValue) {
                                // 큐 지워주는 부분 유의
                                queue.clear();
                                answer = Math.min(answer, bridge[poll.x][poll.y] == -1 ? 0 : bridge[poll.x][poll.y]);
                                break;
                            }
                            if(arr[nextX][nextY] == 0 && bridge[nextX][nextY] == 0) {
                                bridge[nextX][nextY] = bridge[poll.x][poll.y] == -1 ? 1 : bridge[poll.x][poll.y] + 1;
                                // flag를 boolean 말고 int 배열로 새로 만든 다음, 얘로 카운트하겠다. 레벨 단위 큐를 쓰면 시간 초과 뜰 것 같음.
                                queue.offer(new Node(nextX, nextY));
                            }
                        }
                    }
                }
            }
        }

        System.out.println(answer);
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
