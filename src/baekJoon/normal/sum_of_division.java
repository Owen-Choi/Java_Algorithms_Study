package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 2231번
public class sum_of_division {
    static int Input;
    static int Min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        for(int i = Input; i>=0; i--){
            calc(i);
        }
        if(Min == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(Min);
    }
    static void calc(int num){
        int OrgNum = num;
        int tempVal = OrgNum;
        while(num != 0){
            tempVal += num % 10;
            num /= 10;
        }
        if(tempVal == Input)
            Min = Math.min(Min, OrgNum);
    }
}
