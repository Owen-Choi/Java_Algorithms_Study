package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10819
public class Making_Maximum_Gap {
    static int N;
    static int[] values;
    static boolean[] flags;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        values = new int[N];
        flags = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++) {
            flags[i] = true;
            recur(0, values[i], 0);
            flags[i] = false;
        }
        System.out.println(result);
    }

    static void recur(int depth, int pre, int total) {
        if(depth == N - 1) {
            result = Math.max(result, total);
            return;
        }
        for(int i=0; i<N; i++) {
            if(!flags[i]) {
                flags[i] = true;
                total += Math.abs(pre - values[i]);
                depth++;
                recur(depth, values[i], total);
                flags[i] = false;
            }
        }
    }

//    static void show() {
//        for(int i=0; i<N; i++) {
//            System.out.print(flags[i] + " ");
//        }
//        System.out.println();
//    }
}
