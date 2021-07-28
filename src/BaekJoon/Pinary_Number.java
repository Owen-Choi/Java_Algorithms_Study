package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 2193번
public class Pinary_Number {
    static int Input;
    static Integer[] dp;
    static int Num = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        dp = new Integer[Input];
        /*dp[Input-1] = 0;
        if(Input > 1)
            dp[Input - 2] = 1;
        if(Input > 2)
            dp[Input - 3] = 2;*/
        recur(0, false);
        System.out.println(Num - 1);
    }
    static void recur(int Index, boolean pre) {
        if(Index == Input - 1)
            Num++;
        else{
            if(pre)
                recur(Index + 1, false);
            else{
                recur(Index + 1, true);
                recur(Index + 1, false);
            }

        }
    }
}
