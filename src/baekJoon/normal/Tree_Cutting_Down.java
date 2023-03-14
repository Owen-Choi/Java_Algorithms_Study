package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 2805번
public class Tree_Cutting_Down {
    static int N,K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        // 입력부
        Arrays.sort(arr);
        System.out.println(cut());
    }
    static long cut() {
        long left, right, mid, tempVal;
        long result;
        left = 0;
        right = arr[N-1];
        while(left <= right) {
            mid = (left + right) / 2;
            result = 0;
            for(int i=0; i<N; i++) {
                tempVal = arr[i] - mid;
                if(arr[i] > mid)
                result += tempVal;
            }
            if(result >= K)
                left = mid+1;
            else
                right = mid-1;
        }
        return right;
    }
}
