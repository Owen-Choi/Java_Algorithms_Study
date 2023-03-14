package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 10870번
public class Fibonacci_5_Recur {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(recur(N));
    }
    static int recur(int num){
        if(num == 0)
            return 0;
        if(num == 1)
            return 1;
        if(num == 2)
            return 1;
        else
            return recur(num - 1) + recur(num - 2);
    }
}
