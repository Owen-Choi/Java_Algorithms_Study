package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11726번
public class TwoXN_Tiling {
    static int input;
    static boolean flag[];
    static int TotalNum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = Integer.parseInt(br.readLine());
        flag = new boolean[input * 2];
        recur(0);
        System.out.println(TotalNum % 10007);
    }
    static void recur(int totalWidth){
        if(totalWidth >= input) {
            if(totalWidth == input)
                TotalNum++;
            return;
        }
        if(flag[totalWidth] == true){
            totalWidth++;
            recur(totalWidth);
        }
        else {
            totalWidth += 2;
            recur(totalWidth);
            flag[totalWidth] = true;
        }

    }
}
