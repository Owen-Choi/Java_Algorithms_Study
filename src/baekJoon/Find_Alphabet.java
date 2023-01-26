package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Find_Alphabet {

    static String inputStr;
    static int[] indexArr = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        inputStr = br.readLine();
        Arrays.fill(indexArr, -1);
        // 97을 빼면 바로 인덱스가 나온다.
        for(int i=0; i<inputStr.length(); i++) {
            if(indexArr[(int)inputStr.charAt(i) - 97] == -1)
                indexArr[(int)inputStr.charAt(i) - 97] = i;
        }
        for(int i=0; i<indexArr.length; i++) {
            sb.append(indexArr[i] + " ");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
