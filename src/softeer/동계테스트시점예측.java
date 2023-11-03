package softeer;

import java.io.*;
import java.util.*;
public class 동계테스트시점예측 {
    public static void main(String[] args) throws IOException{

        int n,m;
        int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int iceNumber = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int k=0; k<m; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
                if(arr[i][k] == 1) iceNumber++;
            }
        }
        // 입력 끝
        Queue<Node> queue = new LinkedList<>();
        // flag 배열은 방문 횟수를 나타낸다.
        int[][] flag;
        int time = 0;
        while(iceNumber > 0) {
            flag = new int[n][m];
            for(int i=0; i<n; i++) {
                for(int k=0; k<m; k++) {
                    if(arr[i][k] == 1) {
                        // dfs 시작
                        queue.offer(new Node(0, 0));
                        flag[i][k] = 1;
                        while(queue.isEmpty()) {
                            Node poll = queue.poll();
                            for(int j=0; j<4; j++) {
                                int nextX = poll.x + move[0][j];
                                int nextY = poll.y + move[1][j];
                                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                                if(arr[nextX][nextY] == 1) {
                                    flag[nextX][nextY]++;
                                } else if(flag[nextX][nextY] == 0){
                                    flag[nextX][nextY] = 1;
                                    queue.offer(new Node(nextX, nextY));
                                }
                            }
                        }

                        for(int ii=0; ii<n; ii++) {
                            for(int kk=0; kk<m; kk++) {
                                if(flag[ii][kk] >= 2) {
                                    // 얼음이 녹았음을 확인하는 변수에 체크하고, 얼음을 제거
                                    iceNumber--;
                                    arr[ii][kk] = 0;
                                }
                            }
                        }
                    }
                    if(iceNumber == 0) break;
                    time++;
                }
            }
        }
        System.out.println(time);
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
