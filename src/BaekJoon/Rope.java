package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 2217번
public class Rope {
    static int RopeNum;
    static int MaxWeight = -1;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        RopeNum = Integer.parseInt(br.readLine());
        arr = new int[RopeNum];
        for(int i=0; i<RopeNum; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int Count = 0;
        for(int i=0; i<RopeNum; i++){
            Count = 0;
            for(int k=0; k<RopeNum; k++){
                if(arr[i] <= arr[k]) {
                    Count++;
                }
            }
            MaxWeight = Math.max(MaxWeight, Count * arr[i]);
        }
        System.out.println(MaxWeight);
    }
}
