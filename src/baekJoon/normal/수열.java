package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n, k;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 3 -2 -4 -9 0 3 7 13 8 -3
        int max, sum = 0;
        int left = 0, right = k;
        for(int i=0; i<right; i++) {
            sum += arr[i];
        }
        max = sum;
        while(true) {
            if(right < arr.length) {
                sum -= arr[left++];
                sum += arr[right++];
                max = Math.max(sum, max);
            } else break;
        }

        System.out.println(max);
    }
}
