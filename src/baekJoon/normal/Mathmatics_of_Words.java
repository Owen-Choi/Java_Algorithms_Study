package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1339번
public class Mathmatics_of_Words {
    static int WordNum;
    static int giveNum = 9;
    static String[] arr;
    static int[] Alphabets = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        WordNum = Integer.parseInt(br.readLine());
        arr = new String[WordNum];
        for(int i=0; i<WordNum; i++) {
            arr[i] = br.readLine();
        }
        // 입력부 종료
        // 길이가 긴 순으로 정렬
        // 연산부
        char temp;
        int Val;
        for(int i=0; i<WordNum; i++) {
            Val = (int)Math.pow(10, arr[i].length() - 1);
            for(int k=0; k<arr[i].length(); k++) {
                temp = arr[i].charAt(k);
                Alphabets[temp - 'A'] += Val;
                Val /= 10;
            }
        }
        Arrays.sort(Alphabets);
        Print();

    }
    static void Print() {
        int Val = 9, temp = 0;
        for(int i=Alphabets.length - 1; i>=0; i--) {
            temp += Alphabets[i] * Val--;
            if(Val < 0)
                break;
        }
        System.out.println(temp);
    }
}
