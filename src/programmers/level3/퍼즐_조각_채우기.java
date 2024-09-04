package programmers.level3;

import java.util.*;

public class 퍼즐_조각_채우기 {
    public static void main(String[] args) {
//        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
//        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
        int[][] game_board = {{0,0,1,0,1,0,1,0,1,0,1,0,0,1,0,0,0,0}, {1,0,0,0,1,0,1,0,1,0,1,0,0,1,0,1,1,1},
                {0,1,1,1,0,0,1,0,1,0,0,1,1,0,1,0,0,0}, {0,0,0,0,1,1,0,0,1,1,0,1,0,0,1,0,0,0}, {0,1,1,1,0,0,1,1,1,1,0,1,1,1,0,1,1,1},
                {1,0,1,0,0,0,1,0,0,0,1,0,0,0,0,1,0,0}, {0,0,0,1,1,1,0,0,1,1,0,1,1,1,1,0,0,1}, {1,1,1,0,0,0,1,1,0,0,1,0,0,0,0,1,1,0},
                {0,0,1,0,1,1,1,0,0,1,0,1,1,1,1,0,0,0}, {1,1,0,1,1,0,1,1,1,1,0,1,0,0,0,1,1,1}, {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1,0,1,0},
                {1,1,1,1,0,1,1,1,1,1,0,1,0,1,0,0,1,0}, {0,0,1,0,0,0,1,0,0,0,1,0,1,0,1,1,0,0}, {1,0,1,1,0,1,1,0,0,0,1,0,0,0,1,0,0,1},
                {1,0,0,1,1,0,0,1,1,1,0,1,1,1,0,1,1,0}, {0,1,1,0,0,1,0,1,0,0,1,0,0,0,0,0,1,0}, {0,0,0,1,0,1,0,1,0,0,1,1,1,1,1,1,1,0},
                {0,1,0,1,1,0,0,1,0,1,0,0,0,0,0,0,1,0}};
        int[][] table = {{1,1,1,1,1,1,0,1,0,1,1,0,0,1,0,0,1,0}, {0,0,0,0,0,0,1,1,1,0,1,0,1,1,0,1,1,0}, {1,0,1,1,0,1,0,1,0,1,1,0,1,0,1,1,0,1},
                {1,1,0,1,1,1,0,1,0,1,0,1,1,0,1,0,0,1}, {1,1,1,0,0,0,1,0,1,0,1,0,0,1,0,0,1,1}, {0,0,0,1,1,1,0,1,1,1,0,1,1,0,1,0,0,0},
                {1,1,1,0,0,0,0,0,1,1,0,1,1,0,1,1,1,1}, {0,0,1,0,1,1,0,1,0,0,1,0,0,1,0,0,0,0}, {1,0,1,0,0,0,0,1,0,1,1,0,1,1,0,1,1,1},
                {1,0,1,0,1,1,1,1,0,1,1,0,0,0,1,1,1,0}, {1,1,0,1,0,0,0,0,1,0,0,1,1,1,0,0,0,0}, {0,0,1,1,1,1,0,1,1,0,1,0,0,0,1,1,0,1},
                {1,1,0,1,0,0,1,0,0,1,0,1,0,1,0,1,0,1}, {1,1,0,0,1,1,1,0,1,1,0,1,0,1,0,1,0,1}, {0,0,1,1,0,1,1,0,1,0,1,1,0,0,0,1,0,0},
                {1,1,1,0,1,0,0,1,0,1,1,0,0,1,0,1,0,1}, {0,0,0,0,1,0,1,1,1,0,0,1,0,1,1,0,1,1}, {0,1,1,1,1,0,0,1,0,0,1,1,0,1,0,0,1,1}};
        System.out.println(new Solution().solution(game_board, table));
    }

