package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 2004번
public class Combination_Zero_Count {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int two = get_Two(N) - get_Two(N-M) - get_Two(M);
        int five = get_five(N) - get_five(N-M) - get_five(M);
        System.out.println(Math.min(two, five));
    }
    static int get_five(int num) {
        int result = 0;
        while(num >= 5) {
            result += num/5;
            num /= 5;
        }
        return result;
    }
    static int get_Two(int num) {
        int result = 0;
        while(num >= 2) {
            result += num/2;
            num /= 2;
        }
        return result;
    }
}
