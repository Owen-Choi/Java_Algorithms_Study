package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2579번
public class Climbing_Stairs {
    static int[] arr;
    static int[] Max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Input = Integer.parseInt(br.readLine());
        arr = new int[Input + 1];
        Max = new int[Input + 1];
        for(int i=1; i<=Input; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Max[0] = arr[0];
        Max[1] = arr[1];
        if(Input >= 2)
            Max[2] = arr[1] + arr[2];
        if(Input >= 3)
            Max[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
        for(int i=4; i<=Input; i++){
            Max[i] = Math.max(Max[i-2], Max[i-3] + arr[i-1]) + arr[i];
        }
        System.out.println(Max[Input]);
    }
}
