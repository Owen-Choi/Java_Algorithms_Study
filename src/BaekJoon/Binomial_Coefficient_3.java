package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Binomial_Coefficient_3 {
    static int N, K;
    static final int DIV = 1000000007;
    static Integer[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new Integer[N + 1][K + 1];
        System.out.println(recur(N, K));
    }
    static int recur(int n, int r) {
        if(n == r || r == 0)
            return 1;

        if(arr[n][r] == null) {
            arr[n][r] = (recur(n-1, r-1) + recur(n-1, r)) % DIV;
        }
        return arr[n][r];
    }
}
