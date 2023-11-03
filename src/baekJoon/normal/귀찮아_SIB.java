package baekJoon.normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 귀찮아_SIB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sum = new int[n];
        sum[0] = arr[0];
        for(int i=1; i<n; i++) {
            sum[i] = sum[i-1] + arr[i];
        }
        long result = 0;
        // a1a2 + a1a3 + a1a4 + ... + a1an = al*(a1+a2+a3+a4+...+an)
        for(int i=0; i<n; i++) {
            result += arr[i] * (sum[n-1] - sum[i]);
        }
        System.out.println(result);
    }
}
