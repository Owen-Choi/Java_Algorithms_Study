package programmers.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KEA {
    static int K, N;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        list = new int[K];
        long max = 0;
        for(int i=0; i<K; i++) {
            list[i] = Integer.parseInt(br.readLine());
            max = Math.max(list[i], max);
        }
        long start = 1L;
        long end = max;
        long count;
        while(start<=end) {
            long mid = (start + end) / 2;
            count = 0;
            for(int i=0; i<K; i++) {
                count += list[i] / mid;
            }
            if(count >= N) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}
