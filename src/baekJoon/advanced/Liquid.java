package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2467, 용액, 골드5
public class Liquid {
    static int N;
    static int[] liquids;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        liquids = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }

        // 이분탐색, 무조건 이분탐색
        int left = 0;
        int right = N-1;
        while(left < right) {

        }
    }
}
