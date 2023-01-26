package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 1300번
public class The_Kth_Number {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        System.out.println(binary());
    }
    static long binary() {
        long left = 1, right = K;
        long mid, result;
        long temp = -1;
        while(left < right) {
            result = 0;
            mid = (left + right) / 2;
            for(int i=1; i<=N; i++)
                result += Math.min(mid/i, N);
            if(result >= K) {
                temp = mid;
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }
        return temp;
    }
}
