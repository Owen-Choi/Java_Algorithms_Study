package baekJoon.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mixing_Card {
    static int N;
    static int[] S, P, value, previous;
    // 처음 위치로 돌아왔을 경우 -1 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        P = new int[N];
        value = new int[N];
        previous = new int[N];
        StringTokenizer st;

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                P[i] = Integer.parseInt(st.nextToken());
                value[i] = i % 3;
            }
            st = new StringTokenizer(br.readLine());
            for(int v=0; v<N; v++) {
                S[v] = Integer.parseInt(st.nextToken());
            }

        boolean flag = false;
        for(int i=0; i<N; i++) {
            if(P[i] != value[i]) {
                flag = true;
                break;
            }
        }
        if(!flag) {
            System.out.println(0);
            System.exit(0);
        }
        int result = 0;
        while(true) {
            result++;
            mix();
            check(result);
        }

    }

    static void mix() {
        Arrays.fill(previous, 0);
        for(int i=0; i<N; i++) {
            previous[i] = value[S[i]];
        }
        for(int i=0; i<N; i++) {
            value[i] = previous[i];
        }
    }

    static void check(int count) {
        boolean flag = false;
        for(int i=0; i<N; i++) {
            if(value[i] != i % 3) {
                flag = true;
                break;
            }
        }

        if(!flag) {
            System.out.println(-1);
            System.exit(0);
        }

        for(int i=0; i<N; i++) {
            if(P[i] != value[i]) {
                return;
            }
        }
        System.out.println(count);
        System.exit(0);
    }
}
