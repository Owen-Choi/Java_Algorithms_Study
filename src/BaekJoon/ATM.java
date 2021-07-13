package BaekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11399번
public class ATM {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Input = Integer.parseInt(br.readLine());
        arr = new int[Input];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<Input; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 오름차순으로 정렬하고 다 더하면 되잖아??
        Arrays.sort(arr);
        int Dest = 1;
        int totalTime = arr[0];
        while(Dest < Input) {
            for (int i = 0; i <= Dest; i++) {
                totalTime += arr[i];
            }
            Dest++;
        }
        System.out.println(totalTime);
    }
}
