package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2579번
public class Climbing_Stairs {
    static int Input;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Input = Integer.parseInt(br.readLine());
        arr = new int[Input + 3];
        for(int i=1; i<=Input; i++)
            arr[i] = Integer.parseInt(br.readLine());

        System.out.println(recur(0, 0, 0));
    }

    static int recur(int index, int totalCount, int stepCount){

        if(index >= Input){
            if(index == Input)
                return totalCount;
            else
                return 0;
        }

        else if(stepCount == 2) {
            int TemptotalCount = totalCount + arr[index + 2];
            return recur(index + 2, TemptotalCount, 1);
        }
        else {
            int Temp1 = totalCount + arr[index + 1];
            int Temp2 = totalCount + arr[index + 2];
            return Math.max(recur(index + 1, Temp1, ++stepCount), recur(index + 2, Temp2, 1));
        }
    }
}
