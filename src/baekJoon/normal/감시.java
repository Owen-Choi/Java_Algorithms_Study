package baekJoon.normal;

import java.io.*;
import java.util.*;

public class 감시 {

    static Node[] cctvs;

    static int[][] arr;
    static int count, n, m;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        // cctv 방향을 돌리는 모든 경우의 수를 구하고, 이 경우의 수 각각에서 감시 영역을 마크한 뒤 사각지대의 수를 센다.
        // 입력 케이스의 최대 크기가 적어서 가능한 전형적인 브루트 포스 문제.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        count = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<m; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
                if(arr[i][k] != 0 && arr[i][k] != 6) {
                    count++;
                }
            }
        }
        // 재귀에서 모든 경우의 수를 따질 배열 선언
        cctvs = new Node[count];
        count = 0;
        for(int i=0; i<n; i++) {
            for(int k=0; k<m; k++) {
                if(arr[i][k] != 0 && arr[i][k] != 6) {
                    // 북쪽으로 설정
                    cctvs[count++] = new Node(i,k,arr[i][k]);
                }
            }
        }
        dfs(0);
        System.out.println(result + count);
    }

    static void dfs(int depth) {
        if(depth == count) {
            result = Math.max(result, monitor());
            return;
        }
        for(int i=1; i<=4; i++) {
            if(i + cctvs[depth].type <= 5) {
                cctvs[depth].type += i;
                dfs(depth + 1);
                cctvs[depth].type -= i;
            }
        }
        dfs(depth + 1);
    }

    static int monitor() {
        for(int i=0; i<count; i++) {

        }

        int[][] dupl = new int[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++) {
            dupl[i] = arr[i].clone();
        }

        return 1;
    }

    static int map() {
        int[][] clone = arr.clone();
        int count = 0;
        for(int i=0; i<cctvs.length; i++) {
            int x = cctvs[i].x;
            int y = cctvs[i].y;
            if(cctvs[i].type == 1) {
                // 오른쪽
                moveRight(clone, x, y);
            } else if(cctvs[i].type == 2) {
                // 왼쪽, 오른쪽
                moveRight(clone, x, y);
                moveLeft(clone, x, y);
            } else if(cctvs[i].type == 3) {
                // 위쪽, 오른쪽
                moveUp(clone, x, y);
                moveRight(clone, x, y);
            } else if(cctvs[i].type == 4) {
                // 위쪽, 오른쪽, 왼쪽
                moveUp(clone, x, y);
                moveRight(clone, x, y);
                moveLeft(clone, x, y);
            } else {
                // 사방
                moveUp(clone, x, y);
                moveRight(clone, x, y);
                moveLeft(clone, x, y);
                moveDown(clone, x, y);
            }
        }
        for(int i=0; i<n; i++) {
            for(int k=0; k<m; k++) {
                if(clone[i][k] == 0) {

                }
            }
        }
        return count;
    }

    static void moveRight(int[][] clone, int x, int y) {
        while(++x < m && clone[x][y] != 6) {
            if(clone[x][y] == 0) {
                clone[x][y] = -1;
            }
        }
    }

    static void moveLeft(int[][] clone, int x, int y) {
        while(--x >=0 && clone[x][y] != 6) {
            if(clone[x][y] == 0) {
                clone[x][y] = -1;
            }
        }
    }

    static void moveUp(int[][] clone, int x, int y) {
        while(--y >= 0 && clone[x][y] != 6) {
            if(clone[x][y] == 0) {
                clone[x][y] = -1;
            }
        }
    }

    static void moveDown(int[][] clone, int x, int y) {
        while(++y < n && clone[x][y] != 6) {
            if(clone[x][y] == 0) {
                clone[x][y] = -1;
            }
        }
    }

    static class Node {
        int x;
        int y;
        int type;
        // 처음 회전값은 1, 북쪽이라고 가정하겠다.
        // 이후 이 값을 2,3,4, 각각 동, 남, 서로 회전시키며 모든 경우를 따져보겠다.

        Node (int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
