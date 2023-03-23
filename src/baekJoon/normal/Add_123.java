package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Add_123 {
    static int testCase, n;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(testCase --> 0) {
            n = Integer.parseInt(br.readLine());
            recur(0);
            sb.append(result).append("\n");
            result = 0;
        }
        System.out.println(sb.toString());
    }

    public static void recur(int count) {
        if(count == n) {
            result++;
            return;
        } else if(count > n) {
            return;
        }

        recur(count + 1);
        recur(count + 2);
        recur(count + 3);

    }
}
