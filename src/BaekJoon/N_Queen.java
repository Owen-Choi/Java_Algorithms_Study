package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen {
    static int[] arr;
    static boolean[] exist;
    static boolean[] right_exist;
    static boolean[] left_exist;
    static int input;
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = Integer.parseInt(br.readLine());
        arr = new int[input];
        exist = new boolean[input];
        right_exist = new boolean[input * 2 - 1];
        left_exist = new boolean[input * 2 - 1];
        recur(0);
        System.out.println(num);
    }

    static void recur(int i){
        if(i == input) {
            num++;
            return;
        }

        for(int j=0; j<input; j++){
            arr[i] = j;
            if(check(i)){
                recur(i + 1);
            }
        }
    }

    static boolean check(int i){
        for(int k = 0; k<i; k++){
            if(arr[k] == arr[i])
                return false;
            else if(Math.abs(k - i) == Math.abs(arr[k] - arr[i]))
                return false;
        }
        return true;
    }
}
