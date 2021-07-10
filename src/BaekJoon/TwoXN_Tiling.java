package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoXN_Tiling {
    static int input;
    static boolean flag[];
    static int TotalNum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = Integer.parseInt(br.readLine());
        flag = new boolean[input];
        recur(0, 0);
        System.out.println(TotalNum);
    }
    static void recur(int totalWidth, int i){
        if(totalWidth >= input) {
            if(totalWidth == input)
                TotalNum++;
            return;
        }

        for(int k = i; k < input; k++){
            if(flag[k])
                totalWidth++;
            else if(flag[k] == false) {
                totalWidth += 2;
            }


        }
    }
}
