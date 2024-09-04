package programmers.level3;

import java.util.*;

public class 퍼즐_조각_채우기_분석 {
    public static void main() {
        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};

    }

    // 1. 게임보드 배열과 테이블 배열이 처음에는 0, 1이 서로 반대로 되어 있는데, 헷갈리니까 이를 일치시켜준다.
    // 2. 게임보드의 빈 공간과 테이블의 블럭을 bfs를 이용해서 좌표값을 저장해줌.
    //  2-1. 이때 bfs는 찾는 모든 좌표를 0,0을 기준으로 만들어준다. (x, y를 빼준다.)
    // 3. 이렇게 좌표들의 리스트로 이루어진 도형들을 게임보드의 빈공간 리스트인 g, 테이블의 도형 리스트인 t에 각각 저장해준다.
    // 4. 이렇게 각각 저장이 됐다면, 이중 반복문을 돌면서 g와 t의 좌표를 비교하고, 일치하지 않는다면 돌려가며 모두 비교해본다.
    //  4-1. 근데 블럭을 회전하는 과정에서 정렬을 왜 해주지?
    //  4-2. 블럭을 회전하기 전에, 이미 이전에 맞춰서 boolean 값이 true거나 블럭 <-> 빈공간 간의 크기가 다르다면 생략.

    static class Solution {
        List<List<Point>> t = new ArrayList<>();
        List<List<Point>> g = new ArrayList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        public int solution(int[][] game_board, int[][] table) {
            int answer = 0;
            //규칙에 맞게 최대한 많은 퍼즐 조각을 채워 넣을 경우, 총 몇 칸을 채울 수 있는지 return

            int len = game_board.length;

            //game_board 0, 1 바꿔주기
            for(int i=0; i<len; i++){
                for(int j=0; j<len; j++){
                    if(game_board[i][j]==1){
                        game_board[i][j] = 0;
                    }
                    else game_board[i][j] = 1;
                }
            }

            boolean[][] visited_t = new boolean[len][len];
            boolean[][] visited_g = new boolean[len][len];

            for(int i=0; i<len; i++){
                for(int j=0; j<len; j++){
                    //table에서 블록 추출
                    if(table[i][j]==1 && !visited_t[i][j])
                        bfs(i, j, table, visited_t, t);

                    //game_board에서 빈공간 추출
                    if(game_board[i][j]==1 && !visited_g[i][j])
                        bfs(i, j, game_board, visited_g, g);
                }
            }

            //table의 블록과 board 빈 공간의 블록을 회전하면서 비교해주기
            answer = compareBlock(t, g, answer);

            return answer;
        }

        public int compareBlock(List<List<Point>> table, List<List<Point>> board, int answer){
            int table_size = table.size();
            int board_size = board.size();

            boolean[] visited = new boolean[board_size];

            for(int i=0; i<table_size; i++){
                for(int j=0; j<board_size; j++){
                    // 이미 일치해서 끼워맞춘 블럭이거나, 빈 공간의 수와 블럭의 수가 서로 다르다면 아무리 돌려도 맞을 수 없기 때문에 생략한다.
                    if(visited[j] || table.get(i).size() != board.get(j).size())
                        continue;
                    if(isRotate(table.get(i), board.get(j))){
                        visited[j] = true; //블록으로 채워짐
                        answer += board.get(j).size();
                        break;
                    }

                }
            }

            return answer;
        }

        public boolean isRotate(List<Point> table, List<Point> board){
            //오름차순 정렬
            Collections.sort(board);

            //90도씩 회전시켜보기. 0, 90, 180, 270
            for(int i=0; i<4; i++){
                //오름차순 정렬. table은 회전할때마다 다시 정렬해줌.
                Collections.sort(table);

                int curr_x = table.get(0).x;
                int curr_y = table.get(0).y;

                //회전하면서 좌표가 바뀌기 때문에, 다시 (0,0) 기준으로 세팅
                for(int j=0; j<table.size(); j++){
                    table.get(j).x -= curr_x;
                    table.get(j).y -= curr_y;
                }

                boolean check = true;
                //좌표 비교
                for(int j=0; j<board.size(); j++){
                    if(board.get(j).x != table.get(j).x || board.get(j).y != table.get(j).y){
                        check = false;
                        break;
                    }
                }

                if(check){
                    return true;
                }
                else{
                    //90도 회전시키기. x, y -> y, -x
                    for(int j=0; j<table.size(); j++){
                        int temp = table.get(j).x;
                        table.get(j).x = table.get(j).y;
                        table.get(j).y = -temp;
                    }
                }
            }

            return false;
        }

        public void bfs(int x, int y, int[][] board, boolean[][] visited, List<List<Point>> list){

            visited[x][y] = true;

            Queue<Point> q = new LinkedList<>();
            q.add(new Point(x, y));

            List<Point> sub_list = new ArrayList<>();
            sub_list.add(new Point(0, 0)); //(0,0) 기준으로 넣어줌

            while(!q.isEmpty()){
                Point p = q.poll();

                for(int i=0; i<4; i++){
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if(nx<0 || ny<0 || nx>=board.length || ny>=board.length) continue;

                    if(!visited[nx][ny] && board[nx][ny]==1){
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny));
                        sub_list.add(new Point(nx-x, ny-y)); //(0, 0) 기준으로 넣기 때문에
                    }
                }
            }

            list.add(sub_list);
        }

        static class Point implements Comparable<Point>{
            int x, y;
            Point(int x, int y){
                this.x = x;
                this.y = y;
            }

            public int compareTo(Point o){
                int res = Integer.compare(this.x, o.x);
                if(res==0){
                    res = Integer.compare(this.y, o.y);
                }
                return res;
            }
        }
    }
}
