package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 2470 ::
public class Two_Liquids {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Solve();
    }
    static void Solve() {
        Arrays.sort(arr);
        int leftPivot = 0, rightPivot = N-1;
        int Result1 = 0, Result2 = 0, Min = Integer.MAX_VALUE;
        int value;
            while (leftPivot < rightPivot) {
               value = arr[leftPivot] + arr[rightPivot];
               if(value < 0) {
                   if(Math.abs(value) < Min) {
                       Min = Math.abs(value);
                       Result1 = leftPivot;
                       Result2 = rightPivot;
                   }
                   leftPivot++;
               }
               else if(value > 0) {
                   if(Math.abs(value) < Min) {
                       Min = Math.abs(value);
                       Result1 = leftPivot;
                       Result2 = rightPivot;
                   }
                   rightPivot--;
               }
               else {
                   Result1 = leftPivot;
                   Result2 = rightPivot;
                   break;
               }
            }
        System.out.println(arr[Result1] + " " + arr[Result2]);
    }
}
