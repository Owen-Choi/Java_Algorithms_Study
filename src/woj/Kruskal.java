package woj;

import java.util.*;

public class Kruskal {
    static int N = 7, M = 11;
    static int[][] arr = new int[M][3];
    static int[] parent = new int[N];
    public static void main(String[] args) {
        arr[0][0] = 1;  arr[0][1] = 7; arr[0][2] = 12;
        arr[1][0] = 1;  arr[1][1] = 4; arr[1][2] = 28;
        arr[2][0] = 1;  arr[2][1] = 2; arr[2][2] = 67;
        arr[3][0] = 1;  arr[3][1] = 5; arr[3][2] = 17;
        arr[4][0] = 2;  arr[4][1] = 4; arr[4][2] = 24;
        arr[5][0] = 2;  arr[5][1] = 5; arr[5][2] = 62;
        arr[6][0] = 3;  arr[6][1] = 5; arr[6][2] = 20;
        arr[7][0] = 3;  arr[7][1] = 6; arr[7][2] = 37;
        arr[8][0] = 4;  arr[8][1] = 7; arr[8][2] = 13;
        arr[9][0] = 5;  arr[9][1] = 6; arr[9][2] = 45;
        arr[10][0] = 5;  arr[10][1] = 7; arr[10][2] = 73;

        for(int i=0; i<N; i++) {
            parent[i] = i;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int result = 0;
        for(int i=0; i<arr.length; i++) {
            if(!isCycle(arr[i][0] - 1, arr[i][1] - 1)) {
                result += arr[i][2];
                unionParent(arr[i][0] - 1, arr[i][1] - 1);
            }
        }
        System.out.println(result);
    }

    static boolean isCycle(int a, int b) {
        int aParent = findParent(a);
        int bParent = findParent(b);
        return aParent == bParent;
    }

    static int findParent(int a) {
        if(parent[a] == a) return a;
        return parent[a] = findParent(parent[a]);
    }

    static void unionParent(int a, int b) {
        int aParent = findParent(a);
        int bParent = findParent(b);
        if(aParent > bParent) {
            parent[aParent] = bParent;
        } else {
            parent[bParent] = aParent;
        }
    }
}
