package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// 2981번
public class SpotCheck {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int GCD = arr[1] - arr[0];
        for(int i=2; i<N; i++) {
            GCD = recur(GCD, arr[i] - arr[i-1]);
        }
        for(int i=2; i<=GCD; i++) {
            if(GCD % i == 0)
                sb.append(i).append(' ');
        }
        System.out.println(sb);
    }
    static int recur(int a, int b) {
        if(b == 0)
            return a;
        return recur(b, a%b);
    }
}
