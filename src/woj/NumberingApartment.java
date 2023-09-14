package woj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class NumberingApartment {
    static List<Integer> list = new ArrayList<>();
    static int[][] map;
    static boolean[][] flag;
    static int max = 0;
    static int size;
    static int[][] move = {{-1,1,0,0}, {0,0,-1,1}};
    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        size = n;
        map = new int[n][n];
        flag = new boolean[n][n];
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            for(int k=0; k<n; k++) {
                map[i][k] = input.charAt(k) - '0';
            }
        }

        for(int i=0; i<n; i++) {
            for(int k=0; k<n; k++) {
                if(map[i][k] == 1 && !flag[i][k]) {
                    dfs(i, k);
                    list.add(max);
                    max = 0;
                }
            }
        }

        if(!list.isEmpty()) {
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            System.out.println(list.size());
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }

    }

    static void dfs(int x, int y) {
        flag[x][y] = true;
        max++;
        for(int i=0; i<4; i++) {
            int nextX = x + move[0][i];
            int nextY = y + move[1][i];
            if(nextX < 0 || nextX >= size || nextY < 0 || nextY >= size) {
                continue;
            }
            if(map[nextX][nextY] == 1 && !flag[nextX][nextY])
                dfs(nextX, nextY);
        }
    }
}

