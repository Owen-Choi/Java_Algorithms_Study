package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1463번
public class Make_Num_To_1 {
    static int input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(recur(input, 0));
    }
    static int recur(int num, int count){
        if(num < 2)
            return count;

        return Math.min(recur(num/2, count + 1 + num%2), recur(num/3, count + 1 + num%3));
    }
}
