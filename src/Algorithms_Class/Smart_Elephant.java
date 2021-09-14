package Algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Smart_Elephant{
    static int iter = 0;
     static int [][] arr = new int[1001][4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int[] ints : arr) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        String EOF = "";
        while ((EOF = br.readLine()) != null) {
            if (EOF.equals("."))
                break;
            st = new StringTokenizer(EOF, " ");
            arr[iter][0] = Integer.parseInt(st.nextToken());
            arr[iter][1] = Integer.parseInt(st.nextToken());
            arr[iter][3] = iter++;
            // 입력부 종료
        }

    }

}
