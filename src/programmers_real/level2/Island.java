package programmers_real.level2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// level2 연습문제, 무인도
public class Island {

    public static void main(String[] args) throws IOException {
        String[] maps = new String[4];
        maps[0] = "X591X";
        maps[1] = "X1X5X";
        maps[2] = "X231X";
        maps[3] = "1XXX1";

        Island island = new Island();
        Solution solution = island.new Solution();
        int[] result = solution.solution(maps);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    class Solution {

        char[][] map;
        List<Integer> list = new ArrayList<>();

        int maxValue = 0;

        boolean[][] check;
        // 상하좌우 델타값 미리 설정
        int[][] move = {{-1, 0}, {1, 0}, {0,-1}, {0, 1}};
        int mx, my;
        public int[] solution(String[] maps) {
            map = new char[maps.length][maps[0].length()];
            check = new boolean[maps.length][maps[0].length()];
            for(int i=0; i<maps.length; i++) {
                map[i] = maps[i].toCharArray();
            }

            for(int i=0; i<map.length; i++) {
                for(int k=0; k<map[i].length; k++) {
                    if(map[i][k] != 'X' && !check[i][k]) {
                        check[i][k] = true;
                        recur(i,k,map[i][k] - '0');
                        list.add(maxValue);
                        maxValue = 0;
                    }
                }
            }

            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });

            if(list.size() == 0) {
                int [] answer = new int[1];
                answer[0] = -1;
                return answer;
            } else {
                int[] answer = new int[list.size()];
                int counter = 0;
                for (Integer integer : list) {
                    answer[counter++] = integer;
                }
                return answer;
            }
        }

        private void recur(int x, int y, int value) {

            maxValue += value;

            for(int m=0; m<4; m++) {
                mx = x + move[m][0];
                my = y + move[m][1];

                if(mx >= 0 && mx < map.length && my >= 0 && my < map[x].length) {
                    if(!check[mx][my] && map[mx][my] != 'X') {
                        check[mx][my] = true;
                        recur(mx, my, map[mx][my] - '0');
                    }
                }
            }
        }
    }
}
