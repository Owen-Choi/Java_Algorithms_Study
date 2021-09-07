package Algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Thanksgiving_travel {
    static int personNum;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        personNum = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(personNum != 0) {
            arr = new int[personNum];
            for(int i=0; i<personNum; i++)
                arr[i] = Integer.parseInt(br.readLine());
            // 입력부 종료
            sb.append(calc()).append('\n');
            personNum = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }
    static int calc() {
        int avg = 0;
        for(int i=0; i<arr.length; i++) {
            avg += arr[i];
        }
        avg = avg / arr.length;
        if(avg % 10 != 0) {
            avg -= avg % 10;
            Arrays.sort(arr);
            int temp = 0;
            for(int i=0; i<arr.length; i++) {
                 if(arr[i] < avg)
                     temp += avg - arr[i];
            }
            return temp;
        } else {
            return avg - arr[0];
        }

    }
}
