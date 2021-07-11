package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11726번
public class TwoXN_Tiling {
    static int input;
    static int TotalNum = 0;
    static boolean[] flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = Integer.parseInt(br.readLine());
        flag = new boolean[input];
        recur(0);
        System.out.println(TotalNum % 10007);
    }

    static void recur(int totalWidth){
        int TempWidth = 0;
        if(totalWidth >= input) {
            if(totalWidth == input) {
                TotalNum++;
            }
            return;
        }
        recur(++totalWidth);
        TempWidth = totalWidth += 2;
        recur(TempWidth);
    }
}
