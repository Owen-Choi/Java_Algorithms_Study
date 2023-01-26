package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        Solve();
    }
    static void Solve() {
        int Left = 0, Right = 0, tempSum = 0;
        while(true) {
            if(tempSum >= S) {
                tempSum -= arr[Left];
                Result = Math.min(Result, Right - Left);
                Left++;
            }
            else if(Right == N)
                break;
            else
                tempSum += arr[Right++];
        }
        if(Result == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(Result);
    }
}
