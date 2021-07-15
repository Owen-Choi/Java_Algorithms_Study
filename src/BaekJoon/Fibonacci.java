package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1003번
public class Fibonacci {
    static int Zero_Count = 0;
    static int One_Count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCase = Integer.parseInt(br.readLine());
        while(TestCase > 0){
            TestCase--;
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                System.out.println("1 0");
                continue;
            }
            else if(num == 1) {
                System.out.println("0 1");
                continue;
            }
            num = recur(num);
            System.out.println(Zero_Count + " " + One_Count);
            Zero_Count = One_Count = 0;
        }
    }
    static int recur(int index) {
        if (index == 3) {
            Zero_Count += 1;
            One_Count += 2;
            return -1;
        }
        if(index == 2) {
            Zero_Count += 1;
            One_Count += 1;
            return -1;
        }

        if(index == 4){
            Zero_Count += 2;
            One_Count += 3;
            return -1;
        }

        if(index == 5){
            Zero_Count += 3;
            One_Count += 5;
            return -1;
        }

        return recur(index - 1) + recur(index - 2);
    }
}
