package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11720번
public class Sum_of_number {
    static String inputStr;
    static int size;
    static char[] convertedArr;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        inputStr = br.readLine();
        convertedArr = inputStr.toCharArray();
        for (Character each : convertedArr) {
            result += each - '0';
        }
        System.out.println(result);
    }
}
