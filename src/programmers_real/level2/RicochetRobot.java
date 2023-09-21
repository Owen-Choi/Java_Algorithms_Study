package programmers_real.level2;

import java.util.LinkedList;
import java.util.Queue;

public class RicochetRobot {
    public static void main(String[] args) {
//        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        String[] board = {".D.R", "....", ".G..", "...D"};
        System.out.println(new RicochetRobotSolution().solution(board));
    }
}

class RicochetRobotSolution {
    public int solution(String[] board) {
        int startX = 0, startY = 0, goalX = 0, goalY = 0;
        boolean[][] flag = new boolean[board.length][board[0].length()];
        char[][] map = new char[board.length][board[0].length()];
        for(int i=0; i< board.length; i++) {
            for(int k=0; k<board[i].length(); k++) {
                map[i][k] = board[i].charAt(k);
                if(board[i].charAt(k) == 'R') {
                    startX = i;
                    startY = k;
                }
                if(board[i].charAt(k) == 'G') {
                    goalX = i;
                    goalY = k;
                }
            }
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY, 0));
        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            if(poll.x == goalX && poll.y == goalY) {
                return poll.value;
            }
            flag[poll.x][poll.y] = true;
            for(int i=0; i<4; i++) {
                if(i == 0) {
                    // 위
                    int nextX = poll.x - 1;
                    while(nextX >= 0 && map[nextX][poll.y] != 'D') {
                        nextX--;
                    }
//                    if(nextX < 0) nextX++;
                    if(!flag[nextX + 1][poll.y])
                        queue.add(new Node(nextX + 1, poll.y, poll.value + 1));
                }

                if(i == 1) {
                    // 아래
                    int nextX = poll.x + 1;
                    while(nextX < map.length && map[nextX][poll.y] != 'D') {
                        nextX++;
                    }
//                    if(nextX == map.length) nextX--;
                    if(!flag[nextX - 1][poll.y])
                        queue.add(new Node(nextX - 1, poll.y, poll.value + 1));
                }

                if(i == 2) {
                    // 좌측
                    int nextY = poll.y - 1;
                    while(nextY >= 0 && map[poll.x][nextY] != 'D') {
                        nextY--;
                    }
//                    if(nextY < 0) nextY++;
                    if(!flag[poll.x][nextY + 1])
                        queue.add(new Node(poll.x, nextY + 1, poll.value + 1));
                }

                if(i == 3) {
                    // 우측
                    int nextY = poll.y + 1;
                    while(nextY < map[0].length && map[poll.x][nextY] != 'D') {
                        nextY++;
                    }
//                    if(nextY == map[0].length) nextY--;
                    if(!flag[poll.x][nextY - 1])
                        queue.add(new Node(poll.x, nextY - 1, poll.value + 1));
                }
            }
        }
        return -1;
    }

    class Node {
        int x;
        int y;
        int value;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
