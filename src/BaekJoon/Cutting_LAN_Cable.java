package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 1654번
public class Cutting_LAN_Cable {
    static int K,N;
    static int[] cables;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        cables = new int[K];
        for(int i=0; i<K; i++)
            cables[i] = Integer.parseInt(br.readLine());
        // 입력부
        Arrays.sort(cables);
        System.out.println(FindLength(N));
    }
    static long FindLength(int targetSum) {
        long left, right, mid, temp;
        left = 1;
        right = cables[K-1];
        while(left < right) {
            temp = 0;
            mid = (left + right)/2;
            for(int i=0; i<K; i++) {
                temp += cables[i] / mid;
            }
            if(temp >= targetSum) {
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return right;
    }
}
