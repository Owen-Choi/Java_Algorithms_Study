package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 1676번
public class Factorial_Zero_Count {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int count = 0;
        while(N >= 5) {
            count += N/5;
            N /= 5;
        }
        System.out.println(count);
    }
}
