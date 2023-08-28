package programmers_real.level2.escape_from_maze;

import java.util.LinkedList;
import java.util.Queue;

public class EscapeFromMaze {

    public static void main(String[] args) {
        String[] arr = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
//        String[] arr = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
        int solution = new EscapeFromMazeSolution().solution(arr);
        System.out.println(solution);
    }
}

class EscapeFromMazeSolution {

    int answer = 0;
    char[][] map;
    boolean[][] flag;
    int[][] move = {{1,-1,0,0}, {0,0,-1,1}};
    int startX, startY, endX, endY, leverX, leverY;
    final char START = 'S', LEVER = 'L', END = 'E', BORDER = 'B', WALL = 'X';
    public int solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        flag = new boolean[maps.length][maps[0].length()];

        for(int i=0; i<maps.length; i++) {
            for(int k=0; k<maps[0].length(); k++) {
                map[i][k] = maps[i].charAt(k);
                if(map[i][k] == START) {
                    startX = i;
                    startY = k;
                }
                if(map[i][k] == LEVER) {
                    leverX = i;
                    leverY = k;
                }
                if(map[i][k] == END) {
                    endX = i;
                    endY = k;
                }
            }
        }
        // 시작점 -> 레버 최단거리
        // 레버 -> 종료점 최단거리

        // 레버를 지나지 않아도 된다 =>

        int bfs = bfs(startX, startY, leverX, leverY);
        if(bfs != -1) {
            answer += bfs;
            flag = new boolean[maps.length][maps[0].length()];
            int result = bfs(leverX, leverY, endX, endY);
            if(result == -1) {
                answer = -1;
            } else {
                answer += result;
            }
        } else {
            answer = bfs;
        }
        return answer;
    }

    int bfs(int sx, int sy, int ex, int ey) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sx, sy, 0));
        while(!queue.isEmpty()) {
            Node poll = queue.poll();

            if(poll.x == ex && poll.y == ey)
                return poll.value;

            for(int i=0; i<4; i++) {
                int nextX = poll.x + move[0][i];
                int nextY = poll.y + move[1][i];
                if(nextX >= map.length || nextX < 0 || nextY >= map[0].length || nextY < 0) {
                    continue;
                }
                if(!flag[nextX][nextY] && map[nextX][nextY] != WALL) {
                    flag[nextX][nextY] = true;
                    queue.add(new Node(nextX, nextY, poll.value + 1));
                }
            }
        }
        return -1;
    }

    class Node {
        int x, y, value;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