    static class Solution {
        static int gameN,gameM,tableN, tableM;
        static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
        static int solution(int[][] game_board, int[][] table) {

            int answer = 0;

            // 게임 보드 내의 빈 공간을 저장할 리스트List<>
            ArrayList<ArrayList<Node>> empty_list = new ArrayList<>();
            ArrayList<ArrayList<Node>> block_list = new ArrayList<>();

            // 게임 보드 반전 (게임 보드든 테이블이든 bfs에서 동일한 조건문으로 처리해주기 위함이다)
            gameN = game_board.length;
            gameM = game_board[0].length;
            tableN = table.length;
            tableM = table[0].length;
            for(int i=0; i<gameN; i++) {
                for(int k=0; k<gameM; k++) {
                    game_board[i][k] = game_board[i][k] == 1 ? 0 : 1;
                }
            }

            boolean[][] game_flag = new boolean[gameN][gameM];
            boolean[][] table_flag = new boolean[tableN][tableM];

            // 게임 보드 빈 공간 bfs
            for(int i=0; i<gameN; i++) {
                for(int k=0; k<gameM; k++) {
                    if(game_board[i][k] == 1 && !game_flag[i][k])
                        bfs(new Node(i, k), game_board, game_flag, empty_list);
                }
            }

            // 테이블 빈 공간 bfs
            for(int i=0; i<tableN; i++) {
                for(int k=0; k<tableM; k++) {
                    if(table[i][k] == 1 && !table_flag[i][k]) {
                        bfs(new Node(i,k), table, table_flag, block_list);
                    }
                }
            }

            // flag는 블록의 인덱스를 따라감. => 라고 해놓고 empty_list.size() 해서 런타임 에러를 두 번이나 맞음
            boolean[] flag = new boolean[block_list.size()];
            // 완성된 두 리스트를 비교
            for(int i=0; i<empty_list.size(); i++) {
                for(int k=0; k<block_list.size(); k++) {
                    if(flag[k] || empty_list.get(i).size() != block_list.get(k).size()) {
                        continue;
                    }
                    if(rotateCheck(empty_list.get(i), block_list.get(k))) {
                        flag[k] = true;
                        answer += block_list.get(k).size();
                        // 해당 빈 공간에는 블록이 할당되었기 때문에, 남은 블록들은 볼 필요 없다.
                        break;
                    }
                }
            }
            return answer;
        }

        static void bfs(Node startNode, int[][] arr, boolean[][] flag, ArrayList<ArrayList<Node>> list) {
            flag[startNode.x][startNode.y] = true;
            ArrayList<Node> element = new ArrayList<>();
            // TODO element.add(new Node(0,0)); 은 왜 필요한거지?
            // 아, startNode가 0,0, 즉 기준점으로 들어가게 되는 거구나.
            element.add(new Node(0,0));
            Queue<Node> queue = new LinkedList<>();
            // TODO : 잘 생각해보면 bfs마다 선언해서 사용할 필요가 없다.
            // boolean[][] flag = new boolean[n][m];
            queue.offer(startNode);
            while(!queue.isEmpty()) {
                Node poll = queue.poll();
                for(int i=0; i<4; i++) {
                    int nextX = poll.x + move[0][i];
                    int nextY = poll.y + move[1][i];
                    if(nextX < 0 || nextX >= arr.length || nextY < 0 || nextY >= arr[0].length) {
                        continue;
                    }
                    if(!flag[nextX][nextY] && arr[nextX][nextY] == 1) {
                        flag[nextX][nextY] = true;
                        queue.offer(new Node(nextX, nextY));
                        // 0,0을 기준으로 넣어줌.
                        // TODO poll이 기준이 아니다! startNode가 기준이다!!!!
                        // TODO element.add(new Node(nextX - poll.x, nextY - poll.y));
                        element.add(new Node(nextX - startNode.x, nextY - startNode.y));
                    }
                }
            }
            list.add(element);
        }

        static boolean rotateCheck(ArrayList<Node> empty, ArrayList<Node> block) {
            // 0도, 90도, 180도, 270도 순차대로 돌린다.
            // 분석코드에서는 정렬을 하던데, 정렬을 왜 하는거지? -> (0,0) 으로 만들고 싶으면 가장 작은 블록을 다른 블록에서 모두 빼주어야 한다.
            // 이때 가장 작은 블록을 가장 앞에 위치시키기 위해 정렬을 해주는 것이다.
            // 기억하자. 여기서 다루는 것은 빈 공간, 블록의 리스트가 아니라, 빈 공간 "하나", 블록 "하나"이다.
            Collections.sort(empty);
            for(int i=0; i<4; i++) {
                // 0도부터 시작되니 바로 비교를 먼저 해야 한다.
                // 회전하면 좌표에 변경이 생기니 다시 돌려야 함.
                Collections.sort(block);
                int pivotX = block.get(0).x;
                int pivotY = block.get(0).y;
                // 상대좌표로 만들어 준 블록을 빈 공간과 비교해준다 : empty 리스트는 이미 0,0 기준 상대좌표이고,
                // block 좌표는 pivot 값을 빼줘서 상대좌표로 만들어주었다.

                boolean branch = true;
                for(int k=0; k<empty.size(); k++) {
                    if(empty.get(k).x != block.get(k).x - pivotX || empty.get(k).y != block.get(k).y - pivotY){
                        branch = false;
                        break;
                    }
                }
                if(branch) {
                    return branch;
                }
                // 90도 회전.
                // 여기서 우리는 회전한 좌표를 실제로 사용하는 것이 아니기 때문에, 값이 마이너스가 되어도 상관이 없다.
                // (x, y) -> (y, -x)
                for(int k=0; k<block.size(); k++) {
                    int temp = block.get(k).x;
                    block.get(k).x = block.get(k).y;
                    block.get(k).y = -temp;
                }
            }
            return false;
        }
    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if(this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
}
