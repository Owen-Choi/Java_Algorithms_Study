package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 9095번
public class Plus_1_2_3 {
    static int testCase;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        int temp;
        while(testCase > 0){
            temp = Integer.parseInt(br.readLine());
            System.out.println(recur(temp));
            testCase--;
        }
    }

    static int recur(int input){
        if(input == 3)
            return 4;
        if(input == 2)
            return 2;
        if(input == 1)
            return 1;

        return recur(input - 1) + recur(input - 2) + recur(input - 3);
    }
}
