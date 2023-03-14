package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class The_Sum_Of_Num {
    static long Num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Num = Long.parseLong(br.readLine());
        System.out.println(FindNuM());
    }
    static int FindNuM() {
        int i = 1;
        while(Num >= i)
            Num -= i++;
        return i-1;
    }
}
