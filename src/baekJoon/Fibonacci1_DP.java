package baekJoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 24416
public class Fibonacci1_DP {
    static int N;
    static int[] cache;
    static int dpCount = 0;
    static int recursiveCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cache = new int[N];
        cache[0] = cache[1] = 1;

        fib(N - 1);
        dp();
        System.out.println(recursiveCount + " " + dpCount);
    }

    static int fib(int n) {
        if(n == 0 || n == 1) {
            recursiveCount++;
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    static void dp() {
        for(int i=2; i<N; i++) {
            dpCount++;
            cache[i] = cache[i-1] + cache[i-2];
        }
    }
}
