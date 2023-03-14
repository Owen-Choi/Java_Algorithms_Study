package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
        Arrays.sort(arr);
        for(int i=0; i<RopeNum; i++){
            int totalWeight = arr[i] * (arr.length - i);
            MaxWeight = Math.max(MaxWeight, totalWeight);
        }
        System.out.println(MaxWeight);
    }
}
