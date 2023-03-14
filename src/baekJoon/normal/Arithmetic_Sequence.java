package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 1065번
public class Arithmetic_Sequence {
    static int[] arr = new int[4];
    static int TotalCount = 99;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Input = Integer.parseInt(br.readLine());
        if(Input < 100){
            System.out.println(Input);
            return;
        }
        else{
            int gap = 0;
            int temp = 0;
            for(; Input > 100; Input--){
                temp = Input;
                arr[0] = temp/100;
                temp = temp % 100;
                arr[1] = temp/10;
                temp = temp % 10;
                arr[2] = temp/1;

                gap = arr[0] - arr[1];
                if(arr[1] - arr[2] == gap)
                    TotalCount++;
            }
        }
        System.out.println(TotalCount);
    }
}
