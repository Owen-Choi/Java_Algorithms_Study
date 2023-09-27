package programmers_real.level2;

import java.util.LinkedList;
import java.util.Queue;

public class CovidDistance {
    public static void main(String[] args) {
        String [][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] solution = new CovidDistanceSolution().solution(places);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}

class CovidDistanceSolution {
    int[] answer;
    int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
    public int[] solution(String[][] places) {
        answer = new int[places.length];
        for(int i=0; i< places.length; i++) {
            answer[i] = checkDistance(places[i]);
        }
        return answer;
    }

    int checkDistance(String[] room) {
        // bfs 레벨 체크
        boolean[][] flag;
        int cnt = 0;
        Queue<Node> queue = new LinkedList<>();
        for(int i=0; i<room.length; i++) {
            for(int k=0; k<room[0].length(); k++) {
                if(room[i].charAt(k) == 'P') {
                    // 레벨 단위 bfs 시작
                    cnt = -1;
                    Node node = new Node(i, k);
                    // 배열을 새로 잡아주어야 함
                    flag = new boolean[room.length][room[0].length()];
                    flag[i][k] = true;
                    queue.offer(node);
                    while(!queue.isEmpty()) {
                        int size = queue.size();
                        cnt++;
                        for(int j=0; j<size; j++) {
                            Node poll = queue.poll();
                            flag[poll.x][poll.y] = true;
                            if(room[poll.x].charAt(poll.y) == 'P' && cnt != 0) {
                                if(cnt <= 2)
                                    return 0;
                                else continue;
                            }
                            for(int m = 0; m<4; m++) {
                                int nextX = poll.x + move[0][m];
                                int nextY = poll.y + move[1][m];
                                if(nextX < 0 || nextX >= room.length || nextY < 0 || nextY >= room[0].length()) {
                                    continue;
                                }
                                if(room[nextX].charAt(nextY) != 'X' && !flag[nextX][nextY]) {
                                    queue.offer(new Node(nextX, nextY));
                                }
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}