package BaekJoon;

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
        for(int i=0; i<(leftPivot + rightPivot) / 2; i++) {
            leftPivot = i;
            rightPivot = N-1;
            while (leftPivot < rightPivot) {
                if (Math.abs(arr[leftPivot] + arr[rightPivot]) < Min) {
                    Min = Math.abs(arr[leftPivot] + arr[rightPivot]);
                    Result1 = arr[leftPivot];
                    Result2 = arr[rightPivot];
                }
                leftPivot++;
                rightPivot--;
            }
        }
        System.out.println(Result1 + " " + Result2);
    }
}
