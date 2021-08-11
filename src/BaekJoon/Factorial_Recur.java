package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 10872번
public class Factorial_Recur {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(recur(N));
    }
    static long recur(int num){
        if(num == 0)
            return 1;
        else
            return num * recur(num - 1);
    }
}
