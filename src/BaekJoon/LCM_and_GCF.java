package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 2609번
public class LCM_and_GCF {
    static int Num1, Num2;
    static int[] arr = new int[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Num1 = Integer.parseInt(st.nextToken());
        Num2 = Integer.parseInt(st.nextToken());
        int temp = recur(Num1, Num2);
        System.out.println(temp);
        System.out.println(Num1 * Num2 / temp);
    }
    static int recur(int N1, int N2) {
        if(N2 == 0)
            return N1;
        return recur(N2, N1%N2);
    }
}
