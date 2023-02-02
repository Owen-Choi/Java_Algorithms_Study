package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 18126 너구리 구구
public class Raccoon_99 {
    static int N;
    static int[][] values;
    static boolean[] flags;
    static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        values = new int[N][N];
        flags = new boolean[N];
        // 입구는 1번
        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            values[A-1][B-1] = value;
            values[B-1][A-1] = value;
        }

        flags[0] = true;
        recur(0, new ArrayList<>());
        System.out.println(result);
    }

    static void recur(int index, ArrayList<Integer> list) {
        boolean f = false;
        for(int i=1; i<N; i++) {
            if(values[index][i] != 0 && !flags[i]) {
                flags[i] = true;
                list.add(values[index][i]);
                recur(i, list);
                list.remove(list.size() - 1);
                flags[i] = false;
                f = true;
            }
        }
        if(!f) {
            result = Math.max(result, calc(list));
        }
    }

    static long calc(ArrayList<Integer> list) {
        long sum = 0;
        for(int i=0; i<list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
