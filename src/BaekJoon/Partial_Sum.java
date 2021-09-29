package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 1806 ::
public class Partial_Sum {
    static int N, S;
    static int[] arr;
    static int Result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

    }
    static void Solve() {
        int tempSum = 0;
        int leftPivot = 0, rightPivot = N-1;
        // :: we gonna add all of values between leftPivot and rightPivot and store to tempSum
        // if sum value is bigger than the target, than we'll  move rightPivot
        // if sum value is samller than the target, than we'll move leftPivot ::
        while(leftPivot < rightPivot) {
            for(int i=leftPivot; i<=rightPivot; i++)
                tempSum += arr[i];
            if(tempSum >= S) {
                Result = Math.min(Result, rightPivot - leftPivot + 1);
                // we gonna reduce rightPivot?

            }
        }
    }
}
