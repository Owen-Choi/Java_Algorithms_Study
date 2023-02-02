package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        recur(0, new ArrayList<>());
        System.out.println(result);
    }

    static void recur(int depth, ArrayList<Integer> list) {
        if(depth == N) {
            result = Math.max(result, calc(list));
            return;
        }
        for(int i=0; i<N; i++) {
            if(!flags[i]) {
                flags[i] = true;
                list.add(values[i]);
                recur(depth + 1, list);
                list.remove(list.size() - 1);
                flags[i] = false;
            }
        }
    }
    static int calc(ArrayList<Integer> list) {
        int resultSum = 0;
        for(int i=0; i<N - 1; i++) {
            resultSum += Math.abs(list.get(i) - list.get(i + 1));
        }
        return resultSum;
    }
}
