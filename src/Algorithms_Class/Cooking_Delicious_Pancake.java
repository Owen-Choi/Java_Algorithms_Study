package Algorithms_Class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cooking_Delicious_Pancake {
    static int[] arr;
    static int[] flipIndex;
    static int[] reverse;
    static int Last;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            arr = new int[st.countTokens()+1];
            flipIndex = new int[st.countTokens()+1];
            int i=1;
            while(st.hasMoreTokens())
                arr[i++] = Integer.parseInt(st.nextToken());

                stackPancake();
                for(int k=1; k < arr.length; k++)
                    System.out.print(arr[k] + " ");
                System.out.println();
                for(int j = 0; j<arr.length-1; j++) {
                    System.out.print(flipIndex[j] + " ");
                    if(flipIndex[j] == 0)
                        break;
                }
            System.out.println();
        }
    }
    static void stackPancake() {
        int MaxIndex, j = 0;
        Last = arr.length - 1;
        for(int i = 1; i < arr.length; i++) {
            MaxIndex = FindMax();
            if(MaxIndex == 1 && Last != 1) {
                // 바로 Last로 보내기
                flip(Last);
                flipIndex[j++] = arr.length - Last;
                Last--;
            }
            else if(MaxIndex == Last){
                Last--;
                continue;
            }
            else{
                if(Last == 1)
                    break;
                flip(MaxIndex - 1);
                // 코드 중복 참고
                flip(Last);
                flipIndex[j++] = arr.length - Last;
                Last--;
                // 한번 뒤집어 index 1로 만들어주고 Last-1을 뒤집어 뒤로 보내주기
            }
        }
    }
    static void flip(int index) {
        reverse = new int[arr.length];
        for(int i=1; i<=index; i++)
            reverse[i] = arr[i];
       for(int i=1; i<=index; i++)
           arr[i] = reverse[index - i + 1];
    }
    static int FindMax() {
        int MAX = 1;
        if(Last == 1)
            return 1;
        for(int i=1; i <= Last; i++) {
            if(arr[MAX] < arr[i])
                MAX = i;
        }
            return MAX;
    }
}
