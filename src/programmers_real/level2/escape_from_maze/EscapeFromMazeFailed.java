package programmers_real.level2.escape_from_maze;

public class EscapeFromMazeFailed {

    public static void main(String[] args) {

        String[] arr = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
//        String[] arr = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
        int solution = new EscapeFromMazeFailedSolution().solution(arr);
        if(solution == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(solution);
        }
    }
}


class EscapeFromMazeFailedSolution {
    char [][] map;
    boolean[][] flag;
    int startX, startY, endX, endY, leverX, leverY;
    final char START = 'S', LEVER = 'L', END = 'E', BORDER = 'B', WALL = 'X';

    int answer = Integer.MAX_VALUE;
    public int solution(String[] maps) {
        map = new char[maps.length + 2][maps[0].length() + 2];
        flag = new boolean[maps.length + 2][maps[0].length() + 2];
        int n = maps.length + 2,m = maps[0].length() + 2;
        // 테두리 부분엔 다른 문자를 넣어준다.
        for(int i=0; i<n; i++) {
            map[i][0] = map[i][m - 1] = BORDER;
        }
        for(int i=0; i<m; i++) {
            map[0][i] = map[n - 1][i] = BORDER;
        }
        // 2차원 문자 배열에 옮기면서 위치들을 저장해준다.
        for(int i=1; i<=maps.length; i++) {
            for(int k=1; k<=maps[0].length(); k++) {
                map[i][k] = maps[i - 1].charAt(k - 1);
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

        // 저장한 위치를 기반으로 백트래킹을 해준다.
        // recur(startX, startY, 0);
        // 재귀로 하지 말고, 다른 방법을 찾아보자.
        // 1. 레버까지의 최단거리 + 레버에서 탈출구까지의 최단거리
        // 2. 출발점에서 탈출구까지의 최단거리
        // 3. 둘 중에 더 작은거
        return answer;
    }

//    public void recur(int x, int y, int value) {
//        char current = map[x][y];
//
//        if(current == BORDER || current == WALL)
//            return;
//        // 목적지에 도달했다면 종료
//        if(current == END) {
//            answer = Math.min(value, answer);
//            return;
//        }
//        // 목적지에 도달하지 않았다면 탐색을 계속한다.
//                for(int k=0; k<4; k++) {
//                    int nextX = x + pos[0][k];
//                    int nextY = y + pos[1][k];
//                    if(!flag[nextX][nextY]) {
//                        flag[nextX][nextY] = true;
//                        recur(nextX, nextY, value + 1);
//                        flag[nextX][nextY] = false;
//                    }
//                }
//    }
}
