package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Traveling_Salesman_Problem_2 {
    static int N;
    static int[][] value;
    static int result = Integer.MAX_VALUE;
    static boolean[] flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        value = new int[N][N];
        flag = new boolean[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int k=0; k<N; k++) {
                value[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++) {
            recur(0, i, i, 0);
        }
        System.out.println(result);
    }
    static void recur(int count, int start, int current, int length) {
        if(current == start && length == N) {
                result = Math.min(result, count);
        } else {
            for(int i=0; i<N; i++) {
                if(!flag[i] && value[current][i] != 0) {
                    flag[i] = true;
                    recur(count + value[current][i], start, i, length + 1);
                    flag[i] = false;
                }
            }
        }
    }
}
