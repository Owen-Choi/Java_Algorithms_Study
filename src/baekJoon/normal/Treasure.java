package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Treasure {
    static int N;
    static Integer[] A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new Integer[N];
        B = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B);
        int result = 0;
        for(int i=0; i<N; i++) {
            result += A[i] * B[i];
        }
        System.out.println(result);
    }
}
