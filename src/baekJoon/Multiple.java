package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1629
public class Multiple {
    static int A,B,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        System.out.println(Solve(A, B));
    }
    static long Solve(long A, long exponent) {
        if(exponent == 1)
            return A % C;

        long tempA = Solve(A, exponent / 2);

        if(tempA % 2 == 1) {
            return (tempA * tempA % C) * A % C;
        }
        else
            return tempA * tempA % C;
    }

}
