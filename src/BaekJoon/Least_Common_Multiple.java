package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1934번
public class Least_Common_Multiple {
    static int TC;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int Num1, Num2;
        while(TC > 0) {
            TC--;
            st = new StringTokenizer(br.readLine()," ");
            Num1 = Integer.parseInt(st.nextToken());
            Num2 = Integer.parseInt(st.nextToken());
            sb.append(Num1 * Num2 /recur(Num1, Num2)).append('\n');
        }
        System.out.println(sb);
    }
    static int recur(int n1, int n2) {
        if(n2 == 0)
            return n1;

        return recur(n2, n1%n2);
    }
}
